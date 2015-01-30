package lille1.eservices.sporaction.sqlite;

import java.util.ArrayList;
import lille1.eservices.sporaction.model.Partie;
import lille1.eservices.sporaction.model.Sport;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PartiesDB {
	public static final String KEY_ID = "id";
	public static final String KEY_DATE = "date";
	public static final String KEY_HORAIRE = "horaire";
	public static final String KEY_SPORT_ID = "sportId";
	public static final String KEY_NIVEAU = "niveau";
	public static final String KEY_VILLE = "ville";
	public static final String KEY_TERRAIN_ID = "terrainId";
	public static final String TABLE_NAME = "Partie";
	private static final int DB_VERSION = 1;
	
	private SQLiteDatabase db;
	private DB mydb;
 
	public PartiesDB(){
		
	}
	
	public void open(Context context) {
		mydb = new DB(context, TABLE_NAME, null, DB_VERSION);
		db = mydb.getWritableDatabase();
	}
		
	public void close() {
		db.close();
	}
	
	public void insert(Partie partie){	
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_DATE, partie.getDate().toString());
		values.put(KEY_HORAIRE, partie.getHoraire());
		values.put(KEY_SPORT_ID, partie.getSportId());
		values.put(KEY_NIVEAU, partie.getNiveau());
		values.put(KEY_VILLE, partie.getVille());
		values.put(KEY_TERRAIN_ID, partie.getTerrainId());
		
		// Insert the new row, returning the primary key value of the new row
		db.insert(TABLE_NAME, null, values);
	}
	
	public void update(Partie partie, long sportId, long terrainId){
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_DATE, partie.getDate().toString());
		values.put(KEY_HORAIRE, partie.getHoraire());
		values.put(KEY_SPORT_ID, partie.getSportId());
		values.put(KEY_NIVEAU, partie.getNiveau());
		values.put(KEY_VILLE, partie.getVille());
		values.put(KEY_TERRAIN_ID, partie.getTerrainId());

		// Insert the new row, returning the primary key value of the new row
		db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[]
				{String.valueOf(partie.getId())});
	}
	
	public void delete(int id){
		db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]
				{String.valueOf(id)});
	}
	
	public ArrayList<Partie> getParties() {
        ArrayList<Partie> list = new ArrayList<Partie>();
        Cursor curseur = db.query(TABLE_NAME, null, null, null, null, null, null);
        
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
            Partie partie = new Partie();
            partie.setId(curseur.getInt(0));
            partie.setDate(curseur.getString(1));
            partie.setHoraire(curseur.getString(2));
            partie.setSportId(curseur.getInt(3));
            partie.setNiveau(curseur.getString(4));
            partie.setVille(curseur.getString(5));
            partie.setTerrainId(curseur.getInt(6));
            list.add(partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Partie> getPartiesByDate(String date) {
		String[] columns = {KEY_ID, KEY_DATE, KEY_HORAIRE, KEY_SPORT_ID,
        		KEY_NIVEAU, KEY_VILLE, KEY_TERRAIN_ID};
		
        ArrayList<Partie> list = new ArrayList<Partie>();
        Cursor curseur = db.query(TABLE_NAME, columns, "date = '"+date+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
            Partie partie = new Partie();
            partie.setId(curseur.getInt(0));
            partie.setDate(curseur.getString(1));
            partie.setHoraire(curseur.getString(2));
            partie.setSportId(curseur.getInt(3));
            partie.setNiveau(curseur.getString(4));
            partie.setVille(curseur.getString(5));
            partie.setTerrainId(curseur.getInt(6));
            list.add(partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Partie> getPartiesByHoraire(String horaire) {
		String[] columns = {KEY_ID, KEY_DATE, KEY_HORAIRE, KEY_SPORT_ID,
        		KEY_NIVEAU, KEY_VILLE, KEY_TERRAIN_ID};
		
        ArrayList<Partie> list = new ArrayList<Partie>();
        Cursor curseur = db.query(TABLE_NAME, columns, "horaire = '"+horaire+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
            Partie partie = new Partie();
            partie.setId(curseur.getInt(0));
            partie.setDate(curseur.getString(1));
            partie.setHoraire(curseur.getString(2));
            partie.setSportId(curseur.getInt(3));
            partie.setNiveau(curseur.getString(4));
            partie.setVille(curseur.getString(5));
            partie.setTerrainId(curseur.getInt(6));
            list.add(partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Partie> getPartiesBySport(int sportId) {
		String[] columns = {KEY_ID, KEY_DATE, KEY_HORAIRE, KEY_SPORT_ID,
        		KEY_NIVEAU, KEY_VILLE, KEY_TERRAIN_ID};
		
        ArrayList<Partie> list = new ArrayList<Partie>();
        Cursor curseur = db.query(TABLE_NAME, columns, "sportId = '"+sportId+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
            Partie partie = new Partie();
            partie.setId(curseur.getInt(0));
            partie.setDate(curseur.getString(1));
            partie.setHoraire(curseur.getString(2));
            partie.setSportId(curseur.getInt(3));
            partie.setNiveau(curseur.getString(4));
            partie.setVille(curseur.getString(5));
            partie.setTerrainId(curseur.getInt(6));
            list.add(partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Partie> getPartiesByNiveau(String niveau) {
		String[] columns = {KEY_ID, KEY_DATE, KEY_HORAIRE, KEY_SPORT_ID,
        		KEY_NIVEAU, KEY_VILLE, KEY_TERRAIN_ID};
		
        ArrayList<Partie> list = new ArrayList<Partie>();
        Cursor curseur = db.query(TABLE_NAME, columns, "niveau = '"+niveau+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
            Partie partie = new Partie();
            partie.setId(curseur.getInt(0));
            partie.setDate(curseur.getString(1));
            partie.setHoraire(curseur.getString(2));
            partie.setSportId(curseur.getInt(3));
            partie.setNiveau(curseur.getString(4));
            partie.setVille(curseur.getString(5));
            partie.setTerrainId(curseur.getInt(6));
            list.add(partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Partie> getPartiesByVille(String ville) {
		String[] columns = {KEY_ID, KEY_DATE, KEY_HORAIRE, KEY_SPORT_ID,
        		KEY_NIVEAU, KEY_VILLE, KEY_TERRAIN_ID};
		
        ArrayList<Partie> list = new ArrayList<Partie>();
        Cursor curseur = db.query(TABLE_NAME, columns, "ville = '"+ville+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
            Partie partie = new Partie();
            partie.setId(curseur.getInt(0));
            partie.setDate(curseur.getString(1));
            partie.setHoraire(curseur.getString(2));
            partie.setSportId(curseur.getInt(3));
            partie.setNiveau(curseur.getString(4));
            partie.setVille(curseur.getString(5));
            partie.setTerrainId(curseur.getInt(6));
            list.add(partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	
	public ArrayList<Partie> getPartiesByTerrain(int terrainId) {
		String[] columns = {KEY_ID, KEY_DATE, KEY_HORAIRE, KEY_SPORT_ID,
        		KEY_NIVEAU, KEY_VILLE, KEY_TERRAIN_ID};
		
        ArrayList<Partie> list = new ArrayList<Partie>();
        Cursor curseur = db.query(TABLE_NAME, columns, "terrainId = '"+terrainId+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
            Partie partie = new Partie();
            partie.setId(curseur.getInt(0));
            partie.setDate(curseur.getString(1));
            partie.setHoraire(curseur.getString(2));
            partie.setSportId(curseur.getInt(3));
            partie.setNiveau(curseur.getString(4));
            partie.setVille(curseur.getString(5));
            partie.setTerrainId(curseur.getInt(6));
            list.add(partie);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public Partie getPartieById(int id) {
        String[] columns = {KEY_ID, KEY_DATE, KEY_HORAIRE, KEY_SPORT_ID,
        		KEY_NIVEAU, KEY_VILLE, KEY_TERRAIN_ID};
        
        Cursor curseur = db.query(TABLE_NAME, columns, "id = '"+id+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return null;
        
        curseur.moveToFirst();
        Partie partie = new Partie();
        partie.setId(curseur.getInt(0));
        partie.setDate(curseur.getString(1));
        partie.setHoraire(curseur.getString(2));
        partie.setSportId(curseur.getInt(3));
        partie.setNiveau(curseur.getString(4));
        partie.setVille(curseur.getString(5));
        partie.setTerrainId(curseur.getInt(6));
        curseur.close();
        return partie;
    }
}
