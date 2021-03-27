package root;
import items.*;
import GUI.*;

public class calc 
{
	//stress = Force / cross sectional area
	//stress = User Input Force / getArea
	
	public static double force(Circle c)
	{
		double f = getForce();
		return f / c.getArea();
	}
	
	public static double force(N_Gon p)
	{
		double f = getForce();
		return f / p.getArea();
	}
	
	public static double force(Rope r)
	{
		double f = getForce();
		return f / r.getArea();
	}
}
