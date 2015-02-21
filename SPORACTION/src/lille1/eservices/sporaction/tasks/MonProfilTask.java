package lille1.eservices.sporaction.tasks;

import java.util.ArrayList;

import lille1.eservices.sporaction.json_mysql.Profils;
import android.os.AsyncTask;

public class MonProfilTask extends AsyncTask<Integer, Void, ArrayList<String>>{

	private Profils profils;
	
	@Override
	protected ArrayList<String> doInBackground(Integer... id) {
		profils = new Profils();
		
		ArrayList<String> result = new ArrayList<String>();
		
		// Recherche dans la base
		result = profils.getProfilById(id[0]);
		return result;
	}
}
