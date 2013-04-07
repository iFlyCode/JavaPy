package javapy.maths;

public class Complex {
  
	double real;
	double imaginary;
	Complex(double real_in, double imaginary_in) {
		this.real = real_in;
		this.imaginary = imaginary_in;
	}
	
	public String toString() {
		if (this.imaginary == 0)
			return this.real + "";
		if (this.real == 0)
			return this.imaginary + "i";
		if (this.imaginary < 0)
			return this.real + this.imaginary + "i";
		return this.real + "+" + this.imaginary + "i";
	}
	
	/**
	 * Returns a double array containing the real
	 * part under index 0 and the imaginary part
	 * under index 1.
	 * 
	 * @return An array instance of the number
	 */
	public double[] toArray() {
		return new double[] {this.real, this.imaginary};
	}
	
	/**
	 * Adds this complex number to another one.
	 * @param num - Complex number to add to.
	 * @return The sum of the two numbers.
	 */
	public Complex plus(Complex num) {
		double realfinal = this.real + num.real;
		double imagfinal = this.imaginary + num.imaginary;
		return new Complex(realfinal, imagfinal);
	}

	/**
	 * Subtracts another complex number from this one.
	 * @param num - Complex number to subtract.
	 * @return The difference of the two numbers.
	 */
	public Complex minus(Complex num) {
		double realfinal = this.real - num.real;
		double imagfinal = this.imaginary - num.imaginary;
		return new Complex(realfinal, imagfinal);
	}
	

	/**
	 * Multiplies this complex number with another one.
	 * @param num - Complex number to multiply with.
	 * @return The product of the two numbers.
	 */
	public Complex times(Complex num) {
		double re = this.real * num.real;
		double im = (this.imaginary * num.real) + (num.imaginary * this.real);
		double imSqrd = (this.imaginary * num.imaginary) * (-1);
		return new Complex(re + imSqrd, im);
	}
	
	/**
	 * Returns the quotient of this and another complex
	 * number
	 * @param num - Number to divide by.
	 * @deprecated
	 * @return null
	 */
	public Complex divBy(Complex num) {
		Complex conjugate = new Complex(num.real, num.imaginary*(-1));
		Complex top = this.times(conjugate);
		Complex bottom = num.times(conjugate);
		return null;
	}
	
	/**
	 * Returns the complex number raised to an integer power
	 * 
	 * @param power - power to raise to
	 * @return the number raised to the given power
	 */
	public Complex raisedTo(int power) {
		Complex to_sender = this;
		for (int i=0;i<power;i++) {
			to_sender = to_sender.times(to_sender);
		}
		return to_sender;
	}
}
