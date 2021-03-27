package items;

public abstract class Item implements Material
{
	//updates values of the item
	public abstract void update();
	
	//display for GUI
	public abstract void display();
	
	//length of the material
	private double length;
	private double density;
	private double tensionStrength;
	private double sStrength;
	private double tensileStrength;
	
	public abstract double getLength();
}
