package javapy.maths;

public class sequences {

	/**
	 * Calculates the total of a converging sequence.
	 * 
	 * @author ifly6
	 * @param r
	 *            - the factor of increasure
	 * @param starting
	 *            - the value at f(0)
	 * @return what number the equation converges to.
	 */
	public double converingSequence(double r, double starting) {
		double fraction = 1 / (1 - r);
		double returned = starting * fraction;
		return returned;
	}

	/**
	 * Returns the n'th number in the Fibonacci sequence
	 * 
	 * @author ncolaprete
	 * 
	 * @param n
	 *            - the number input
	 * @return n'th number in the sequence
	 */
	public int fibonacci(int n) {
		if (n == 1) {
			return 1;
		} else if (n <= 0) {
			return 0;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	/**
	 * Raise a number to an integer power.
	 * 
	 * @author ifly6
	 * @param number
	 *            - the base
	 * @param raisedTo
	 *            - what we're raising it to
	 * @return
	 */
	public double power(double number, int raisedTo) {
		for (int x = 0; x < raisedTo; x++) {
			number = number * number;
		}
		return number;
	}

	// Do regression
}
