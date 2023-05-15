package interdisciplinaryProject;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Bulgaria {
	private ArrayList <Festivity> bulgaria;

	public Bulgaria() {
		bulgaria = new ArrayList<Festivity>();
	}

	public void registerFestivity (Festivity newFestivity){
		bulgaria.add(newFestivity);
		JOptionPane.showMessageDialog(null, "New festivity registered!");
	}
	
	
	
	public int searchFestivityByName (String festivityName) {
        int k = 0;
        while(k < bulgaria.size() && !bulgaria.get(k).getName().equalsIgnoreCase(festivityName)) {
           k++; 
        }
        
        if(k >= bulgaria.size()){
            return -1;
        }else{
            return k;
        }
        
    }
	
	public String[] filterByRegion (String festivityRegion) {

        int count = 0;
        String[] festivitiesByRegion = new String[30];
		for (Festivity f : bulgaria ) {
           if (f.getRegion().equalsIgnoreCase(festivityRegion)) {
        	   festivitiesByRegion[count] = f.getName();
        	   count += 1;
           }
        }
        return festivitiesByRegion;
     }
	
	public void registerGastronomy(String festivityName, Gastronomy newGastronomy){
        int pos = searchFestivityByName(festivityName);
        if (pos == -1){
        	JOptionPane.showMessageDialog(null, "Festivity not found!");
        }else{
           bulgaria.get(pos).registerGastronomy(newGastronomy);
        }
        
    }
	
	public void displayFestivityDetails(String festivityName){

		int pos = searchFestivityByName(festivityName);
		int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Festivity details:" + "\nName: " + bulgaria.get(pos).getName() + "\nRegion: " + bulgaria.get(pos).getRegion() + "\nDate: " + bulgaria.get(pos).getDate() + "\nKnow more about: 1)History 2)Landmarks 3)Gastronomy 4)Return to menu "));
		while(op != 4) {
			switch(op) {
				case 1:
					JOptionPane.showMessageDialog(null, bulgaria.get(pos).getHistory());
					break;
				case 2:
					JOptionPane.showMessageDialog(null, bulgaria.get(pos).getLandMarks());
					break;
				case 3:
					JOptionPane.showMessageDialog(null, bulgaria.get(pos).printGastronomy());
					break;
				
			}
			
			op = Integer.parseInt(JOptionPane.showInputDialog(null, "Festivity details:" + "\nName: " + bulgaria.get(pos).getName() + "\nRegion: " + bulgaria.get(pos).getRegion() + "\nDate: " + bulgaria.get(pos).getDate() + "\nKnow more about: 1)History 2)Landmarks 3)Gastronomy 4)Return to menu "));	
		}
		
	}

	public int countFestivites() {
		int count = 0;
		for (int i = 0;i < bulgaria.size();i++) {
			count++;
		}
		return count;
	}
	
	public String[] getFestivitiesNames () {

        int count = 0;
        String[] festivitiesNames = new String[30];
		for (Festivity f : bulgaria) {
			festivitiesNames[count] = f.getName();
        	   count += 1;
           }
        return festivitiesNames;
     }

	public void updateFestivityInfo(String festivityName, String info, String newInfo) {
		int pos = searchFestivityByName(festivityName);
		if (pos == -1){
			JOptionPane.showMessageDialog(null, "Festivity not found!");
        }else{
        	if (info.equalsIgnoreCase("Region")) {
        		bulgaria.get(pos).setRegion(newInfo);
        		JOptionPane.showMessageDialog(null, "Region updated!");
        	} else if(info.equalsIgnoreCase("History")) {
        			bulgaria.get(pos).setHistory(newInfo);
        			JOptionPane.showMessageDialog(null, "History updated!");
        	}else {
        		bulgaria.get(pos).setLandMarks(newInfo);
        		JOptionPane.showMessageDialog(null, "Landmarks updated!");
        	}
           
        }
	}
	
	public void updateFestivityGastronomy(String festivityName, String gastronomy, String info, String newInfo) {
		int pos = searchFestivityByName(festivityName);
		if (pos == -1){
			JOptionPane.showMessageDialog(null, "Festivity not found!");
        }else{
        	bulgaria.get(pos).updateFestivityGastronomy(gastronomy, info, newInfo);
        }
	}
	

	public String[] getFestivityGastronomies(String festivityName) {
		 int pos = searchFestivityByName(festivityName);
	     return bulgaria.get(pos).getFestivityGastronomies();
	}
}//end Bulgaria
