package javapy.maths;

/**
 * Methods with relation to sequences should go here.
 */
public class Sequences {
	// TODO Regression

	/**
	 * <strong><em>
	 * <Ul><li>convergingSequence</ul></li>
	 * </em></strong>
	 * <p style="font-family:Courier">public double convergingSequence(double r, double starting)</p>
	 * <p>Calculates the total of a converging sequence.</p>
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
	 * <strong><em>
	 * <Ul><li>fibonacci</ul></li>
	 * </em></strong>
	 * <p style="font-family:Courier">public int fibonacci(int n)</p>
	 * <p>Returns the n'th number in the Fibonacci sequence.</p>
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
	 * <strong><em>
	 * <Ul><li>mandelbrot</ul></li>
	 * </em></strong>
	 * <p style="font-family:Courier">public int mandelbrot(double real, double imag, double creal, double cimag, int iters)</p>
	 * <p>Takes an imaginary number, and returns whether or not it is bounded under
	 * 2 after a certain number of iterations, by the equation Z = Z^2 + C.</p>
	 * <p>Can be used to calculate Julia sets as well.
	 * </p>
	 * 
	 * @author ncolaprete
	 * @param real
	 *            - Real part of the number to check if bounded.
	 * @param imag
	 *            - Imaginary part of the number to check if bounded.
	 * @param cReal
	 *            - Real part of the julia set to check in. 
	 *            	Re-pass the real part of the first complex 
	 *            	number to calculate the mandelbrot set.
	 * @param cImag
	 *            - Imaginary part of the julia set to check in. 
	 *            	Re-pass the imaginary part of the first complex 
	 *            	number to calculate the mandelbrot set.
	 * @param iters
	 *            - Number of iterations to check if the number is bounded
	 * 
	 * @return number of iterations before the number became unbounded, - or
	 *         returns the number of iterations given if is bounded
	 */
	public int mandelbrot(double real, double imag, double cReal, double cImag,
			int iters) {
		int to_sender = 0;
		for (int i = 0; i < iters; i++) {
			double backReal = real;
			double backImag = imag;
			real = ((backReal * backReal) - (backImag * backImag)) + cReal;
			imag = (2 * backImag * backReal) + cImag;
			if ((real * real) + (imag * imag) > 4)
				break;
			to_sender = i + 1;
		}
		return to_sender;
	}

}
