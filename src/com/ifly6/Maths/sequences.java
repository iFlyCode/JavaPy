package com.ifly6.Maths;

public class sequences {

	/**
	 * Raise a number to an integer power.
	 * 
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

	/**
	 * Calculates the total of a converging sequence.
	 * 
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

	// Do regression
}
