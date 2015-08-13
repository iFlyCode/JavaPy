package javapy.physics.units;

public class Kelvin extends Unit {

	String unit = "K";

	/**
	 * {@inheritDoc}
	 */
	public Kelvin() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public Kelvin(int initValue) {
		this((double) initValue);
	}

	public Kelvin(double setValue) {
		value = absoluteValue(setValue);
	}

	@Override public void setValue(double setValue) {
		value = absoluteValue(setValue);
	}

	// Force absolute value.
	private double absoluteValue(double input) {
		if (input < 0) { return -input; }
		return input;
	}
}
