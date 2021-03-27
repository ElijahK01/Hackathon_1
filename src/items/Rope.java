package items;

public class Rope extends Item{
	
	private double density;
	private double tensileStrength;
	private double shearStrength;
	private double compressionStrength = 0;
	private double length;
	
	@Override
	public double getDensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTensileStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getShearStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCompresionStrength() {
		// TODO Auto-generated method stub
		return compressionStrength;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		
	}

	@Override
	public double getLength() 
	{
		return length;
	}

}
