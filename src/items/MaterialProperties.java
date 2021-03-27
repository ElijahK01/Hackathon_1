package items;

public class MaterialProperties implements Material{
	
	private String name;
	private double density;
	private double tensileStrength;
	private double shearStrength;
	private double compressionStrength;
	
	public MaterialProperties(String n, double d, double ts, double ss, double cs)
	{
		name = n;
		density = d;
		tensileStrength = ts;
		shearStrength = ss;
		compressionStrength = cs;
	}
	
	public MaterialProperties() {
		density = 1;
		tensileStrength = 1;
		shearStrength = 1;
		compressionStrength = 1;
	}

	@Override
	public double getDensity() {
		return density;
	}

	@Override
	public double getTensileStrength() {
		return tensileStrength;
	}

	@Override
	public double getShearStrength() {
		return shearStrength;
	}

	@Override
	public double getCompressionStrength() {
		return compressionStrength;
	}
	
	public String getName() {
		return name;
	}

}
