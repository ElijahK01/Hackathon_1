package items;

import java.util.ArrayList;

public class Rope extends Item{
	
	private double density;
	private double tensileStrength;
	private double shearStrength;
	private double compressionStrength = 0;
	private double length;
	private double girth;
	private double totalForce;
	
	private ArrayList<Strand> strands = new ArrayList<Strand>();
	
	public Rope(int strandCount, double l, double g, MaterialProperties m) {
		density = m.getDensity();
		tensileStrength = m.getTensileStrength();
		shearStrength = m.getShearStrength();
		compressionStrength = m.getShearStrength();
		length = l;
		girth = g;
		
		double strandWidth = girth/strandCount;
		
		for(int i = 0; i < strandCount; i++) {
			strands.set(i, new Strand(strandWidth, m));
		}
	}
	
	public double getTotalForce() {
		return totalForce;
	}
	
	public void setTotalForce(double f) {
		totalForce = f;
	}
	
	@Override
	public double getDensity() {
		// TODO Auto-generated method stub
		return density;
	}

	@Override
	public double getTensileStrength() {
		// TODO Auto-generated method stub
		return tensileStrength;
	}

	@Override
	public double getShearStrength() {
		// TODO Auto-generated method stub
		return shearStrength;
	}

	@Override
	public double getCompressionStrength() {
		// TODO Auto-generated method stub
		return compressionStrength;
	}
	
	@Override
	public void update() {
		int offset = 0;
		for(int i = 0; i < strands.size(); i++) {
			Strand s = strands.get(i);
			double strandWidth = s.getDiameter();
			
			// force to each strand will change if implementing individual strand calculations
			strands.get(i).setLoad(totalForce / strands.size());
			
			if (strands.get(i).snapped()) {
				strands.remove(i);
				offset ++;
			}
		}
		
	}

	@Override
	public void display() {
		
	}

	@Override
	public double getLength() 
	{
		return length;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
