package items;

public class Strand{
	
	private double load = 0;
	private double maxLoad;
	private double diameter;
	
	public Strand(double d, MaterialProperties m) 
	{
		diameter = d;
		maxLoad = 1;
	}

	public double getLoad() 
	{
		return load;
	}
	
	public void setLoad(double f)
	{
		load = f;
	}
	
	public double getDiameter() 
	{
		return diameter;
	}
	
	public boolean snapped() {
		return (load > maxLoad ? true : false);
	}
	
	

}
