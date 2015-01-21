package lille1.eservices.sporaction.sqlite;

import java.util.ArrayList;

import lille1.eservices.sporaction.model.Sport;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SportsDB {
	public static final String KEY_ID = "id";
	public static final String KEY_NOM = "nom";
	public static final String KEY_MIN_PARTICIPANTS = "minParticipants";
	public static final String KEY_MAX_PARTICIPANTS= "maxParticipants";
	public static final String KEY_MATERIELS = "materiels";
	public static final String TABLE_NAME = "Sport";
	private static final int DB_VERSION = 1;
	
	private SQLiteDatabase db;
	private DB mydb;
 
	public SportsDB(){
		
	}
	
	public void open(Context context) {
		mydb = new DB(context, TABLE_NAME, null, DB_VERSION);
		db = mydb.getWritableDatabase();
	}
		
	public void close() {
		db.close();
	}
	
	public void insert(Sport sport){	
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_NOM, sport.getNom());
		values.put(KEY_MIN_PARTICIPANTS, sport.getMinParticipants());
		values.put(KEY_MAX_PARTICIPANTS, sport.getMaxParticipants());
		values.put(KEY_MATERIELS, sport.getMateriels());
		
		// Insert the new row, returning the primary key value of the new row
		db.insert(TABLE_NAME, null, values);
	}
	
	public void update(Sport sport){
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_NOM, sport.getNom());
		values.put(KEY_MIN_PARTICIPANTS, sport.getMinParticipants());
		values.put(KEY_MAX_PARTICIPANTS, sport.getMaxParticipants());
		values.put(KEY_MATERIELS, sport.getMateriels());

		// Insert the new row, returning the primary key value of the new row
		db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[]
				{String.valueOf(sport.getId())});
	}
	
	public void delete(int id){
		db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]
				{String.valueOf(id)});
	}
	
	public Sport getSportByNom(String nom) {
        String[] columns = {KEY_ID, KEY_NOM, KEY_MIN_PARTICIPANTS,
        		KEY_MAX_PARTICIPANTS, KEY_MATERIELS};
        
        Cursor curseur = db.query(TABLE_NAME, columns, "nom = '"+nom+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return null;
        
        curseur.moveToFirst();
        Sport sport = new Sport();
        sport.setId(curseur.getInt(0));
        sport.setNom(nom);
        sport.setMinParticipants(curseur.getInt(2));
        sport.setMaxParticipants(curseur.getInt(3));
        sport.setMateriels(curseur.getString(4));
        curseur.close();
        return sport;
    }
	
	public ArrayList<Sport> getSports() {
        ArrayList<Sport> list = new ArrayList<Sport>();
        Cursor curseur = db.query(TABLE_NAME, null, null, null, null, null, 
        		KEY_NOM) ;
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
            Sport sport = new Sport();
            sport.setId(curseur.getInt(0));
            sport.setNom(curseur.getString(1));
            sport.setMinParticipants(curseur.getInt(2));
            sport.setMaxParticipants(curseur.getInt(3));
            sport.setMateriels(curseur.getString(4));
            list.add(sport);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
}