package lille1.eservices.sporaction.model;

public class Terrain {
	private int id;
	private String nom;
	private String adresse;
	private String codePostal;
	private String ville;
 
	public Terrain(){}
 
	public Terrain(int id, String nom, String adresse, String codePostal,
			String ville){
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
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
 
	public String getAdresse() {
		return adresse;
	}
 
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
 
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getVille() {
		return ville;
	}
 
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String toString(){
		return "ID : "+id+"\nNOM : "+nom+"\nADRESSE : "+adresse
				+"\nCODE POSTAL : "+codePostal+"\nVILLE : "+ville;
	}
}