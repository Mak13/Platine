package lille1.eservices.sporaction.model;

public class Sport {
	private int id;
	private String nom;
	private int minParticipants;
	private int maxParticipants;
	private String materiels;
 
	public Sport(){}
 
	public Sport(int id, String nom, int minParticipants, int maxParticipants,
			String materiels){
		this.id = id;
		this.nom = nom;
		this.minParticipants = minParticipants;
		this.maxParticipants = maxParticipants;
		this.materiels = materiels;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getNom() {
		return nom;
	}
 
	public void setNom(String nom) {
		this.nom = nom;
	}
 
	public int getMinParticipants() {
		return minParticipants;
	}
 
	public void setMinParticipants(int minParticipants) {
		this.minParticipants = minParticipants;
	}
	
	public int getMaxParticipants() {
		return maxParticipants;
	}
 
	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	
	public String getMateriels() {
		return materiels;
	}
 
	public void setMateriels(String materiels) {
		this.materiels = materiels;
	}
	
	public String toString(){
		return "ID : "+id+"\nNOM : "+nom
				+"\nMIN PARTICIPANTS : "+minParticipants
				+"\nMAX PARTICIPANTS : "+maxParticipants
				+"\nMATERIELS : "+materiels;
	}
}