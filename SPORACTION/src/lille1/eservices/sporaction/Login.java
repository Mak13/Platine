package lille1.eservices.sporaction;

import lille1.eservices.sporaction.model.Profil;
import lille1.eservices.sporaction.sqlite.ProfilsDB;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Activity {
	
	private ProfilsDB profilDb;
	private Profil profil;
	EditText inputPseudo, inputPassword;
	CheckBox checkBox;
	Button loginButton, linkToRegisterButton;
	
	// Enregistrement des pr�f�rences
	public static final String PREFS_NAME = ".Preferences";   
	private static final String PREF_PSEUDO = "pseudo";
	private static final String PREF_PASSWORD = "password";
	private static final String PREF_CHECKED = "checked";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        // Importation des caract�ristiques des champs et boutons
        inputPseudo = (EditText) findViewById(R.id.loginPseudo);
        inputPassword = (EditText) findViewById(R.id.loginPassword);
        checkBox = (CheckBox)findViewById(R.id.loginRememberMe);
        loginButton = (Button) findViewById(R.id.btnLogin);
        linkToRegisterButton = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        
        // Restauration des pr�f�rences sauvegard�es si la checkbox est coch�e
        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);  
        String pseudo = pref.getString(PREF_PSEUDO, "");
        String password = pref.getString(PREF_PASSWORD, "");
        String checked = pref.getString(PREF_CHECKED, "");

        inputPseudo.setText(pseudo);
        inputPassword.setText(password);
        checkBox.setChecked(Boolean.parseBoolean(checked));
        
        // Creation of a new profil
     	profil = new Profil();
     	
        profilDb = new ProfilsDB();
     	profilDb.open(this);
     	
        loginButton.setOnClickListener(new View.OnClickListener() {      
        	public void onClick(View view) {
        		// Enregistrement des pr�f�rences si la checkbox est coch�e  
	            if(checkBox.isChecked()) {
	            	getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
	                	.edit()
	                	.putString(PREF_PSEUDO, inputPseudo.getText().toString())
	                	.putString(PREF_PASSWORD, inputPassword.getText().toString())
	                	.putString(PREF_CHECKED,"TRUE")
	                	.commit();
	            } else if(!checkBox.isChecked()) {
	            	// Sinon on les efface */   
	            	getSharedPreferences(PREFS_NAME,MODE_PRIVATE).edit().clear().commit();
	            }
	            
        		// R�cup�ration du contenu des EditText
	        	String pseudo = inputPseudo.getText().toString();
	        	String password = inputPassword.getText().toString();
	        	
        		// Test si tous les champs sont saisis
	        	if(!(pseudo.equals("") || password.equals(""))) {
	        		// Test du pseudo
		            if(isValidPseudo(pseudo)) {
		            	// Test du mot de passe
	                	if(isValidPassword(password)) {
	                		profil = profilDb.getProfil(pseudo, password);
	                		
	                		if(profil != null) {
	                			Toast.makeText(getApplicationContext(), 
			                			"Succ�s de la connexion", 
			    	        			Toast.LENGTH_SHORT).show();
	                			
	                			// Lancement de l'Activity "ParticipationList"
			    	        	Intent participationList = new Intent(getApplicationContext(), ParticipationList.class);
			    	        	participationList.putExtra("profilId", profilDb.getProfilByPseudo(pseudo).getId());
			                    startActivity(participationList);
	
			                    // Fermeture de l'Activity "Login"
			    	        	finish();
	                		} else {
	                			Toast.makeText(getApplicationContext(), 
			                			"Pseudo ou mot de passe invalide. Merci de ressayer", 
			    	        			Toast.LENGTH_SHORT).show();	
	                		}
	                	} else {
	                		Toast.makeText(getApplicationContext(), 
		                			"Le mot de passe est tr�s court (min 8 caract�res)", 
		    	        			Toast.LENGTH_SHORT).show();
	                	}
		            } else {
		            	Toast.makeText(getApplicationContext(), 
	                			"Le pseudo est tr�s court (min 6 caract�res)", 
	    	        			Toast.LENGTH_SHORT).show();
		            }
	        		
	        	} else {
	        		Toast.makeText(getApplicationContext(), 
                			"Les champs pseudo et mot de passe sont obligatoires", 
    	        			Toast.LENGTH_SHORT).show();
	        	}
        	}
        });
        
        // Click sur le lien Register
        linkToRegisterButton.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View view) {
        		// Lancement de l'Activity "Register"
        		Intent register = new Intent(getApplicationContext(), Register.class);
        		startActivity(register);

        		// Fermeture de l'Activity "Login"
        		finish();
        	}
        });
    }
    
    @Override
	protected void onStart() {
    	super.onStart();
	}
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
	}
    
 // Test si le pseudo fait plus de 6 caract�res
    public static boolean isValidPseudo(String pseudo) {
    	if(pseudo.length() >= 6)
    		return true;
    	else
    		return false;
    }

    // Teste si le mot de passe fait plus de 8 caract�res
    public static boolean isValidPassword(String password) {
    	if(password.length() >= 8)
    		return true;
    	else
    		return false;
    }
}
