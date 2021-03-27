package items;

public abstract class Bar extends Item 
{
	//apathom is the "radius" of a uniform shape
	//equivalent to the radius of a circle
	private double apathom;
	
	public abstract double getApathom();
	
	//area for any shape is .5 * apathom * perimeter, specified in particular class
	public abstract double getArea();
}
