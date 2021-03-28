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
			double forceLocation, double apothemMeasurement, int sideCount, boolean shear, double area) {
		
		double pMax = 100;
		double pApplied = 1;
		
		if(shear) {
			pMax = m.getShearStrength() * area;
			pApplied = forceLocation * forceApplied;
			
		}
		else {
			pMax = m.getTensileStrength() * area;
			pApplied = forceApplied / area;
		}
		// calculate force as a percent of the maximum force bearable
		
		// shear is force applied * distance
		return (pApplied/pMax) * 100;
	}
}
