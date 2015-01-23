package lille1.eservices.sporaction;

import lille1.eservices.sporaction.model.Partie;
import lille1.eservices.sporaction.model.Profil;
import lille1.eservices.sporaction.sqlite.PartiesDB;
import lille1.eservices.sporaction.sqlite.ProfilsDB;
import lille1.eservices.sporaction.sqlite.SportsDB;
import lille1.eservices.sporaction.sqlite.TerrainsDB;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class PartiesDetails extends Activity {
	

	private Partie partie;
	private PartiesDB partieDb;
	private SportsDB sportDb;
	private TerrainsDB terrainsDB;
	private TextView date, heure, nom, id, niveau, ville, terrain, materiels;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partiesdetails);
        
        partieDb = new PartiesDB();
        partieDb.open(this);
        
        sportDb = new SportsDB();
        sportDb.open(this);
        
        terrainsDB = new TerrainsDB();
        terrainsDB.open(this);


        date = (TextView) findViewById(R.id.dateval);
        heure = (TextView) findViewById(R.id.heureVal);
        niveau = (TextView) findViewById(R.id.niveauVal);
        nom = (TextView) findViewById(R.id.nomSport);
        ville = (TextView) findViewById(R.id.villeVal);
        terrain = (TextView) findViewById(R.id.terrainVal);
        materiels = (TextView) findViewById(R.id.materielVal);
        Bundle monBundle = getIntent().getExtras();  
        
        if (monBundle != null) {
        	partie = partieDb.getPartieById(Integer.parseInt(monBundle.getString("id"))); 
     	}
        
        if(partie != null){
     		if (partie.getDate() != null)     			date.setText(partie.getDate());
     		if (partie.getHoraire() != null)     		heure.setText(partie.getHoraire());
     		if (partie.getNiveau() != null)        		niveau.setText(partie.getNiveau());
     		if (partie.getVille() != null)  			ville.setText(partie.getVille());
     		if (partie.getTerrainId() != 0)  			terrain.setText(terrainsDB.getPartieById(partie.getTerrainId()).getNom());
     		if (partie.getSportId() != 0) {
     			nom.setText(sportDb.getSportById(partie.getSportId()).getNom());
     			materiels.setText(sportDb.getSportById(partie.getSportId()).getMateriels());
     		}
     	}
        
        
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