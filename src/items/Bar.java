package items;

public abstract class Bar extends Item 
{
	//apathom is the "radius" of a uniform shape
	//equivalent to the radius of a circle
	public double apothem;
	
	public abstract double getApothem();
	
	//area for any shape is .5 * apothem * perimeter, specified in particular class
	public abstract double getArea();
}
