package lille1.eservices.sporaction;

import java.util.ArrayList;

import lille1.eservices.sporaction.model.Partie;
import lille1.eservices.sporaction.sqlite.PartiesDB;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ParticipationList extends Activity {
	private PartiesDB partieDb;
	private ArrayList<Partie> parties = new ArrayList<Partie>();
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_participationlist);
		
		// Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
		
		partieDb = new PartiesDB();
		partieDb.open(this);
        
        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

        	@Override
        	public void onItemClick(AdapterView<?> parent, View view,
        			int position, long id) {
        		/*Partie partie = parties.get(position);
                
                Intent intent = new Intent(ParticipationList.this, DetailsActivity.class);
                intent.putExtra("id", Integer.toString(task.getId()));
                intent.putExtra("type", task.getType());
           		intent.putExtra("longitude", task.getLongitude());
           		intent.putExtra("latitude", task.getLatitude());
           		intent.putExtra("adress", task.getAdress());
           		intent.putExtra("description", task.getDescription());
                
                startActivity(intent);*/
              }
         }); 
	}
	
	@Override
    protected void onStart() {
		int index;
		
		// Defined Array values to show in ListView
        ArrayList<String> values = new ArrayList<String>();
        
        super.onStart();
        
        parties = partieDb.getParties();
        
        for(index = 0; index < parties.size(); index++){
        	values.add(index, parties.get(index).getDate() + ", " + 
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
