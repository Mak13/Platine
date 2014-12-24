package lille1.eservices.sporaction;


public class Profil {
	private int id;
	private String pseudo;
	private String mail;
	private String motDePasse;
	private String adresse;
	private String codePostal;
	private String ville;
	private String sportsPratiques;
	private String niveauxPratiques;
	private String plagesHoraires;
	private String rayonGeographique;
	private String rememberMe;
 
	public Profil(){}
 
	public Profil(int id, String pseudo, String mail, String motDePasse,
			String adresse, String codePostal, String ville, 
			String sportsPratiques, String niveauxPratiques, 
			String plagesHoraires, String rayonGeographique, String rememberMe){
		this.id = id;
		this.pseudo = pseudo;
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.sportsPratiques = sportsPratiques;
		this.niveauxPratiques = niveauxPratiques;
		this.plagesHoraires = plagesHoraires;
		this.rayonGeographique = rayonGeographique;
		this.rememberMe = rememberMe;
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
	
	public String getSportsPratiques() {
		return sportsPratiques;
	}
 
	public void setSportsPratiques(String sportsPratiques) {
		this.sportsPratiques = sportsPratiques;
	}
	
	public String getNiveauxPratiques() {
		return niveauxPratiques;
	}
 
	public void setNiveauxPratiques(String niveauxPratiques) {
		this.niveauxPratiques = niveauxPratiques;
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
	
	public String getRememberMe() {
		return rememberMe;
	}
 
	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
 
	public String toString(){
		return "ID : "+id+"\nPSEUDO : "+pseudo+"\nMAIL : "+mail
				+"\nMOT DE PASSE : "+motDePasse+"\nADRESSE : "+adresse
				+"\nCODE POSTAL : "+codePostal+"\nVILLE : "+ville
				+"\nSPORTS PRATIQUES : "+sportsPratiques
				+"\nNIVEAUX DE PRATIQUES : "+niveauxPratiques
				+"\nPLAGES HORAIRES : "+plagesHoraires
				+"\nRAYON GEOGRAPHIQUE : "+rayonGeographique
				+"\n`REMEMBER ME : "+rememberMe;
	}
}
