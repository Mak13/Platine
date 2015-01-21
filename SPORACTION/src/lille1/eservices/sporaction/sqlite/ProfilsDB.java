package lille1.eservices.sporaction.sqlite;

import java.util.ArrayList;

import lille1.eservices.sporaction.model.Profil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProfilsDB {
	public static final String KEY_ID = "id";
	public static final String KEY_PSEUDO = "pseudo";
	public static final String KEY_MAIL = "mail";
	public static final String KEY_MOTDEPASSE = "motDePasse";
	public static final String KEY_ADRESSE = "adresse";
	public static final String KEY_CODEPOSTAL = "codePostal";
	public static final String KEY_VILLE = "ville";
	public static final String KEY_PLAGESHORAIRES = "plagesHoraires";
	public static final String KEY_RAYONGEOGRAPHIQUE = "rayonGeographique";
	public static final String TABLE_NAME = "Profil";
	private static final int DB_VERSION = 1;
	
	private SQLiteDatabase db;
	private DB mydb;
 
	public ProfilsDB(){
		
	}
	
	public void open(Context context) {
		mydb = new DB(context, TABLE_NAME, null, DB_VERSION);
		db = mydb.getWritableDatabase();
	}
		
	public void close() {
		db.close();
	}
	
	public void insert(Profil profil){	
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_PSEUDO, profil.getPseudo());
		values.put(KEY_MAIL, profil.getMail());
		values.put(KEY_MOTDEPASSE, profil.getMotDePasse());
		values.put(KEY_ADRESSE, profil.getAdresse());
		values.put(KEY_CODEPOSTAL, profil.getCodePostal());
		values.put(KEY_VILLE, profil.getVille());
		values.put(KEY_PLAGESHORAIRES, profil.getPlagesHoraires());
		values.put(KEY_RAYONGEOGRAPHIQUE, profil.getRayonGeographique());
		
		// Insert the new row, returning the primary key value of the new row
		db.insert(TABLE_NAME, null, values);
	}
	
	public void update(Profil profil){
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(KEY_PSEUDO, profil.getPseudo());
		values.put(KEY_MAIL, profil.getMail());
		values.put(KEY_MOTDEPASSE, profil.getMotDePasse());
		values.put(KEY_ADRESSE, profil.getAdresse());
		values.put(KEY_CODEPOSTAL, profil.getCodePostal());
		values.put(KEY_VILLE, profil.getVille());
		values.put(KEY_PLAGESHORAIRES, profil.getPlagesHoraires());
		values.put(KEY_RAYONGEOGRAPHIQUE, profil.getRayonGeographique());

		// Insert the new row, returning the primary key value of the new row
		db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[]
				{String.valueOf(profil.getId())});
	}
	
	public void delete(int id){
		db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]
				{String.valueOf(id)});
	}
	
	public Profil getProfilByPseudo(String pseudo) {
        String[] columns = {KEY_ID, KEY_PSEUDO, KEY_MAIL, KEY_MOTDEPASSE,
        		KEY_ADRESSE, KEY_CODEPOSTAL, KEY_VILLE, KEY_PLAGESHORAIRES,
        		KEY_RAYONGEOGRAPHIQUE};
        
        Cursor curseur = db.query(TABLE_NAME, columns, "pseudo = '"+pseudo+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return null;
        
        curseur.moveToFirst();
        Profil profil = new Profil();
        profil.setId(curseur.getInt(0));
        profil.setPseudo(pseudo);
        profil.setMail(curseur.getString(2));
        profil.setMotDePasse(curseur.getString(3));
        profil.setAdresse(curseur.getString(4));
        profil.setCodePostal(curseur.getString(5));
        profil.setVille(curseur.getString(6));
        profil.setPlagesHoraires(curseur.getString(7));
        profil.setRayonGeographique(curseur.getString(8));
        curseur.close();
        return profil;
    }
	
	public Profil getProfilByEmail(String mail) {
		String[] columns = {KEY_ID, KEY_PSEUDO, KEY_MAIL, KEY_MOTDEPASSE,
        		KEY_ADRESSE, KEY_CODEPOSTAL, KEY_VILLE, KEY_PLAGESHORAIRES,
        		KEY_RAYONGEOGRAPHIQUE};
		
        Cursor curseur = db.query(TABLE_NAME, columns, "mail = '"+mail+"'"
        		, null,  null, null, null) ;
        
        if (curseur.getCount() == 0) return null;
        
        curseur.moveToFirst();
        Profil profil = new Profil();
        profil.setId(curseur.getInt(0));
        profil.setPseudo(curseur.getString(1));
        profil.setMail(mail);
        profil.setMotDePasse(curseur.getString(3));
        profil.setAdresse(curseur.getString(4));
        profil.setCodePostal(curseur.getString(5));
        profil.setVille(curseur.getString(6));
        profil.setPlagesHoraires(curseur.getString(7));
        profil.setRayonGeographique(curseur.getString(8));
        curseur.close();
        return profil;
    }
	
	public Profil getProfil(String pseudo, String motDePasse) {
		String[] columns = {KEY_ID, KEY_PSEUDO, KEY_MAIL, KEY_MOTDEPASSE,
        		KEY_ADRESSE, KEY_CODEPOSTAL, KEY_VILLE, KEY_PLAGESHORAIRES,
        		KEY_RAYONGEOGRAPHIQUE};
		
        Cursor curseur = db.query(TABLE_NAME, columns, "pseudo = '"+pseudo+
        		"' AND motDePasse = '"+motDePasse+"'", null,  null, null, null) ;
        
        if (curseur.getCount()==0) return null;
        curseur.moveToFirst();
        Profil profil = new Profil();
        profil.setId(curseur.getInt(0));
        profil.setPseudo(pseudo);
        profil.setMail(curseur.getString(2));
        profil.setMotDePasse(motDePasse);
        profil.setAdresse(curseur.getString(4));
        profil.setCodePostal(curseur.getString(5));
        profil.setVille(curseur.getString(6));
        profil.setPlagesHoraires(curseur.getString(7));
        profil.setRayonGeographique(curseur.getString(8));
        curseur.close();
        return profil;
    }
	
	public ArrayList<Profil> getProfils() {
        ArrayList<Profil> list = new ArrayList<Profil>();
        Cursor curseur = db.query(TABLE_NAME, null, null, null, null, null, 
        		KEY_PSEUDO) ;
        if (curseur.getCount() == 0) return list;
        
        curseur.moveToFirst();
        do {
            Profil profil = new Profil();
            profil.setId(curseur.getInt(0));
            profil.setPseudo(curseur.getString(1));
            profil.setMail(curseur.getString(2));
            profil.setMotDePasse(curseur.getString(3));
            profil.setAdresse(curseur.getString(4));
            profil.setCodePostal(curseur.getString(5));
            profil.setVille(curseur.getString(6));
            profil.setPlagesHoraires(curseur.getString(7));
            profil.setRayonGeographique(curseur.getString(8));
            list.add(profil);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
}