package interdisciplinaryProject;

public class Dish extends Gastronomy {
	private String dishType;
	
	public Dish(String name, String description, String dishType) {
		super(name, description);
		this.dishType = dishType;
	}
	
	public String getDishType() {
		return dishType;
	}
	
	public void setDishType(String dishType) {
		this.dishType = dishType;
	}
	
	public String toString() { 
		String s = super.toString();
		return s + "\nDishType: " + dishType + "\n";
	}

}
