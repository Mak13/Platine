package lille1.eservices.sporaction.sqlite;

import java.util.ArrayList;

import lille1.eservices.sporaction.model.Profil_Partie;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Profils_PartiesDB {
	public static final String KEY_ID = "id";
	public static final String KEY_PROFIL_ID = "profilId";
	public static final String KEY_PARTIE_ID = "partieId";
	public static final String TABLE_NAME = "Profil_Partie";
	public static final String KEY_TYPE = "type";
	private static final int DB_VERSION = 1;
	
	private SQLiteDatabase db;
	private DB mydb;
 
	public Profils_PartiesDB(){
		
	}
	
	public void open(Context context) {
		mydb = new DB(context, TABLE_NAME, null, DB_VERSION);
		db = mydb.getWritableDatabase();
	}
		
	public void close() {
		db.close();
	}
	
	public void insert(Profil_Partie profil_partie){	
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_PROFIL_ID, profil_partie.getProfilId());
		values.put(KEY_PARTIE_ID, profil_partie.getPartieId());
		values.put(KEY_TYPE, profil_partie.getType());
		
		// Insert the new row, returning the primary key value of the new row
		db.insert(TABLE_NAME, null, values);
	}
	
	public void update(Profil_Partie profil_partie){
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_PROFIL_ID, profil_partie.getProfilId());
		values.put(KEY_PARTIE_ID, profil_partie.getPartieId());
		values.put(KEY_TYPE, profil_partie.getType());

		// Insert the new row, returning the primary key value of the new row
		db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[]
				{String.valueOf(profil_partie.getId())});
	}
	
	public void delete(int id){
		db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]
				{String.valueOf(id)});
	}
	
	public ArrayList<Profil_Partie> getProfilsByPartie(int partieId) {
		String[] columns = {KEY_ID, KEY_PROFIL_ID, KEY_PARTIE_ID, KEY_TYPE};
		
        ArrayList<Profil_Partie> list = new ArrayList<Profil_Partie>();
        Cursor curseur = db.query(TABLE_NAME, columns, "partieId = '"+partieId+"'"
        		, null,  null, null, KEY_PROFIL_ID);
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
        	Profil_Partie profil_partie = new Profil_Partie();
        	profil_partie.setId(curseur.getInt(0));
        	profil_partie.setProfilId(curseur.getInt(1));
        	profil_partie.setPartieId(curseur.getInt(2));
        	profil_partie.setType(curseur.getString(3));
            list.add(profil_partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Profil_Partie> getPartiesByProfil(int profilId) {
		String[] columns = {KEY_ID, KEY_PROFIL_ID, KEY_PARTIE_ID, KEY_TYPE};
		
        ArrayList<Profil_Partie> list = new ArrayList<Profil_Partie>();
        Cursor curseur = db.query(TABLE_NAME, columns, "profilId = '"+profilId+"'", null,  null, null, KEY_PARTIE_ID);
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
        	Profil_Partie profil_partie = new Profil_Partie();
        	profil_partie.setId(curseur.getInt(0));
        	profil_partie.setProfilId(curseur.getInt(1));
        	profil_partie.setPartieId(curseur.getInt(2));
        	profil_partie.setType(curseur.getString(3));
            list.add(profil_partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Profil_Partie> getPartiesByTypeAndProfil(String type, int profilId) {
		String[] columns = {KEY_ID, KEY_PROFIL_ID, KEY_PARTIE_ID, KEY_TYPE};
		
        ArrayList<Profil_Partie> list = new ArrayList<Profil_Partie>();
        Cursor curseur = db.query(TABLE_NAME, columns, "type = '"+type+"'"+" AND profilId = '"+profilId+"'"
        		, null,  null, null, KEY_PARTIE_ID);
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
        	Profil_Partie profil_partie = new Profil_Partie();
        	profil_partie.setId(curseur.getInt(0));
        	profil_partie.setProfilId(curseur.getInt(1));
        	profil_partie.setPartieId(curseur.getInt(2));
        	profil_partie.setType(curseur.getString(3));
            list.add(profil_partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Profil_Partie> getAllProfilsParties() {
        ArrayList<Profil_Partie> list = new ArrayList<Profil_Partie>();
        Cursor curseur = db.query(TABLE_NAME, null, null, null, null, null, KEY_PROFIL_ID);
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
        	Profil_Partie profil_partie = new Profil_Partie();
        	profil_partie.setId(curseur.getInt(0));
        	profil_partie.setProfilId(curseur.getInt(1));
        	profil_partie.setPartieId(curseur.getInt(2));
        	profil_partie.setType(curseur.getString(3));
            list.add(profil_partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
}