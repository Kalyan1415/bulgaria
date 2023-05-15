package interdisciplinaryProject;

public class Wine extends Gastronomy {
	private String wineType;
	
	public Wine(String name, String description, String wineType) {
		super(name, description);
		this.wineType = wineType;
	}
	
	public String getWineType() {
		return wineType;
	}
	
	public void setWineType(String wineType) {
		this.wineType = wineType;
	}
	
	public String toString() { 
		String s = super.toString();
		return s + "\nwineType: " + wineType + "\n";
	}

}
