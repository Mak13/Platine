package lille1.eservices.sporaction;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import lille1.eservices.sporaction.model.Profil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import lille1.eservices.sporaction.tasks.MonProfilTask;


public class Monprofil extends Activity {
	
	private Profil profil;
	private int profilId;
	TextView Pseudo, Email, Adresse, plageHoraire, RayonGeo,
	sport1, sport2, sport3, sport4;
	CheckedTextView linkToEditProfil;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monprofil);
        
        
     	
        linkToEditProfil = (CheckedTextView) findViewById(R.id.btnLinkToEditProfilScreen);
     	
     	
        // Click sur le lien Register
     	linkToEditProfil.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View view) {
        		// Lancement de l'Activity "Editprofil"
       	    	Intent EditProfil = new Intent(getApplicationContext(), Editprofil.class);
       	    	System.out.println("pseudo"+ profil.getPseudo());
       	    	EditProfil.putExtra("pseudo", profil.getPseudo());
       	    	startActivity(EditProfil);

        		// Fermeture de l'Activity "MonProfil"
        		finish();
        	}
        });
    }
    
    @Override
	protected void onStart() {
    	super.onStart();
    	
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
     	 
     	if (monBundle != null) {
     		
     		profilId = Integer.parseInt(monBundle.getString("profilId"));
         	ArrayList<String> result = new ArrayList<String>();
         	     	
         	 // Recherche dans la base
         	 try {
         		 	result = new MonProfilTask().execute(profilId).get();
         	 	} catch (InterruptedException e) {
         	 		e.printStackTrace();
         	 	} catch (ExecutionException e) {
         	 		e.printStackTrace();
         	 	}
         	 
         	if(Integer.parseInt(result.get(0)) == 1){
         		if (result.get(2) != null)     			Pseudo.setText(result.get(2));
         		if (result.get(4) != null)     			Email.setText(result.get(4));
         		if (result.get(5) != null)        		Adresse.setText(result.get(5));
         		if (result.get(8) != null)	    		plageHoraire.setText(result.get(8));
         		if (result.get(9) != null)   			RayonGeo.setText(result.get(9));
         		if (result.get(10) != null)				sport1.setText(result.get(10));
         		if (result.get(11) != null)				sport2.setText(result.get(11));
         	}
     	}
	}
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
	} 
}