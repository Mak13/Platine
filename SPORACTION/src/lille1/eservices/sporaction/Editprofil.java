package lille1.eservices.sporaction;

import lille1.eservices.sporaction.model.Profil;
import lille1.eservices.sporaction.sqlite.ProfilsDB;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


@SuppressLint("CutPasteId")
public class Editprofil extends Activity {
	
	private ProfilsDB profilDb;
	private Profil profil;
//	private ArrayList<String> SportPratiques;
	EditText inputAdresse, inputCodePostal, inputVille, inputAutreSport;
	CheckBox basket, foot, hand, volley, piscine, athletisme, squash, tennis, autre;
	CheckBox matinee, midi, apresmidi, soiree;
	CheckBox unkm, deuxkm, cinqkm, dixkm;
	Button Valider, Retour;
	TextView sport;
	int compteurSport;
	
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
        inputAutreSport = (EditText) findViewById(R.id.autreSport);
        
        basket = (CheckBox)findViewById(R.id.basket);
        foot = (CheckBox)findViewById(R.id.foot);
        hand = (CheckBox)findViewById(R.id.handball);
        volley = (CheckBox)findViewById(R.id.volley);
        piscine = (CheckBox)findViewById(R.id.piscine);
        athletisme = (CheckBox)findViewById(R.id.athletisme);
        tennis = (CheckBox)findViewById(R.id.tennis);
        autre = (CheckBox)findViewById(R.id.autre);
        
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
	        	/*
	         	//Ajout Basketball aux sports Favoris
	         	if(basket.isChecked()){
	         		profil.setSportsPratiques("BasketBall");
	         	//	SportPratiques.add("BasketBall");
	         //		sport.setText("BasketBall");
	         		compteurSport++;
	         	}
	         	//Ajout Football aux sports Favoris
	         	if(foot.isChecked()){
	         		profil.setSportsPratiques("FootBall");
	         //		SportPratiques.add("FootBall");
	         //		sport.setText("FootBall");
	         		compteurSport++;
	         	}
	         	//Ajout Handball aux sports Favoris
	         	if(hand.isChecked()){
	         		profil.setSportsPratiques("Handball");
	         //		SportPratiques.add("Handball");
	         	//	sport.setText("Handball");
	         		compteurSport++;
	         	}
	         	//Ajout Volleyball aux sports Favoris
	         	if(volley.isChecked()){
	         		profil.setSportsPratiques("Volleyball");
	            //	SportPratiques.add("Volleyball");
	         	//	sport.setText("Volleyball");
	         		compteurSport++;
	         	}
	         	//Ajout Piscine aux sports Favoris
	         	if(piscine.isChecked()){
	         		profil.setSportsPratiques("Piscine");
	         	//	SportPratiques.add("Piscine");
	         	//	sport.setText("Piscine");
	         		compteurSport++;
	         	}
	         	//Ajout Athletisme aux sports Favoris
	         	if(athletisme.isChecked()){
	         		profil.setSportsPratiques("Athletisme");
	         	//	SportPratiques.add("Athletisme");
	         	//	sport.setText("Athletisme");
	         		compteurSport++;
	         	}
	         	//Ajout Tennis aux sports Favoris
	         	if(tennis.isChecked()){
	         		profil.setSportsPratiques("Tennis");
	         	//	SportPratiques.add("Tennis");
	         	//	sport.setText("Tennis");
	         		compteurSport++;
	         	}
	         	//Ajout Tennis aux sports Favoris
	         	if(autre.isChecked()){
	         		profil.setSportsPratiques(inputAutreSport.getText().toString());
	        // 		SportPratiques.add(inputAutreSport.getText().toString());
	         	//	sport.setText(inputAutreSport.getText().toString());
	         		compteurSport++;
	         	}*/
	         	 
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
