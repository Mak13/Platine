package lille1.eservices.sporaction.model;

public class Profil_Partie {
	private int id;
	private int profilId;
	private int partieId;
 
	public Profil_Partie(){}
 
	public Profil_Partie(int id, int profilId, int partieId){
		this.id = id;
		this.profilId = profilId;
		this.partieId = partieId;
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
 
	public int getPartieId() {
		return partieId;
	}
 
	public void setPartieId(int partieId) {
		this.partieId = partieId;
	}
	
	public String toString(){
		return "ID : "+id+"\nPROFIL ID : "+profilId
				+"\nPARTIE ID : "+partieId;
	}
}