package javapy.physics;

/**
 * Methods relating to the physics concept of Gravitation should go here, sorted
 * by which parameter in which they apply, like Newtonian, etc.
 */
public class Gravitation {

	/**
	 * Calculate the Newtons of an object falling in standard Paris gravity.
	 * 
	 * @param mass
	 *            - Mass of the object in question.
	 * @return Amount of force of object, in Newtons.
	 */
	public double earth(double mass) {
		return mass * 9.81;
	}

	/**
	 * This is a caller for the other Newtonian gravitation class - just with
	 * the gravitational constant hard-coded into the programme.
	 * 
	 * @param mass1
	 *            - Mass of first object
	 * @param mass2
	 *            - Mass of second object
	 * @param distance
	 *            - distance between the two
	 * @return
	 * @see newtonian(double, double, double, double)
	 */
	public double newtonian(double mass1, double mass2, double distance) {
		// Gravitational Constant = 6.6738480 E-11
		double newtons = newtonian(mass1, mass2, distance, 6.6738480E-11);
		return newtons;
	}

	/**
	 * Calculates from the four criteria, the total gravitational attraction
	 * between the two objects.
	 * 
	 * @param mass1
	 *            - Mass of first object
	 * @param mass2
	 *            - Mass of second object
	 * @param distance
	 *            - distance between the two
	 * @param gravConstant
	 *            - the gravitational constant
	 * @return
	 */
	public double newtonian(double mass1, double mass2, double distance,
			double gravConstant) {
		double newtons = gravConstant
				* ((mass1 * mass2) / Math.pow(distance, 2));
		return newtons;
	}

}
