package javapy.physics.units;

/**
 * This is the base class for all physical units. It simply gives you a way of storing, getting, and setting the value
 * of the unit.
 *
 * All units should initialise with a value of 0 (if given no initialisation) and should have a unit String attached.
 */
public class Unit implements UnitBean {

	/**
	 * Contains the value of the <code>Unit</code>
	 */
	double value;

	/**
	 * Contains the name of the <code>Unit</code>, for example, 'N' for Newtons or 'kg' for kilogrammes.
	 */
	String unit = "";

	/**
	 * Constructs the <code>Unit</code> with a default initial value of 0.
	 */
	public Unit() {
		value = 0;
	}

	/**
	 * Constructs the <code>Unit</code> with a set initial value.
	 *
	 * @param initValue is the value to which the <code>Unit</code> will be set upon creation
	 */
	public Unit(double initValue) {
		value = initValue;
	}

	/**
	 * Constructs the <code>Unit</code> with a set initial value.
	 *
	 * @param initValue is the value to which the <code>Unit</code> will be set upon creation
	 */
	public Unit(int initValue) {
		this((double) initValue);
	}

	/**
	 * Gets the value of the <code>Unit</code>.
	 *
	 * @return the value of the <code>Unit</code>
	 */
	@Override public double getValue() {
		return value;
	}

	/**
	 * Sets the value of the <code>Unit</code>.
	 *
	 * @param setValue is the new value to which the <code>Unit</code> should be set
	 */
	@Override public void setValue(double setValue) {
		value = setValue;
	}

	/**
	 * Returns a <code>String</code> representation of the <code>Unit</code>, accompanied with the unit name.
	 */
	@Override public String toString() {
		return (Double.toString(value) + " " + unit);
	}
}
