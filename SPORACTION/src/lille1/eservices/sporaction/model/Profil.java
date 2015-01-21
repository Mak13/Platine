package lille1.eservices.sporaction.model;

public class Profil {
	private int id;
	private String pseudo;
	private String mail;
	private String motDePasse;
	private String adresse;
	private String codePostal;
	private String ville;
	private String plagesHoraires;
	private String rayonGeographique;
 
	public Profil(){}
 
	public Profil(int id, String pseudo, String mail, String motDePasse,
			String adresse, String codePostal, String ville,
			String plagesHoraires, String rayonGeographique){
		this.id = id;
		this.pseudo = pseudo;
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.plagesHoraires = plagesHoraires;
		this.rayonGeographique = rayonGeographique;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getPseudo() {
		return pseudo;
	}
 
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
 
	public String getMail() {
		return mail;
	}
 
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
 
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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
	
	public String getPlagesHoraires() {
		return plagesHoraires;
	}
 
	public void setPlagesHoraires(String plagesHoraires) {
		this.plagesHoraires = plagesHoraires;
	}
	
	public String getRayonGeographique() {
		return rayonGeographique;
	}
 
	public void setRayonGeographique(String rayonGeographique) {
		this.rayonGeographique = rayonGeographique;
	}
 
	public String toString(){
		return "ID : "+id+"\nPSEUDO : "+pseudo+"\nMAIL : "+mail
				+"\nMOT DE PASSE : "+motDePasse+"\nADRESSE : "+adresse
				+"\nCODE POSTAL : "+codePostal+"\nVILLE : "+ville
				+"\nPLAGES HORAIRES : "+plagesHoraires
				+"\nRAYON GEOGRAPHIQUE : "+rayonGeographique;
	}
}