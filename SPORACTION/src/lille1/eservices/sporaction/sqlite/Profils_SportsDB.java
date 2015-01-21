package lille1.eservices.sporaction.sqlite;

import java.util.ArrayList;

import lille1.eservices.sporaction.model.Profil_Sport;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Profils_SportsDB {
	public static final String KEY_ID = "id";
	public static final String KEY_PROFIL_ID = "profilId";
	public static final String KEY_SPORT_ID = "sportId";
	public static final String KEY_NIVEAU= "niveau";
	public static final String TABLE_NAME = "Profil_Sport";
	private static final int DB_VERSION = 1;
	
	private SQLiteDatabase db;
	private DB mydb;
 
	public Profils_SportsDB(){
		
	}
	
	public void open(Context context) {
		mydb = new DB(context, TABLE_NAME, null, DB_VERSION);
		db = mydb.getWritableDatabase();
	}
		
	public void close() {
		db.close();
	}
	
	public void insert(Profil_Sport profil_sport){	
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_PROFIL_ID, profil_sport.getProfilId());
		values.put(KEY_SPORT_ID, profil_sport.getSportId());
		values.put(KEY_NIVEAU, profil_sport.getNiveau());
		
		// Insert the new row, returning the primary key value of the new row
		db.insert(TABLE_NAME, null, values);
	}
	
	public void update(Profil_Sport profil_sport){
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_PROFIL_ID, profil_sport.getProfilId());
		values.put(KEY_SPORT_ID, profil_sport.getSportId());
		values.put(KEY_NIVEAU, profil_sport.getNiveau());

		// Insert the new row, returning the primary key value of the new row
		db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[]
				{String.valueOf(profil_sport.getId())});
	}
	
	public void delete(int id){
		db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]
				{String.valueOf(id)});
	}
	
	public ArrayList<Profil_Sport> getProfilsBySport(int sportId) {
		String[] columns = {KEY_ID, KEY_PROFIL_ID, KEY_SPORT_ID, KEY_NIVEAU};
		
        ArrayList<Profil_Sport> list = new ArrayList<Profil_Sport>();
        Cursor curseur = db.query(TABLE_NAME, columns, "sportId = '"+sportId+"'"
        		, null,  null, null, KEY_PROFIL_ID);
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
        	Profil_Sport profil_sport = new Profil_Sport();
        	profil_sport.setId(curseur.getInt(0));
        	profil_sport.setProfilId(curseur.getInt(1));
        	profil_sport.setSportId(curseur.getInt(2));
        	profil_sport.setNiveau(curseur.getString(3));
            list.add(profil_sport);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Profil_Sport> getSportsByProfil(int profilId) {
		String[] columns = {KEY_ID, KEY_PROFIL_ID, KEY_SPORT_ID, KEY_NIVEAU};
		
        ArrayList<Profil_Sport> list = new ArrayList<Profil_Sport>();
        Cursor curseur = db.query(TABLE_NAME, columns, "profilId = '"+profilId+"'"
        		, null,  null, null, KEY_SPORT_ID);
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
        	Profil_Sport profil_sport = new Profil_Sport();
        	profil_sport.setId(curseur.getInt(0));
        	profil_sport.setProfilId(curseur.getInt(1));
        	profil_sport.setSportId(curseur.getInt(2));
        	profil_sport.setNiveau(curseur.getString(3));
            list.add(profil_sport);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Profil_Sport> getProfilsBySportAndNiveau(int profilId, 
			String niveau) {
		String[] columns = {KEY_ID, KEY_PROFIL_ID, KEY_SPORT_ID, KEY_NIVEAU};
		
        ArrayList<Profil_Sport> list = new ArrayList<Profil_Sport>();
        Cursor curseur = db.query(TABLE_NAME, columns, "profilId = '"+profilId+"'" +
        		"AND niveau = '"+niveau+"'", null,  null, null, KEY_PROFIL_ID);
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
        	Profil_Sport profil_sport = new Profil_Sport();
        	profil_sport.setId(curseur.getInt(0));
        	profil_sport.setProfilId(curseur.getInt(1));
        	profil_sport.setSportId(curseur.getInt(2));
        	profil_sport.setNiveau(curseur.getString(3));
            list.add(profil_sport);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
}