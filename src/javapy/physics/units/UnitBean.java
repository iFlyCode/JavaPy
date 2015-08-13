package javapy.physics.units;

public interface UnitBean {

	double unit = 0;
	String value = "";

	public double getValue();

	public void setValue(double setValue);

	@Override public String toString();
}
