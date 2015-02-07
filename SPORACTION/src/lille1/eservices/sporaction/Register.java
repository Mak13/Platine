package lille1.eservices.sporaction;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

import lille1.eservices.sporaction.json_mysql.Profils;
import lille1.eservices.sporaction.model.Profil;
import lille1.eservices.sporaction.tasks.RegisterTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {

	private Profil profil;
	private EditText inputPseudo, inputEmail, inputPassword;
	private CheckBox checkBox;
	private Button registerButton, linkToLoginButton;
	
	// Enregistrement des préférences
	public static final String PREFS_NAME = ".Preferences";   
	private static final String PREF_PSEUDO = "pseudo";
	private static final String PREF_PASSWORD = "password";
	private static final String PREF_CHECKED = "checked";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        // Importation des caractéristiques des champs et boutons
        inputPseudo = (EditText) findViewById(R.id.registerPseudo);
        inputEmail = (EditText) findViewById(R.id.registerEmail);
        inputPassword = (EditText) findViewById(R.id.registerPassword);
        checkBox = (CheckBox) findViewById(R.id.registerRememberMe);
        registerButton = (Button) findViewById(R.id.btnRegister);
        linkToLoginButton = (Button) findViewById(R.id.btnLinkToLoginScreen);
        
        // Creation of a new profil
     	profil = new Profil();
     	
     	new Profils();
     	
        // Click sur le bouton de creation de compte
     	registerButton.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            // Enregistrement des préférences si la checkbox est cochée  
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

	            // Récupération du contenu des EditText
	        	String pseudo = inputPseudo.getText().toString();
	        	String email = inputEmail.getText().toString();
	        	String password = inputPassword.getText().toString();
	        	
	        	// Test si tous les champs sont saisis
	        	if(!(pseudo.equals("") || email.equals("") || password.equals(""))) {
		            // Test du pseudo
		            if(isValidPseudo(pseudo)) {
		                // Test de l'adresse mail
		                if(isValidEmail(email)) {
		                	// Test du mot de passe
		                	if(isValidPassword(password)) {
		                		ArrayList<String> result = new ArrayList<String>();
		                		
		                		// Préparation pour ajout dans la base
			    	        	profil.setPseudo(pseudo);
			    	        	profil.setMail(email);
			    	        	profil.setMotDePasse(password);
			    	        	
		                		// Ajout dans la base
			    	        	try {
									result = new RegisterTask().execute(profil).get();
								} catch (InterruptedException e) {
									e.printStackTrace();
								} catch (ExecutionException e) {
									e.printStackTrace();
								}
			    	        	
		                		if(Integer.parseInt(result.get(0)) == 1) {
		                			Toast.makeText(getApplicationContext(), 
				    	        			"Succés de l'inscription", 
				    	        			Toast.LENGTH_SHORT).show();
		                			
		                			// Lancement de l'Activity "Login"
				    	        	Intent login = new Intent(getApplicationContext(), Login.class);
				                    startActivity(login);
				                    
				                    // Fermeture de l'Activity "Register"
				    	        	finish();
		                		} else {
		                			Toast.makeText(getApplicationContext(), 
		                					result.get(1), 
				    	        			Toast.LENGTH_SHORT).show();
		                		}
		                	} else {
		                		Toast.makeText(getApplicationContext(), 
			                			"Le mot de passe est très court (min 8 caractères)", 
			    	        			Toast.LENGTH_SHORT).show();
		                	}
		                } else {
		                	Toast.makeText(getApplicationContext(), 
		                			"Le format du mail est invalide",
		    	        			Toast.LENGTH_SHORT).show();
	                    }
		            } else {
	                	Toast.makeText(getApplicationContext(), 
	                			"Le pseudo est très court (min 6 caractères)", 
	    	        			Toast.LENGTH_SHORT).show();
	                }
	        	} else {
	        		Toast.makeText(getApplicationContext(), 
                			"Tous les champs sont obligatoires", 
    	        			Toast.LENGTH_SHORT).show();
	        	}
	        }
        });

        // Click sur le lien Login
        linkToLoginButton.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View view) {
        		// Lancement de l'Activity "Login"
        		Intent login = new Intent(getApplicationContext(), Login.class);
        		startActivity(login);

        		// Fermeture de l'Activity "Register"
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

    // Test de l'adresse mail
    public final static Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
          "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
          "\\@" +
          "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
          "(" +
          "\\." +
          "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
          ")+"
        );

    public static boolean isValidEmail(String email) {
       return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
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