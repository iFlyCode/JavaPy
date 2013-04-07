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
	 * <ul><li><b><i>
	 * toArray
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public double[] toArray()
	 * </p><p>
	 * Returns a double array containing the real
	 * part under index 0 and the imaginary part
	 * under index 1.</p>
	 * 
	 * @return An array instance of the number
	 */
	public double[] toArray() {
		return new double[] {this.real, this.imaginary};
	}
	
	/**
	 * <ul><li><b><i>
	 * plus
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public Complex plus(Complex num)
	 * </p><p>
	 * Adds this complex number to another one.</p>
	 * @param num - Complex number to add to.
	 * @return The sum of the two numbers.
	 */
	public Complex plus(Complex num) {
		double realfinal = this.real + num.real;
		double imagfinal = this.imaginary + num.imaginary;
		return new Complex(realfinal, imagfinal);
	}

	/**
	 * <ul><li><b><i>
	 * minus
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public Complex minus(Complex num)
	 * </p><p>
	 * Subtracts another complex number from this one.</p>
	 * @param num - Complex number to subtract.
	 * @return The difference of the two numbers.
	 */
	public Complex minus(Complex num) {
		double realfinal = this.real - num.real;
		double imagfinal = this.imaginary - num.imaginary;
		return new Complex(realfinal, imagfinal);
	}
	

	/**
	 * <ul><li><b><i>
	 * times
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public Complex times(Complex num)
	 * </p><p>
	 * Multiplies this complex number with another one.</p>
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
	 * <p style="font-size:16px;color:red"><b>
	 * NON-FUNCTIONING
	 * </b></p>
	 * <ul><li><b><i>
	 * divBy
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public Complex divBy(Complex num)
	 * </p><p>
	 * Returns the quotient of this and another complex
	 * number.</p>
	 * @param num - Number to divide by.
	 * @return null
	 */
	public Complex divBy(Complex num) {
		/*
		Complex conjugate = new Complex(num.real, num.imaginary*(-1));
		Complex top = this.times(conjugate);
		Complex bottom = num.times(conjugate);
		*/
		return null;
	}
	
	/**
	 * <ul><li><b><i>
	 * raisedTo
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public Complex raisedTo(int power)
	 * </p><p>
	 * Returns this complex number raised to an integer power.</p>
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
