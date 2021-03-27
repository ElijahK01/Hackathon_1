package items;

public abstract class Item implements Material
{
	//updates values of the item
	public abstract void update();
	
	//display for GUI
	public abstract void display();
	
	//length of the material
	public double length;
	public double density;
	public double cStrength;
	public double sStrength;
	public double tStrength;
	public String name;
	
	public abstract double getLength();
}
