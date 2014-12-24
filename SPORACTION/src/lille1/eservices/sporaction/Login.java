package lille1.eservices.sporaction;

import android.app.Activity;
import android.content.Intent;
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
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        // Importation des caractéristiques des champs et boutons
        inputPseudo = (EditText) findViewById(R.id.loginPseudo);
        inputPassword = (EditText) findViewById(R.id.loginPassword);
        checkBox = (CheckBox)findViewById(R.id.loginRememberMe);
        loginButton = (Button) findViewById(R.id.btnLogin);
        linkToRegisterButton = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        
        // Creation of a new profil
     	profil = new Profil();
     	
        profilDb = new ProfilsDB();
     	profilDb.open(this);
     	
        loginButton.setOnClickListener(new View.OnClickListener() {      
        	public void onClick(View view) {
        		// Récupération du contenu des EditText
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
			                			"Succés de la connexion", 
			    	        			Toast.LENGTH_SHORT).show();	
	                		} else {
	                			Toast.makeText(getApplicationContext(), 
			                			"Pseudo ou mot de passe invalide. Merci de ressayer", 
			    	        			Toast.LENGTH_SHORT).show();	
	                		}
	                	} else {
	                		Toast.makeText(getApplicationContext(), 
		                			"Le mot de passe est très court (min 8 caractères)", 
		    	        			Toast.LENGTH_SHORT).show();
	                	}
		            } else {
		            	Toast.makeText(getApplicationContext(), 
	                			"Le pseudo est très court (min 6 caractères)", 
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
    
 // Test si le pseudo fait plus de 6 caractères
    public static boolean isValidPseudo(String pseudo) {
    	if(pseudo.length() >= 6)
    		return true;
    	else
    		return false;
    }

    // Teste si le mot de passe fait plus de 8 caractères
    public static boolean isValidPassword(String password) {
    	if(password.length() >= 8)
    		return true;
    	else
    		return false;
    }
}
