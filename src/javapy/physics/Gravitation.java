package javapy.physics;

import javapy.physics.units.Kilogram;
import javapy.physics.units.Metre;
import javapy.physics.units.Newton;

/**
 * Methods relating to the physics concept of Gravitation should go here, sorted by which parameter in which they apply,
 * like Newtonian, etc.
 */
public class Gravitation {

	public static final double gravitationalConstant = 6.67384E-11;
	public static final double seaLevelGravity = 9.8196;

	/**
	 * Calculates the force of an object falling in standard Earth gravity.
	 *
	 * @param mass of the object in question.
	 * @return the force in Newtons exerted by the object in Earth sea-level gravity
	 */
	public static Newton earth(Kilogram mass) {
		return new Newton(mass.getValue() * 9.8196);
	}

	/**
	 * Calculates the force exerted by an object by another with the standard gravitational constant.
	 *
	 * @param mass1 of first object
	 * @param mass2 of second object
	 * @param distance between the two masses
	 * @return the force in Newtons exerted by the object in Earth sea-level gravity
	 */
	public static Newton newtonian(Kilogram mass1, Kilogram mass2, Metre distance) {
		return newtonian(mass1, mass2, distance, gravitationalConstant);
	}

	/**
	 * Calculates the force exerted by an object by another with a custom gravitational constant.
	 *
	 * @param mass1 of first object
	 * @param mass2 of second object
	 * @param distance - distance between the two masses
	 * @param gravConstant - the gravitational constant
	 * @return
	 */
	public static Newton newtonian(Kilogram mass1, Kilogram mass2, Metre distance, double gravConstant) {
		double newtons = gravConstant * ((mass1.getValue() * mass2.getValue()) / (Math.pow(distance.getValue(), 2)));
		return new Newton(newtons);
	}
}
