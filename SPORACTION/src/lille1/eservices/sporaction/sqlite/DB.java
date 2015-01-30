package lille1.eservices.sporaction.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {
	// Logcat tag
	public static final String LOG = DB.class.getName();
    
    // Table Names
    public static final String TABLE_PROFIL = "Profil";
    public static final String TABLE_SPORT = "Sport";
    public static final String TABLE_PARTIE = "Partie";
    public static final String TABLE_TERRAIN = "Terrain";
    public static final String TABLE_PROFIL_SPORT = "Profil_Sport";
    public static final String TABLE_PROFIL_PARTIE= "Profil_Partie";
    
    // Common column names
    public static final String KEY_ID = "id";
    public static final String KEY_NOM = "nom";
    public static final String KEY_ADRESSE = "adresse";
    public static final String KEY_CODEPOSTAL = "codePostal";
	public static final String KEY_VILLE = "ville";
	public static final String KEY_NIVEAU = "niveau";
	public static final String KEY_PROFIL_ID = "profilId";
	public static final String KEY_SPORT_ID = "sportId";
    
	// Profil table - column names
	public static final String KEY_PSEUDO = "pseudo";
	public static final String KEY_MAIL = "mail";
	public static final String KEY_MOTDEPASSE = "motDePasse";
	public static final String KEY_PLAGESHORAIRES = "plagesHoraires";
	public static final String KEY_RAYONGEOGRAPHIQUE = "rayonGeographique";
	
	// Sport table - column names
	public static final String KEY_MIN_PARTICIPANTS = "minParticipants";
	public static final String KEY_MAX_PARTICIPANTS = "maxParticipants";
	public static final String KEY_MATERIELS = "materiels";
	
	// Partie table - column names
	public static final String KEY_DATE = "date";
	public static final String KEY_HORAIRE = "horaire";
	
	// Terrain table - column names
	public static final String KEY_TERRAIN_ID = "terrainId";
	
	// Profil_Partie table - column names
	public static final String KEY_PARTIE_ID = "partieId";
	public static final String KEY_TYPE = "type";
	
	/******************** Table Create Statements ********************/
	// Profil table create statement
	public static final String PROFIL_TABLE_CREATE =
			"CREATE TABLE " + TABLE_PROFIL + " (" + KEY_ID 
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_PSEUDO + " TEXT, " 
			+ KEY_MAIL + " TEXT, " + KEY_MOTDEPASSE + " TEXT, " + KEY_ADRESSE 
			+ " TEXT, " + KEY_CODEPOSTAL + " TEXT, " + KEY_VILLE + " TEXT, "
			+ KEY_PLAGESHORAIRES + " TEXT, " + KEY_RAYONGEOGRAPHIQUE + " TEXT);";
	
	// Sport table create statement
	public static final String SPORT_TABLE_CREATE =
			"CREATE TABLE " + TABLE_SPORT + " (" + KEY_ID 
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NOM + " TEXT, " 
			+ KEY_MIN_PARTICIPANTS + " INTEGER, " + KEY_MAX_PARTICIPANTS 
			+ " INTEGER, " + KEY_MATERIELS + " TEXT);";
	
	// Partie table create statement
	public static final String PARTIE_TABLE_CREATE =
			"CREATE TABLE " + TABLE_PARTIE + " (" + KEY_ID 
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_DATE + " TEXT, " 
			+ KEY_HORAIRE + " TEXT, " + KEY_SPORT_ID + " INTEGER, " 
			+ KEY_NIVEAU + " TEXT, " + KEY_VILLE + " TEXT, " + KEY_TERRAIN_ID + " INTEGER, "
			+ " FOREIGN KEY ("+KEY_SPORT_ID+") REFERENCES "+TABLE_SPORT+" ("+KEY_ID+")" 
			+ " FOREIGN KEY ("+KEY_TERRAIN_ID+") REFERENCES "+TABLE_TERRAIN+" ("+KEY_ID+"));";
	
	// Terrain table create statement
	public static final String TERRAIN_TABLE_CREATE =
			"CREATE TABLE " + TABLE_TERRAIN + " (" + KEY_ID 
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NOM + " TEXT, " 
			+ KEY_ADRESSE + " TEXT, " + KEY_CODEPOSTAL + " TEXT, " 
			+ KEY_VILLE + " TEXT);";
	
	// Profil_Sport table create statement
	public static final String PROFIL_SPORT_TABLE_CREATE =
			"CREATE TABLE " + TABLE_PROFIL_SPORT + " (" + KEY_ID 
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_PROFIL_ID 
			+ " INTEGER, " + KEY_SPORT_ID + " INTEGER, " + KEY_NIVEAU + " TEXT, "
			+ " FOREIGN KEY ("+KEY_PROFIL_ID+") REFERENCES "+TABLE_PROFIL+" ("+KEY_ID+")" 
			+ " FOREIGN KEY ("+KEY_SPORT_ID+") REFERENCES "+TABLE_SPORT+" ("+KEY_ID+"));";
	
	// Profil_Partie table create statement
	public static final String PROFIL_PARTIE_TABLE_CREATE =
			"CREATE TABLE " + TABLE_PROFIL_PARTIE + " (" + KEY_ID 
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_PROFIL_ID 
			+ " INTEGER, " + KEY_PARTIE_ID + " INTEGER, " + KEY_TYPE  + " TEXT, "
			+ " FOREIGN KEY ("+KEY_PROFIL_ID+") REFERENCES "+TABLE_PROFIL+" ("+KEY_ID+")" 
			+ " FOREIGN KEY ("+KEY_PARTIE_ID+") REFERENCES "+TABLE_PARTIE+" ("+KEY_ID+"));";
	/***************************************************************/
	
	/******************** Table Drop Statements ********************/
	// Profil table drop statement
	public static final String PROFIL_TABLE_DROP = "DROP TABLE IF EXISTS" + 
			TABLE_PROFIL + ";";
	
	// Sport table drop statement
	public static final String SPORT_TABLE_DROP = "DROP TABLE IF EXISTS" + 
			TABLE_SPORT + ";";
	
	// Partie table drop statement
	public static final String PARTIE_TABLE_DROP = "DROP TABLE IF EXISTS" + 
			TABLE_PARTIE + ";";
	
	// Terrain table drop statement
	public static final String TERRAIN_TABLE_DROP = "DROP TABLE IF EXISTS" + 
			TABLE_TERRAIN + ";";
	
	// Profil_Sport table drop statement
	public static final String PROFIL_SPORT_TABLE_DROP = "DROP TABLE IF EXISTS" + 
			TABLE_PROFIL_SPORT + ";";
	
	// Profil_Partie table drop statement
	public static final String PROFIL_PARTIE_TABLE_DROP = "DROP TABLE IF EXISTS" + 
			TABLE_PROFIL_PARTIE + ";";
	/***************************************************************/
	
	// DB constructor
	public DB(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// Create required tables
		db.execSQL(PROFIL_TABLE_CREATE);
		db.execSQL(SPORT_TABLE_CREATE);
		db.execSQL(PARTIE_TABLE_CREATE);
		db.execSQL(TERRAIN_TABLE_CREATE);
		db.execSQL(PROFIL_SPORT_TABLE_CREATE);
		db.execSQL(PROFIL_PARTIE_TABLE_CREATE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Crop older tables
		db.execSQL(PROFIL_TABLE_DROP);
		db.execSQL(SPORT_TABLE_DROP);
		db.execSQL(PARTIE_TABLE_DROP);
		db.execSQL(TERRAIN_TABLE_DROP);
		db.execSQL(PROFIL_SPORT_TABLE_DROP);
		db.execSQL(PROFIL_PARTIE_TABLE_DROP);
		
		// Create new tables
		onCreate(db);
	}
}