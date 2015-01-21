package lille1.eservices.sporaction.sqlite;

import java.util.ArrayList;

import lille1.eservices.sporaction.model.Terrain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TerrainsDB {
	public static final String KEY_ID = "id";
	public static final String KEY_NOM = "nom";
	public static final String KEY_ADRESSE = "adresse";
	public static final String KEY_CODEPOSTAL= "codePostal";
	public static final String KEY_VILLE = "ville";
	public static final String TABLE_NAME = "Terrain";
	private static final int DB_VERSION = 1;
	
	private SQLiteDatabase db;
	private DB mydb;
 
	public TerrainsDB(){
		
	}
	
	public void open(Context context) {
		mydb = new DB(context, TABLE_NAME, null, DB_VERSION);
		db = mydb.getWritableDatabase();
	}
		
	public void close() {
		db.close();
	}
	
	public void insert(Terrain terrain){	
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_NOM, terrain.getNom());
		values.put(KEY_ADRESSE, terrain.getAdresse());
		values.put(KEY_CODEPOSTAL, terrain.getCodePostal());
		values.put(KEY_VILLE, terrain.getVille());
		
		// Insert the new row, returning the primary key value of the new row
		db.insert(TABLE_NAME, null, values);
	}
	
	public void update(Terrain terrain){
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_NOM, terrain.getNom());
		values.put(KEY_ADRESSE, terrain.getAdresse());
		values.put(KEY_CODEPOSTAL, terrain.getCodePostal());
		values.put(KEY_VILLE, terrain.getVille());

		// Insert the new row, returning the primary key value of the new row
		db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[]
				{String.valueOf(terrain.getId())});
	}
	
	public void delete(int id){
		db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]
				{String.valueOf(id)});
	}
	
	public Terrain getTerrainByNom(String nom) {
        String[] columns = {KEY_ID, KEY_NOM, KEY_ADRESSE, KEY_CODEPOSTAL, 
        		KEY_VILLE};
        
        Cursor curseur = db.query(TABLE_NAME, columns, "nom = '"+nom+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return null;
        
        curseur.moveToFirst();
        Terrain terrain = new Terrain();
        terrain.setId(curseur.getInt(0));
        terrain.setNom(nom);
        terrain.setAdresse(curseur.getString(2));
        terrain.setCodePostal(curseur.getString(3));
        terrain.setVille(curseur.getString(4));
        curseur.close();
        return terrain;
    }
	
	public ArrayList<Terrain> getTerrains() {
        ArrayList<Terrain> list = new ArrayList<Terrain>();
        Cursor curseur = db.query(TABLE_NAME, null, null, null, null, null, 
        		KEY_NOM) ;
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
        	Terrain terrain = new Terrain();
        	terrain.setId(curseur.getInt(0));
        	terrain.setNom(curseur.getString(1));
        	terrain.setAdresse(curseur.getString(2));
        	terrain.setCodePostal(curseur.getString(3));
        	terrain.setVille(curseur.getString(4));
            list.add(terrain);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Terrain> getTerrainsByCodePostal(String codePostal) {
		String[] columns = {KEY_ID, KEY_NOM, KEY_ADRESSE, KEY_CODEPOSTAL,
        		KEY_VILLE};
		
        ArrayList<Terrain> list = new ArrayList<Terrain>();
        Cursor curseur = db.query(TABLE_NAME, columns, "codePostal = '"+codePostal+"'"
        		, null,  null, null, KEY_NOM) ;
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
        	Terrain terrain = new Terrain();
        	terrain.setId(curseur.getInt(0));
        	terrain.setNom(curseur.getString(1));
        	terrain.setAdresse(curseur.getString(2));
        	terrain.setCodePostal(curseur.getString(3));
        	terrain.setVille(curseur.getString(4));
            list.add(terrain);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
	
	public ArrayList<Terrain> getTerrainsByVille(String ville) {
		String[] columns = {KEY_ID, KEY_NOM, KEY_ADRESSE, KEY_CODEPOSTAL,
        		KEY_VILLE};
		
        ArrayList<Terrain> list = new ArrayList<Terrain>();
        Cursor curseur = db.query(TABLE_NAME, columns, "ville = '"+ville+"'"
        		, null,  null, null, KEY_NOM) ;
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
        	Terrain terrain = new Terrain();
        	terrain.setId(curseur.getInt(0));
        	terrain.setNom(curseur.getString(1));
        	terrain.setAdresse(curseur.getString(2));
        	terrain.setCodePostal(curseur.getString(3));
        	terrain.setVille(curseur.getString(4));
            list.add(terrain);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
}