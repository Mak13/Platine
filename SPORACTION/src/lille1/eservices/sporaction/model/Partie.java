package lille1.eservices.sporaction.model;

public class Partie {
	private int id;
	private String date;
	private String horaire;
	private int sportId;
	private String niveau;
	private String ville;
	private String type;
	private int terrainId;
 
	public Partie(){}
 
	public Partie(int id, String date, String horaire, int sportId,
			String niveau, String ville, String type, int terrainId){
		this.id = id;
		this.date = date;
		this.sportId = sportId;
		this.horaire = horaire;
		this.niveau = niveau;
		this.ville = ville;
		this.type = type;
		this.terrainId = terrainId;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getDate() {
		return date;
	}
 
	public void setDate(String date) {
		this.date = date;
	}
 
	public String getHoraire() {
		return horaire;
	}
 
	public void setHoraire(String horaire) {
		this.horaire = horaire;
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
	
	public String getVille() {
		return ville;
	}
 
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getType() {
		return type;
	}
 
	public void setType(String type) {
		this.type = type;
	}
	
	public int getTerrainId() {
		return terrainId;
	}
 
	public void setTerrainId(int terrainId) {
		this.terrainId = terrainId;
	}
	
	public String toString(){
		return "ID : "+id+"\nDATE : "+date+"\nHORAIRE : "+horaire
				+"\nSPORT ID : "+sportId+"\nNIVEAU : "+niveau
				+"\nVILLE : "+ville+"\nTYPE : "+type
				+"\nTERRAIN ID : "+terrainId;
	}
}