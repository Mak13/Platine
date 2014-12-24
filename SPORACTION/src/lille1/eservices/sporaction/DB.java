package lille1.eservices.sporaction;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {
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
	
	// Create table request
	public static final String TABLE_CREATE =
			"CREATE TABLE " + TABLE_NAME + " (" + KEY 
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + PSEUDO + " TEXT, " 
			+ MAIL + " TEXT, " + MOTDEPASSE + " TEXT, " + ADRESSE 
			+ " TEXT, " + CODEPOSTAL + " TEXT, " + VILLE + " TEXT, "
			+ SPORTSPRATIQUES + " TEXT, " + NIVEAUXPRATIQUES + " TEXT, "
			+ PLAGESHORAIRES + " TEXT, " + RAYONGEOGRAPHIQUE + " TEXT, "
			+ REMEMBERME + " TEXT);";
	
	// Drop table reques
	public static final String TABLE_DROP = "DROP TABLE IF EXISTS" + 
	TABLE_NAME + ";";
	
	// DB constructor
	public DB(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_CREATE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(TABLE_DROP);
		onCreate(db);
	}
}