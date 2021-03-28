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
	
	public static double getForce() 
	{
		return 0;
	}

	public static double simulateStress(MaterialProperties m, double forceApplied, double objectLength,
			double forceLocation) {
		
		// calculate force as a percent of the maximum force bearable
		
		return 100.0;
	}
}
