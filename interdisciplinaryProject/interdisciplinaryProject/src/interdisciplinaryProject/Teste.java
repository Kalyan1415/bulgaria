package interdisciplinaryProject;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * 
 */


/**
 * @author vascosantos
 * @version 03/05
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bulgaria bulgarianFestivities = new Bulgaria();
		String adminPassword = "1234";
		String[] regions = {"Blagoevgrad", "Burgas", "Dobrich", "Gabrovo", "Haskovo" };
		String[] gastronomyTypes = {"Dish", "Wine"};
		String[] dishTypes = {"Meat", "Fish", "Vegeterian", "Vegan"};
		String[] wineTypes = {"Red", "White", "Rosé", "Sparkling"};
		String[] festivityInfo = {"Region", "History", "Landmarks"};
		String[] gastronomyInfo = {"Name", "Description", "Type"};
		
		int op = Integer.parseInt(JOptionPane.showInputDialog("1. Enter as admin\n2.Enter as tourist"));
		
		if(op == 1) {
			String password = JOptionPane.showInputDialog("Admin password:");
			
			while(!password.equalsIgnoreCase(adminPassword)) {
				JOptionPane.showMessageDialog(null, "Wrong Password!");
				password = JOptionPane.showInputDialog("Admin password:");
			}
			 op = menuAdmin();
			
			while(op != 6) {
				switch(op) {
				  case 1:
					Festivity newFestivity;
					String name = JOptionPane.showInputDialog("Name?");
					String region = (String) JOptionPane.showInputDialog(null,"Region?","Choose region", JOptionPane.QUESTION_MESSAGE, null, regions, regions[4]);
					//String region = JOptionPane.showInputDialog("Region?\n1)Blagoevgrad\n2)Burgas\n 3)	Dobrich 4)	Gabrovo 5)	Haskovo 6)	Kardzhali 7)	Kyustendil 8)	Lovech 9)	Montana 10)	Pazardzhik 11)	Pernik 12)	Pleven 13)	Plovdiv 14)	Razgrad 15)	Ruse 16)	Shumen 17)	Silistra 18)	Sliven 19)	Smolyan 20)	Sofia (capital city) 21)	Sofia Province 22)	Stara Zagora 23)	Targovishte 24)	Varna 25)	Veliko Tarnovo 26)	Vidin 27)	Vratsa 28)	Yambol ");
					String date = JOptionPane.showInputDialog("Date? format: dd-mm");
					String history = JOptionPane.showInputDialog("History?");
					String landmarks = JOptionPane.showInputDialog("Landmarks?"); 
					newFestivity = new Festivity(name, region, date, history, landmarks);
				    bulgarianFestivities.registerFestivity(newFestivity);
				   
				    break;
				  case 2:
					  if (bulgarianFestivities.countFestivites() == 0) {
							JOptionPane.showMessageDialog(null, "No festivities have been added yet.");
						}else {
							  Gastronomy newGastronomy;
							  String[] festivitiesNames = bulgarianFestivities.getFestivitiesNames();
							  String festivityName = (String) JOptionPane.showInputDialog(null,"Festivity?","Choose festivity", JOptionPane.QUESTION_MESSAGE, null, festivitiesNames, festivitiesNames[festivitiesNames.length - 1]);
							  String gastronomyType = (String) JOptionPane.showInputDialog(null,"Gastronomy type?","Choose type", JOptionPane.QUESTION_MESSAGE, null, gastronomyTypes, gastronomyTypes[1]);
							  
							  if (gastronomyType.equalsIgnoreCase("Dish")) {
								  String dishName = JOptionPane.showInputDialog("Dish name?");
								  String dishDescription = JOptionPane.showInputDialog("Dish description?");
								  String dishType = (String) JOptionPane.showInputDialog(null,"Dish type?","Choose type", JOptionPane.QUESTION_MESSAGE, null, dishTypes, dishTypes[3]);
								  newGastronomy = new Dish(dishName, dishDescription, dishType);
							  }else {
								  String wineName = JOptionPane.showInputDialog("Wine name?");
								  String wineDescription = JOptionPane.showInputDialog("Wine description?");
								  String wineType = (String) JOptionPane.showInputDialog(null,"Wine type?","Choose type", JOptionPane.QUESTION_MESSAGE, null, wineTypes, wineTypes[3]);
								  newGastronomy = new Wine(wineName, wineDescription, wineType);
							  }
							  bulgarianFestivities.registerGastronomy(festivityName, newGastronomy);
						}
				    break;
				  case 3:
					  String newInfo;
					  if (bulgarianFestivities.countFestivites() == 0) {
							JOptionPane.showMessageDialog(null, "No festivities have been added yet.");
						}else {
							  String[] festivitiesNames = bulgarianFestivities.getFestivitiesNames();
							  name = (String) JOptionPane.showInputDialog(null,"Festivity?","Choose festivity", JOptionPane.QUESTION_MESSAGE, null, festivitiesNames, festivitiesNames[festivitiesNames.length - 1]);
							  String info = (String) JOptionPane.showInputDialog(null,"Which information do you want to change?","Choose information", JOptionPane.QUESTION_MESSAGE, null, festivityInfo, festivityInfo[festivityInfo.length - 1]);
							  if (info.equalsIgnoreCase("Region")) {
								  newInfo = (String) JOptionPane.showInputDialog(null,"Region?","Choose region", JOptionPane.QUESTION_MESSAGE, null, regions, regions[4]);
							  }else {
								   newInfo = JOptionPane.showInputDialog("New information?");
							  }
							  
							  bulgarianFestivities.updateFestivityInfo(name, info, newInfo);
					  }
					  
					  
					  
					
					break;
				  case 4:
					  String[] festivitiesNames = bulgarianFestivities.getFestivitiesNames();
					  name = (String) JOptionPane.showInputDialog(null,"Festivity?","Choose festivity", JOptionPane.QUESTION_MESSAGE, null, festivitiesNames, festivitiesNames[festivitiesNames.length - 1]);
					  String[] festivityGastronomies = bulgarianFestivities.getFestivityGastronomies(name);
					  String gastronomy = (String) JOptionPane.showInputDialog(null,"Which gastronomy do you want to change?","Choose gastronomy", JOptionPane.QUESTION_MESSAGE, null, festivityGastronomies, festivityGastronomies[festivityGastronomies.length - 1]);
					  String info = (String) JOptionPane.showInputDialog(null,"What do you want to update?","Choose information to update", JOptionPane.QUESTION_MESSAGE, null, gastronomyInfo, gastronomyInfo[gastronomyInfo.length - 1]);
					  if (info.equalsIgnoreCase("Type")) {
						  newInfo = (String) JOptionPane.showInputDialog(null,"Region?","Choose region", JOptionPane.QUESTION_MESSAGE, null, regions, regions[4]);
					  }else {
						   newInfo = JOptionPane.showInputDialog("New information?");
					  }
					  bulgarianFestivities.updateFestivityGastronomy(name, gastronomy, info, newInfo);
					
					break;
				  case 5:
					if (bulgarianFestivities.countFestivites() == 0) {
						JOptionPane.showMessageDialog(null, "No festivities have been added yet.");
					}else {
						region = (String) JOptionPane.showInputDialog(null,"Region?","Choose region", JOptionPane.QUESTION_MESSAGE, null, regions, regions[4]);
						String[] festivitiesByRegion = bulgarianFestivities.filterByRegion(region);
					    name = (String) JOptionPane.showInputDialog(null,"Festivity name?","Choose festivity", JOptionPane.QUESTION_MESSAGE, null, festivitiesByRegion, festivitiesByRegion[festivitiesByRegion.length - 1]);
					    bulgarianFestivities.displayFestivityDetails(name);
					}
					
				    
					break;
				  default:
				    // code block
				}//end switch
				op = menuAdmin();
			}//end while
		}else {
			 op = menuUser();
			
			while(op != 2) {
				switch(op) {
				  case 1:
				    // code block
				    break;
				  case 2:
				    // code block
				    break;
				  case 3:
					    // code block
					    break;
				  default:
				    // code block
				}//end switch
				op = menuUser();
			}//end while
		}//end if
		
		
	}//end main
	
	public static int menuAdmin() {
		int opAdmin = Integer.parseInt(JOptionPane.showInputDialog("1. Add festivity\n2. Register gastrinomic tradition\n3. Change festivity\n4. Change gastronomy\n5. Search\n6. Exit"));
		return opAdmin;
	}//end menuAdmin
	
	public static int menuUser() {
		 int opUser = Integer.parseInt(JOptionPane.showInputDialog("1. Search festivity\n2. Exit"));
		 return opUser;
	}//end menuUser
}//end Test
