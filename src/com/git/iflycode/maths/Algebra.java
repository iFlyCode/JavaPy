/* Copyright (c) 2015 Kevin Wong and Nicholas Colaprete
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. */

package com.git.iflycode.maths;

import com.git.iflycode.util.exceptions.ComplexNumberException;

/**
 * Methods related to Algebra should go here. These are entirely for the purpose of solving questions faster than ever
 * before.
 *
 * @author ifly6
 * @author ncolaprete
 */
public final class Algebra {

	/**
	 * Constructor is private to prevent the creation of an instance.
	 */
	private Algebra() {

	}

	/**
	 * Does the quadratic formula and returns the answers. Note that there is no checking process should the square root
	 * method return a NaN value.
	 *
	 * @param a - coefficient of x<sup>2</sup>
	 * @param b - coefficient of x
	 * @param c - constant
	 * @return <code>double[]</code> with the two answers
	 * @throws ComplexNumberException if the discriminant is negative, as the square root of negative numbers are
	 *             outside the real numbers.
	 */
	public static double[] quadForm(double a, double b, double c) throws ComplexNumberException {
		double[] answer = new double[1];

		double discriminant = Math.pow(b, 2) - (4 * a * c);
		if (Number.isNegative(discriminant)) { throw new ComplexNumberException(
				"Discriminant, " + discriminant + ", is negative. Square roots of negative numbers are impossible."); }
		answer[0] = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;
		answer[1] = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;

		return answer;
	}

	/**
	 * This method does the quadratic formula and returns the answers. Note that the answers here are in the form of
	 * complex numbers and therefore are outside the realm of the real numbers.
	 *
	 * @param a is the coefficient of x<sup>2</sup>
	 * @param b is the coefficient of x
	 * @param c is a constant
	 * @return <code>Complex[]</code> with two answers
	 */
	public static Complex[] cQuadForm(double a, double b, double c) {
		int complexArgument = 0;
		double discriminant = Math.pow(b, 2) - (4 * a * c);

		if (Number.isNegative(discriminant)) {
			complexArgument = 1;
		}

		Complex answer1 = new Complex((-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a, complexArgument);
		Complex answer2 = new Complex((-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a, complexArgument);

		return new Complex[] { answer1, answer2 };
	}

	/**
	 * Does the Pythagorean Theorem and returns the length of the missing leg. Helpful when dealing with two dimensional
	 * vectors with magnitude.
	 *
	 * @author ifly6
	 * @param legA is a leg of right triangle, <i>a</i> (or, in the case of knowing the leg, the hypotenuse)
	 * @param legB is a leg of right triangle, <i>b</i>
	 * @param unknownHypotenuse - whether we know the hypotenuse
	 * @return the length of the missing leg
	 * @throws ComplexNumberException if the triangle is not a valid triangle
	 */
	public static double pythagThrm(double legA, double legB, boolean unknownHypotenuse) throws ComplexNumberException {
		if (unknownHypotenuse == true) {
			double answer = Math.hypot(legA, legB);
			if (Double.isNaN(answer)) { throw new ComplexNumberException(); }
			return answer;

		} else {
			double answer = Math.sqrt(Math.pow(legA, 2) - Math.pow(legB, 2));
			if (Double.isNaN(answer)) { throw new ComplexNumberException(); }
			return answer;
		}
	}

	/**
	 * This method computes the magnitude of a vector with any number of dimensions.
	 *
	 * @param components of the vector
	 * @return the magnitude of the vector given the components
	 */
	public static double vectorMagnitude(double... components) {
		double squares = 0;

		for (double element : components) {
			squares = squares + Math.pow(element, 2);
		}

		return Math.sqrt(squares);
	}
}
