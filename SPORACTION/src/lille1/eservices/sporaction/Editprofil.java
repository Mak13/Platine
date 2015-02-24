package lille1.eservices.sporaction;

import lille1.eservices.sporaction.model.Profil;
import lille1.eservices.sporaction.sqlite.ProfilsDB;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


@SuppressLint("CutPasteId")
public class Editprofil extends Activity {
	
	private ProfilsDB profilDb;
	private Profil profil;
//	private ArrayList<String> SportPratiques  ;
	EditText inputAdresse, inputCodePostal, inputVille, inputAutreSport;
	CheckBox basket, foot, hand, volley, piscine, athletisme, squash, tennis, autre;
	CheckBox matinee, midi, apresmidi, soiree;
	CheckBox unkm, deuxkm, cinqkm, dixkm;
	Button Valider, Retour;
	TextView sport;
	int compteurSport;
	String sportFavori, Niveau;
	private Spinner SportFavoriSpinner, NiveauSpinner;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofil);

        compteurSport = 0;
      // Liste des sports pratiqués
       // SportPratiques = new ArrayList<String>();
      // Définition du Layout à construire.
      //  LinearLayout postLayout = new LinearLayout( this ); 
        
        
     // Instanciation d'un composant (par exemple un Layout) 
      //  LayoutInflater inflater;
	 //	LinearLayout evtCell = (LinearLayout) inflater.inflate(R.id.sport, null); 
        
        // Importation des caract�ristiques des champs et boutons
        inputAdresse = (EditText) findViewById(R.id.adresse);
        inputCodePostal = (EditText) findViewById(R.id.codepostal);
        inputVille = (EditText) findViewById(R.id.ville);
        
        matinee = (CheckBox)findViewById(R.id.matinee);
        midi = (CheckBox)findViewById(R.id.midi);
        apresmidi = (CheckBox)findViewById(R.id.apresmidi);
        soiree = (CheckBox)findViewById(R.id.soiree);
        
        unkm = (CheckBox)findViewById(R.id.unkm);
        deuxkm = (CheckBox)findViewById(R.id.deuxkm);
        cinqkm = (CheckBox)findViewById(R.id.cinqkm);
        dixkm = (CheckBox)findViewById(R.id.dixkm);
        
        Valider = (Button) findViewById(R.id.Btnvalider);
        Bundle monBundle = getIntent().getExtras();        

        SportFavoriSpinner = (Spinner) findViewById(R.id.spinner1);
        NiveauSpinner = (Spinner) findViewById(R.id.spinner2);

  //      linkToRegisterButton = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        
        // Creation of a new profil     	
        profilDb = new ProfilsDB();
     	profilDb.open(this);
     	
     	if (monBundle != null) {

         	profil = profilDb.getProfilByPseudo(monBundle.getString("pseudo")); 
     	}
     	

     	//Ajout dynamique d'un nouveau layout pour un nouveau sport pratiqué
     	if (compteurSport != 0){
     		for(int i = compteurSport; i>0; i--){
     			
     		}
     	}
     // gestion du spinner permettant de sélectionner le sport favori
 		ArrayAdapter<CharSequence> adapterSportFavori = ArrayAdapter.createFromResource(
 				this, R.array.sportfavori_array, android.R.layout.simple_spinner_item);
 		adapterSportFavori.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 		SportFavoriSpinner.setOnItemSelectedListener((OnItemSelectedListener) this);
 		SportFavoriSpinner.setAdapter(adapterSportFavori);

  // gestion du spinner permettant de sélectionner le niveau du sport favori
 	    ArrayAdapter<CharSequence> adapterNiveau= ArrayAdapter.createFromResource(
 	     				this, R.array.niveau_array, android.R.layout.simple_spinner_item);
 	   adapterNiveau.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 	    SportFavoriSpinner.setOnItemSelectedListener((OnItemSelectedListener) this);
 	    SportFavoriSpinner.setAdapter(adapterNiveau);
 	    
        Valider.setOnClickListener(new View.OnClickListener() {      
        	public void onClick(View view) {
        		// R�cup�ration du contenu des EditText
	        	String adresse = inputAdresse.getText().toString();
	        	String codePostal = inputCodePostal.getText().toString();
	        	String ville = inputVille.getText().toString();
	        	
        		// Test sur l'adresse + insertion
	        	if(!adresse.equals("")) {
	        		profil.setAdresse(adresse);       		
	        	}
	        	// Test sur le code postal + insertion
	        	if(!codePostal.equals("")) {
	        		profil.setCodePostal(codePostal);       		
	        	}
	        	// Test sur la ville  + insertion
	        	if(!ville.equals("")) {
	        		profil.setVille(ville);       		
	        	}
	        	
	       // 	profil.setSportFavori(sportFavori);
	         	 
	        	if(matinee.isChecked()){
	         		profil.setPlagesHoraires("Matinee");
	         	}else {
	         		if(midi.isChecked()){
		         		profil.setPlagesHoraires("Midi");
		         	}else {
		         		if(apresmidi.isChecked()){
			         		profil.setPlagesHoraires("Après midi");
			         	}else {
			         		if(soiree.isChecked()){
				         		profil.setPlagesHoraires("Soiree");
				         	}else {
				         		if (profil.getPlagesHoraires()==null){
					         //		profil.setPlagesHoraires("Inconnue");
					         		Toast.makeText(getApplicationContext(), 
				                			"Auncune plage horaire d�finie", 
				    	        			Toast.LENGTH_SHORT).show();
				         		}
				         	}
			         	}
		         	}
	         	}
	        	
	        	if(unkm.isChecked()){
	         		profil.setRayonGeographique("1Km");
	         	}else {
	         		if(deuxkm.isChecked()){
		         		profil.setRayonGeographique("2Km");
		         	}else {
		         		if(cinqkm.isChecked()){
			         		profil.setRayonGeographique("5Km");
			         	}else {
			         		if(dixkm.isChecked()){
				         		profil.setRayonGeographique("10Km");
				         	}else {
				         		if (profil.getRayonGeographique()==null){
					         	//	profil.setRayonGeographique("Inconnu");
					         		Toast.makeText(getApplicationContext(), 
				                			"Auncun rayon geographique d�fini", 
				    	        			Toast.LENGTH_SHORT).show();
				         		}
				         	}
			         	}
		         	}
	         	}
	                	
	        	profilDb.update(profil);
	        	
	        	// Click sur le lien Register
	        	Intent Monprofil = new Intent(getApplicationContext(), Monprofil.class);
	        	Monprofil.putExtra("pseudo", profil.getPseudo());
	        	Monprofil.putExtra("email", profil.getMail());
	       	    startActivity(Monprofil);

	        	// Fermeture de l'Activity "MonProfil"
	        	finish();
        	}});
    }
    
    public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {

    	sportFavori = parent.getItemAtPosition(position).toString();
    }

    public void onItemSelected1(AdapterView<?> parent, View view, int position,
			long id) {

    	Niveau = parent.getItemAtPosition(position).toString();
    }    
    @Override
	protected void onStart() {
    	super.onStart();
	}
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
	}
 /*   
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	this.inflater = inflater;
    }*/
}
