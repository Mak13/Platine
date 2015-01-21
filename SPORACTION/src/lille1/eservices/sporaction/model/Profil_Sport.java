package lille1.eservices.sporaction.model;

public class Profil_Sport {
	private int id;
	private int profilId;
	private int sportId;
	private String niveau;
 
	public Profil_Sport(){}
 
	public Profil_Sport(int id, int profilId, int sportId, String niveau){
		this.id = id;
		this.profilId = profilId;
		this.sportId = sportId;
		this.niveau = niveau;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public int getProfilId() {
		return profilId;
	}
 
	public void setProfilId(int profilId) {
		this.profilId = profilId;
	}
 
	public int getSportId() {
		return sportId;
	}
 
	public void setSportId(int sportId) {
		this.sportId = sportId;
	}
	
	public String getNiveau() {
		return niveau;
	}
 
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	public String toString(){
		return "ID : "+id+"\nPROFIL ID : "+profilId
				+"\nSPORT ID : "+sportId
				+"\nNIVEAU : "+niveau;
	}
}