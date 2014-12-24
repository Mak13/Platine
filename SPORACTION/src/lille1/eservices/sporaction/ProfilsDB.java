package lille1.eservices.sporaction;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProfilsDB {
	public static final String KEY = "id";
	public static final String PSEUDO = "pseudo";
	public static final String MAIL = "mail";
	public static final String MOTDEPASSE = "motDePasse";
	public static final String ADRESSE = "adresse";
	public static final String CODEPOSTAL = "codePostal";
	public static final String VILLE = "ville";
	public static final String SPORTSPRATIQUES = "sportsPratiques";
	public static final String NIVEAUXPRATIQUES = "niveauxPratiques";
	public static final String PLAGESHORAIRES = "plagesHoraires";
	public static final String RAYONGEOGRAPHIQUE = "rayonGeographique";
	public static final String REMEMBERME = "rememberMe";
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
		values.put(PSEUDO, profil.getPseudo());
		values.put(MAIL, profil.getMail());
		values.put(MOTDEPASSE, profil.getMotDePasse());
		values.put(ADRESSE, profil.getAdresse());
		values.put(CODEPOSTAL, profil.getCodePostal());
		values.put(VILLE, profil.getVille());
		values.put(SPORTSPRATIQUES, profil.getSportsPratiques());
		values.put(NIVEAUXPRATIQUES, profil.getNiveauxPratiques());
		values.put(PLAGESHORAIRES, profil.getPlagesHoraires());
		values.put(RAYONGEOGRAPHIQUE, profil.getRayonGeographique());
		values.put(REMEMBERME, profil.getRememberMe());
		
		// Insert the new row, returning the primary key value of the new row
		db.insert(TABLE_NAME, null, values);
	}
	
	public void update(Profil profil){
		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(PSEUDO, profil.getPseudo());
		values.put(MAIL, profil.getMail());
		values.put(MOTDEPASSE, profil.getMotDePasse());
		values.put(ADRESSE, profil.getAdresse());
		values.put(CODEPOSTAL, profil.getCodePostal());
		values.put(VILLE, profil.getVille());
		values.put(SPORTSPRATIQUES, profil.getSportsPratiques());
		values.put(NIVEAUXPRATIQUES, profil.getNiveauxPratiques());
		values.put(PLAGESHORAIRES, profil.getPlagesHoraires());
		values.put(RAYONGEOGRAPHIQUE, profil.getRayonGeographique());
		values.put(REMEMBERME, profil.getRememberMe());

		// Insert the new row, returning the primary key value of the new row
		db.update(TABLE_NAME, values, KEY + " = ?", new String[]
				{String.valueOf(profil.getId())});
	}
	
	public void delete(int id){
		db.delete(TABLE_NAME, KEY + " = ?", new String[]
				{String.valueOf(id)});
	}
	
	public Profil getProfilByPseudo(String pseudo) {
        String[] columns = {"id", "pseudo", "mail", "motDePasse", "adresse", 
        		"codePostal", "ville", "sportsPratiques", "niveauxPratiques",
        		"plagesHoraires", "rayonGeographique", "rememberMe"};
        Cursor curseur = db.query(TABLE_NAME, columns, "pseudo = '"+pseudo+"'"
        		, null,  null, null, "pseudo") ;
        if (curseur.getCount()==0) return null;
        curseur.moveToFirst();
        Profil profil = new Profil();
        profil.setId(curseur.getInt(0));
        profil.setPseudo(pseudo);
        profil.setMail(curseur.getString(2));
        profil.setMotDePasse(curseur.getString(3));
        profil.setAdresse(curseur.getString(4));
        profil.setCodePostal(curseur.getString(5));
        profil.setVille(curseur.getString(6));
        profil.setSportsPratiques(curseur.getString(7));
        profil.setNiveauxPratiques(curseur.getString(8));
        profil.setPlagesHoraires(curseur.getString(9));
        profil.setRayonGeographique(curseur.getString(10));
        profil.setRememberMe(curseur.getString(11));
        curseur.close();
        return profil;
    }
	
	public Profil getProfilByEmail(String email) {
        String[] columns = {"id", "pseudo", "mail", "motDePasse", "adresse", 
        		"codePostal", "ville", "sportsPratiques", "niveauxPratiques",
        		"plagesHoraires", "rayonGeographique", "rememberMe"};
        Cursor curseur = db.query(TABLE_NAME, columns, "mail = '"+email+"'"
        		, null,  null, null, "pseudo") ;
        if (curseur.getCount()==0) return null;
        curseur.moveToFirst();
        Profil profil = new Profil();
        profil.setId(curseur.getInt(0));
        profil.setPseudo(curseur.getString(1));
        profil.setMail(email);
        profil.setMotDePasse(curseur.getString(3));
        profil.setAdresse(curseur.getString(4));
        profil.setCodePostal(curseur.getString(5));
        profil.setVille(curseur.getString(6));
        profil.setSportsPratiques(curseur.getString(7));
        profil.setNiveauxPratiques(curseur.getString(8));
        profil.setPlagesHoraires(curseur.getString(9));
        profil.setRayonGeographique(curseur.getString(10));
        profil.setRememberMe(curseur.getString(11));
        curseur.close();
        return profil;
    }
	
	public Profil getProfil(String pseudo, String password) {
        String[] columns = {"id", "pseudo", "mail", "motDePasse", "adresse", 
        		"codePostal", "ville", "sportsPratiques", "niveauxPratiques",
        		"plagesHoraires", "rayonGeographique", "rememberMe"};
        Cursor curseur = db.query(TABLE_NAME, columns, "pseudo = '"+pseudo+
        		"' AND motDePasse = '"+password+"'", null,  null, null, "pseudo") ;
        if (curseur.getCount()==0) return null;
        curseur.moveToFirst();
        Profil profil = new Profil();
        profil.setId(curseur.getInt(0));
        profil.setPseudo(pseudo);
        profil.setMail(curseur.getString(2));
        profil.setMotDePasse(password);
        profil.setAdresse(curseur.getString(4));
        profil.setCodePostal(curseur.getString(5));
        profil.setVille(curseur.getString(6));
        profil.setSportsPratiques(curseur.getString(7));
        profil.setNiveauxPratiques(curseur.getString(8));
        profil.setPlagesHoraires(curseur.getString(9));
        profil.setRayonGeographique(curseur.getString(10));
        profil.setRememberMe(curseur.getString(11));
        curseur.close();
        return profil;
    }
	
	public ArrayList<Profil> getProfils() {
        ArrayList<Profil> list = new ArrayList<Profil>();
        Cursor curseur = db.query(TABLE_NAME, null, null, null,  null, null, "pseudo") ;
        if (curseur.getCount()==0) return list;
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
            profil.setCodePostal(curseur.getString(7));
            profil.setSportsPratiques(curseur.getString(8));
            profil.setNiveauxPratiques(curseur.getString(9));
            profil.setPlagesHoraires(curseur.getString(10));
            profil.setRayonGeographique(curseur.getString(11));
            list.add(profil);
        }
        while (curseur.moveToNext());
        curseur.close();
        return list;
    }
}
