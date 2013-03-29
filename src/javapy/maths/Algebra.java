package javapy.maths;

/**
 * Methods related to Algebra should go here.
 */
public class Algebra {

	public double[] quadForm(double a, double b, double c) {
		double[] answer = new double[1];

		answer[0] = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;
		answer[1] = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;

		return answer;
	}

	/**
	 * Pythagorean theorem method.
	 * 
	 * @param legA
	 *            - Leg of Right Triangle, A (or, in the case of not knowing the
	 *            leg, Hypotenuse)
	 * @param legB
	 *            - Leg of Right Triangle, B
	 * @param unknownHypotenuse
	 *            - Whether we know the Hypotenuse.
	 * @return
	 */
	public double pythagThrm(double legA, double legB, boolean unknownHypotenuse) {
		if (unknownHypotenuse == true) {
			return Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2));
		}
		if (unknownHypotenuse == false) {
			return Math.sqrt(Math.pow(legA, 2) - Math.pow(legB, 2));
		} else {
			return 0;
		}
	}
}
