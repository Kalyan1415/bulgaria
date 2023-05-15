package interdisciplinaryProject;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author user
 *
 */
public class Festivity {
	private String name;
	private String region;
	private String date;
	private String history;
	private String landMarks;
	private ArrayList <Gastronomy> gastronomy;

	/**
	 * @param history
	 * @param gastronomy
	 * @param landMarks
	 */
	public Festivity(String name, String region, String date, String history, String landMarks) {
		this.name = name;
		this.region = region;
		this.date = date;
		this.history = history;
		this.landMarks = landMarks;
		gastronomy = new ArrayList<Gastronomy>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the history
	 */
	public String getHistory() {
		return history;
	}

	/**
	 * @param history the history to set
	 */
	public void setHistory(String history) {
		this.history = history;
	}

	/**
	 * @return the gastronomy
	 */

	/**
	 * @param gastronomy the gastronomy to set
	 */

	/**
	 * @return the landMarks
	 */
	public String getLandMarks() {
		return landMarks;
	}

	/**
	 * @param landMarks the landMarks to set
	 */
	public void setLandMarks(String landMarks) {
		this.landMarks = landMarks;
	}
	
	public void registerGastronomy(Gastronomy newGastronomy ){
		gastronomy.add(newGastronomy);
		JOptionPane.showMessageDialog(null, "New gastronomy registered!");
	}
	
	public String printGastronomy(){   
		String s = "\nGastronomy:\n";
	    for (Gastronomy g:gastronomy){ 
	    	 s = s + g + "\n";
	   
	    }
		return s; 
    } 
	
	public String[] getFestivityGastronomies() {
		int count = 0;
        String[] festivitiesGastronomies = new String[30];
		for (Gastronomy g : gastronomy) {
			festivitiesGastronomies[count] = g.getName();
        	   count += 1;
           }
        return festivitiesGastronomies;
	}
	
	public int searchGastronomyByName (String gastronomyName) {
        int k = 0;
        while(k < gastronomy.size() && !gastronomy.get(k).getName().equalsIgnoreCase(gastronomyName)) {
           k++; 
        }
        
        if(k >= gastronomy.size()){
            return -1;
        }else{
            return k;
        }
        
    }

	public void updateFestivityGastronomy(String gastronomyName,String info, String newInfo) {
		int pos = searchGastronomyByName(gastronomyName);
		
        	if (info.equalsIgnoreCase("Type")) {
        		//em falta
        	} else if(info.equalsIgnoreCase("Name")) {
        			gastronomy.get(pos).setName(newInfo);
        			JOptionPane.showMessageDialog(null, "Gastronomy name updated!");
        	}else {
        		gastronomy.get(pos).setDescription(newInfo);
        		JOptionPane.showMessageDialog(null, "Gastronomy description updated!");
        	}
           
        }
	

	@Override
	public String toString() {
		return "Festivity\nname=" + name + "\ndate=" + date + "\nregion=" + region + "\nhistory=" + history + "\nlandMarks=" + landMarks + printGastronomy();
	}

	

	
}