package javapy.maths;

/**
 * Methods related to Algebra should go here.
 */
public class Algebra {
	
	/**
	 * <strong><em>
	 * <Ul><li>quadForm</ul></li>
	 * </em></strong>
	 * <p style="font-family:Courier">public double[] quadForm(double a, double b, double c)</p>
	 * <p>Method that does the quadratic formula.</p>
	 * 
	 * @param a
	 *            - Coefficient of x^2
	 * @param b
	 *            - Coefficient of x
	 * @param c
	 *            - Constant
	 * @return Array of doubles with the two answers.
	 */
	public double[] quadForm(double a, double b, double c) {
		double[] answer = new double[1];

		answer[0] = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;
		answer[1] = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;

		return answer;
	}

	/**
	 * <strong><em>
	 * <Ul><li>pythagThrm</ul></li>
	 * </em></strong>
	 * <p style="font-family:Courier">public double pythagThrm(double legA, double legB, boolean unknownHypotenuse)</p>
	 * <p>Pythagorean theorem method.</p>
	 * 
	 * @author ifly6
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
