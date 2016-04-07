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

package javapy.maths;

/**
 * The Complex class represents complex numbers. Complex instances are constant; their values cannot be changed after
 * they are created and are hence, immutable.
 *
 * @author ncolaprete
 * @author ifly6
 */
public class Complex {

	private final double real;
	private final double imaginary;

	Complex(double Real, double Imaginary) {
		this.real = Real;
		this.imaginary = Imaginary;
	}

	/**
	 * Returns a string representation of the object in the form <code>a + b<i>i</i></code>.
	 *
	 * @return the string representation
	 */
	@Override public String toString() {
		if (this.imaginary == 0) {
			return Double.toString(this.real);
		} else {
			if (this.real == 0) { return this.imaginary + "i"; }
			return this.real + "+" + this.imaginary + "i";
		}
	}

	/**
	 * Returns a double array containing the real part under index 0 and the imaginary part under index 1.
	 *
	 * @return An array representation of the number in the form <code>{ real, imaginary }</code>
	 */
	public double[] toArray() {
		return new double[] { this.real, this.imaginary };
	}

	/**
	 * Adds this complex number to another one.
	 *
	 * @param num - Complex number to add to.
	 * @return new <code>Complex</code> which is the sum of the two numbers.
	 */
	public Complex add(Complex num) {
		double realfinal = this.real + num.real;
		double imagfinal = this.imaginary + num.imaginary;
		return new Complex(realfinal, imagfinal);
	}

	/**
	 * Subtracts this complex number by another one.
	 *
	 * @param num - Complex number to subtract from.
	 * @return new <code>Complex</code> which is the difference of the two numbers.
	 */
	public Complex subtract(Complex num) {
		double realfinal = this.real - num.real;
		double imagfinal = this.imaginary - num.imaginary;
		return new Complex(realfinal, imagfinal);
	}

	/**
	 * Multiplies this complex number by another one.
	 *
	 * @param num - Complex number to multiply with.
	 * @return new <code>Complex</code> which is the product of the two numbers.
	 */
	public Complex multiply(Complex num) {
		double re = this.real * num.real;
		double im = (this.imaginary * num.real) + (num.imaginary * this.real);
		double imSqrd = (this.imaginary * num.imaginary) * (-1);
		return new Complex(re + imSqrd, im);
	}

	/**
	 * Divides this complex number by another one. If it cannot be divided for some reason, then it will return
	 * <code>null</code>.
	 *
	 * @param num - Complex number to divide by.
	 * @return new <code>Complex</code> which is the quotient of the two numbers.
	 */
	public Complex divide(Complex num) {
		Complex top = this.multiply(num.conjugate());
		Complex bottom = num.multiply(num.conjugate());

		if (bottom.imaginary == 0) {
			return new Complex(top.real / bottom.real, top.imaginary / bottom.real);
		} else {
			return null;
		}
	}

	/**
	 * Returns the conjugate of the Complex number.
	 *
	 * @return the conjugate
	 */
	public Complex conjugate() {
		return new Complex(real, -imaginary);
	}

	/**
	 * Returns this complex number raised to an integer power.
	 *
	 * @param power to raise to
	 * @return the number raised to the given power
	 */
	public Complex raisedTo(int power) {
		Complex to_sender = this;
		for (int i = 0; i < power; i++) {
			to_sender = to_sender.multiply(to_sender);
		}
		return to_sender;
	}

	/**
	 * Returns the absolute magnitude of complex number on the imaginary plane.
	 * 
	 * @return absolute magnitude, as double
	 */
	public double magnitude() {
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
	}
}
