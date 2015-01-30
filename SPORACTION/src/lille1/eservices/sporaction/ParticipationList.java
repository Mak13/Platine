package lille1.eservices.sporaction;

import java.util.ArrayList;

import lille1.eservices.sporaction.model.Partie;
import lille1.eservices.sporaction.model.Profil_Partie;
import lille1.eservices.sporaction.model.Sport;
import lille1.eservices.sporaction.model.Terrain;
import lille1.eservices.sporaction.sqlite.PartiesDB;
import lille1.eservices.sporaction.sqlite.Profils_PartiesDB;
import lille1.eservices.sporaction.sqlite.SportsDB;
import lille1.eservices.sporaction.sqlite.TerrainsDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ParticipationList extends Activity {
	private PartiesDB partieDb;
	private SportsDB sportDb;
	private TerrainsDB terrainDb;
	private Profils_PartiesDB profilPartieDb;
	public Bundle monBundle;
	private ArrayList<Partie> parties = new ArrayList<Partie>();
	ListView listView;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_partieslist);
		
	    monBundle = getIntent().getExtras();

		// Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
		
		partieDb = new PartiesDB();
		partieDb.open(this);
		
		sportDb = new SportsDB();
		sportDb.open(this);
		
		terrainDb = new TerrainsDB();
		terrainDb.open(this);
		
		profilPartieDb = new Profils_PartiesDB();
		profilPartieDb.open(this);
        
        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

        	@Override
        	public void onItemClick(AdapterView<?> parent, View view,
        			int position, long id) {
        		
        		Partie partie = parties.get(position);       		
        		
                
                Intent intent = new Intent(ParticipationList.this, ParticipationsDetails.class);
                intent.putExtra("id", Integer.toString(partie.getId()));
                intent.putExtra("profilId", monBundle.getInt("profilId"));
           		/*intent.putExtra("longitude", task.getLongitude());
           		intent.putExtra("latitude", task.getLatitude());
           		intent.putExtra("adress", task.getAdress());
           		intent.putExtra("description", task.getDescription());*/
                
                startActivity(intent);
              }
         }); 
	}
	
	@Override
    protected void onStart() {
		int index;
		
		// Defined Array values to show in ListView
        ArrayList<String> values = new ArrayList<String>();
        
        super.onStart();
        
 
        //Data for tests
        ArrayList<Profil_Partie> profilsPartiesTest = new ArrayList<Profil_Partie>();
        
        sportDb.insert(new Sport(1, "Football", 6, 22, "Ballon"));
        int sportId = sportDb.getSportByNom("Football").getId();
        
        terrainDb.insert(new Terrain(1, "Jean Bouin", "Rue Machin", "59000", "Lille"));
        int terrainId = terrainDb.getTerrainByNom("Jean Bouin").getId();
        
        for (int i = 1; i < 6; i++) {
        	partieDb.insert(new Partie(i, "23/01/2015", "08h00-10h00", sportId, "Moyen", "Lille", terrainId));
            profilPartieDb.insert(new Profil_Partie(i,monBundle.getInt("profilId") , i, "organisee"));
        }
        
        profilsPartiesTest = profilPartieDb.getPartiesByProfil(monBundle.getInt("profilId"));

        Log.v("profilsPartiesTest", profilsPartiesTest.get(0).toString());
 
        for(index = 0; index < 5; index++) {
        	parties.add(partieDb.getPartieById(profilsPartiesTest.get(index).getPartieId()));
        }
        
        for(index = 0; index < parties.size(); index++) {
        	Partie partieTest = parties.get(index);
        	int ID = partieTest.getSportId();
        	String sportName = sportDb.getSportById(ID).getNom();
        	values.add(index, sportName + ", " + 
        			parties.get(index).getDate() + ", " +
        			parties.get(index).getHoraire());
        }
        
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - the Array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            	android.R.layout.simple_list_item_1, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);
    }
	
	@Override
    protected void onDestroy() {
		//taskDb.close();
        super.onDestroy();
    }
}
