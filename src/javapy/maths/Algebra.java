package javapy.maths;

/**
 * Methods related to Algebra should go here.
 */
public class Algebra {

	/**
	 * Does the quadratic formula and returns the answers.
	 *
	 * @param a - coefficient of x<sup>2</sup>
	 * @param b - coefficient of x
	 * @param c - constant
	 * @return <code>double[]</code> with the answers
	 */
	public static double[] quadForm(double a, double b, double c) {
		double[] answer = new double[1];

		answer[0] = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;
		answer[1] = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;

		return answer;
	}

	/**
	 * Does the Pythagorean Theorem and returns the length of the missing leg. Quite helpful when dealing with vectors
	 * with magnitude.
	 *
	 * @author ifly6
	 * @param legA - leg of right triangle, <i>a</i> (or, in the case of not knowing the leg, the hypotenuse)
	 * @param legB - leg of right triangle, <i>b</i>
	 * @param unknownHypotenuse - whether we know the hypotenuse.
	 * @return length of the missing leg
	 */
	public static double pythagThrm(double legA, double legB, boolean unknownHypotenuse) {
		if (unknownHypotenuse == true) { return Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2)); }
		if (unknownHypotenuse == false) {
			return Math.sqrt(Math.pow(legA, 2) - Math.pow(legB, 2));
		} else {
			return 0;
		}
	}
}
