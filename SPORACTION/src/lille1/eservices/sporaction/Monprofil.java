package lille1.eservices.sporaction;

import lille1.eservices.sporaction.model.Profil;
import lille1.eservices.sporaction.sqlite.ProfilsDB;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;


public class Monprofil extends Activity {
	
	private ProfilsDB profilDb;
	private Profil monProfil;
	TextView Pseudo, Email, Adresse, plageHoraire, RayonGeo,
	sport1, sport2, sport3, sport4;
	CheckedTextView linkToEditProfil;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monprofil);
        
        // Sélection des caract�ristiques des champs 
        Pseudo = (TextView) findViewById(R.id.pseudo);
        Email = (TextView) findViewById(R.id.email);
        Adresse = (TextView) findViewById(R.id.adresse);
        plageHoraire = (TextView) findViewById(R.id.PlageHoraire);
        RayonGeo = (TextView) findViewById(R.id.rayongeographique);
        sport1 = (TextView) findViewById(R.id.sport1);
        sport2 = (TextView) findViewById(R.id.sport2);
        sport3 = (TextView) findViewById(R.id.sport3);
        sport4 = (TextView) findViewById(R.id.sport4);
        Bundle monBundle = getIntent().getExtras();     
        linkToEditProfil = (CheckedTextView) findViewById(R.id.btnLinkToEditProfilScreen);
        
        // Creation of a new profil
     	
        profilDb = new ProfilsDB();
     	profilDb.open(this);
     	 
     	if (monBundle != null) {

         	monProfil = profilDb.getProfilByPseudo(monBundle.getString("pseudo")); 
     	}
     	if(monProfil != null){
     		if (monProfil.getPseudo() != null)     			Pseudo.setText(monProfil.getPseudo());
     		if (monProfil.getMail() != null)     			Email.setText(monProfil.getMail());
     		if (monProfil.getAdresse() != null)        		Adresse.setText(monProfil.getAdresse());
     		if (monProfil.getPlagesHoraires() != null)	    plageHoraire.setText(monProfil.getPlagesHoraires());
     		if (monProfil.getRayonGeographique() != null)   RayonGeo.setText(monProfil.getRayonGeographique());
   //  		if (monProfil.getSportsPratiques() != null)		sport1.setText(monProfil.getSportsPratiques());
     	}
     	
     	
        // Click sur le lien Register
     	linkToEditProfil.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View view) {
        		// Lancement de l'Activity "Editprofil"
       	    	Intent EditProfil = new Intent(getApplicationContext(), Editprofil.class);
       	    	System.out.println("pseudo"+ monProfil.getPseudo());
       	    	EditProfil.putExtra("pseudo", monProfil.getPseudo());
       	    	startActivity(EditProfil);

        		// Fermeture de l'Activity "MonProfil"
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
}
