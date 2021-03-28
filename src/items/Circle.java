package items;

public class Circle extends Bar
{
	//private String name;
	
	public Circle()
	{
		apothem = 1;
		length = 10;
		density = 1;
		cStrength = 1;
		sStrength = 1;
		tStrength = 1;
		name = "Unknown Material";
		//get material properties
	}
	
	public Circle(double r, double l, MaterialProperties prop)
	{
		apothem = r;
		length = l;
		cStrength = prop.getCompressionStrength();
		sStrength = prop.getShearStrength();
		tStrength = prop.getTensileStrength();
		density = prop.getDensity();
		name = prop.getName();
	}
	
	@Override
	public double getDensity() {
		// TODO Auto-generated method stub
		return density;
	}

	@Override
	public double getTensileStrength() {
		// TODO Auto-generated method stub
		return tStrength;
	}

	@Override
	public double getShearStrength() {
		// TODO Auto-generated method stub
		return sStrength;
	}

	@Override
	public double getCompressionStrength() {
		// TODO Auto-generated method stub
		return cStrength;
	}

	@Override
	public double getApothem() {
		// TODO Auto-generated method stub
		return apothem;
	}

	@Override
	public double getArea()
	{
		// TODO Auto-generated method stub
		double PI = 3.14159265;
		double a = apothem * apothem * PI;
		return a;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return length;
	}
	
	@Override
	public String getName()
	{
		return name;
	}

//>>>>>>> branch 'master' of https://github.com/ElijahK01/Hackathon_1
}
