package javapy.physics;

/**
 * Methods relating to the physics concept of Gravitation should go here, sorted
 * by which parameter in which they apply, like Newtonian, etc.
 */
public class Gravitation {

	/**
	 * <ul><li><b><i>
	 * earth
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public double earth(double mass)
	 * </p><p>
	 * Calculate the Newtons of an object falling in standard Paris gravity.</p>
	 * 
	 * @param mass
	 *            - Mass of the object in question.
	 * @return Amount of force of object, in Newtons.
	 */
	public double earth(double mass) {
		return mass * 9.81;
	}

	/**
	 * <ul><li><b><i>
	 * newtonian
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public double newtonian(double mass1, double mass2, double distance)
	 * </p><p>
	 * This is a caller for the other Newtonian gravitation class - just with
	 * the gravitational constant hard-coded into the programme.</p>
	 * 
	 * @param mass1
	 *            - Mass of first object
	 * @param mass2
	 *            - Mass of second object
	 * @param distance
	 *            - distance between the two masses
	 * @return
	 * @see newtonian(double, double, double, double)
	 */
	public double newtonian(double mass1, double mass2, double distance) {
		// Gravitational Constant = 6.6738480 E-11
		double newtons = newtonian(mass1, mass2, distance, 6.6738480E-11);
		return newtons;
	}

	/**
	 * <ul><li><b><i>
	 * newtonian
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public double newtonian(double mass1, double mass2, double distance,
	 * double gravConstant)
	 * </p><p>
	 * Calculates from the four criteria, the total gravitational attraction
	 * between the two objects.</p>
	 * 
	 * @param mass1
	 *            - Mass of first object
	 * @param mass2
	 *            - Mass of second object
	 * @param distance
	 *            - distance between the two masses
	 * @param gravConstant
	 *            - the gravitational constant
	 * @return
	 */
	public double newtonian(double mass1, double mass2, double distance,
			double gravConstant) {
		double newtons = gravConstant
				* ( (mass1 * mass2) / (distance * distance) );
		return newtons;
	}

}
