package items;

public class N_Gon extends Bar
{
	private int numSides;
	
	public N_Gon()
	{
		apothem = 1;
		length = 10;
		density = 1;
		numSides = 4;
		cStrength = 1;
		sStrength = 1;
		tStrength = 1;
		name = "Unknown Material";
		//get material properties
	}
	
	public N_Gon(double r, double l, int nS, MaterialProperties prop)
	{
		apothem = r;
		length = l;
		numSides = nS;
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
		double degIF = (numSides - 2) * 180;
		double degPA = degIF / numSides;
		degPA /= 2;
		double side = (2 * apothem)/ Math.tan(degPA);
		return 0.5 * apothem * numSides * side;
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

}
