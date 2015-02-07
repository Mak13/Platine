package lille1.eservices.sporaction.tasks;

import java.util.ArrayList;

import lille1.eservices.sporaction.json_mysql.Profils;
import lille1.eservices.sporaction.model.Profil;
import android.os.AsyncTask;

public class LoginTask extends AsyncTask<Profil, Void, ArrayList<String>>{

	private Profils profils;
	
	@Override
	protected ArrayList<String> doInBackground(Profil... profil) {
		profils = new Profils();
		
		ArrayList<String> result = new ArrayList<String>();
		
		// Recherche dans la base
		result = profils.getProfil(profil[0].getPseudo(), profil[0].getMotDePasse());
		return result;
	}
}
