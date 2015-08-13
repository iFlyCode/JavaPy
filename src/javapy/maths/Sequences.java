package javapy.maths;

/**
 * Methods with relation to sequences should go here.
 */
public class Sequences {
	// TODO Regression

	/**
	 * Calculates the total of a converging geometric sequence.
	 *
	 * @author ifly6
	 * @param r the common ratio
	 * @param initial value at f(0)
	 * @return the value to which the equation converges.
	 */
	public static double converingSequence(double r, double initial) {
		double fraction = 1 / (1 - r);
		double returned = initial * fraction;
		return returned;
	}

	/**
	 * Calculates the <i>n</i>th number in the Fibonacci sequence.
	 *
	 * @author ncolaprete
	 *
	 * @param n <i>th</i> number of the sequence
	 * @return n'th number in the sequence
	 */
	public static int fibonacci(int n) {
		if (n == 1) {
			return 1;
		} else if (n <= 0) {
			return 0;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	/**
	 * Takes an imaginary number, and returns whether or not it is bounded under 2 after a certain number of iterations,
	 * by the equation Z = Z^2 + C.
	 *
	 * <p>
	 * Can be used to calculate Julia sets as well.
	 * </p>
	 *
	 * @author ncolaprete
	 * @param real part of the number to check if bounded.
	 * @param imag part of the number to check if bounded.
	 * @param cReal part of the julia set to check in. Re-pass the real part of the first complex number to calculate
	 *            the mandelbrot set.
	 * @param cImag part of the julia set to check in. Re-pass the imaginary part of the first complex number to
	 *            calculate the mandelbrot set.
	 * @param iters number of iterations to check if the number is bounded
	 *
	 * @return number of iterations before the number became unbounded, - or returns the number of iterations given if
	 *         is bounded
	 */
	public static int mandelbrot(double real, double imag, double cReal, double cImag, int iters) {
		int to_sender = 0;
		for (int i = 0; i < iters; i++) {
			double backReal = real;
			double backImag = imag;
			real = ((backReal * backReal) - (backImag * backImag)) + cReal;
			imag = (2 * backImag * backReal) + cImag;
			if ((real * real) + (imag * imag) > 4) {
				break;
			}
			to_sender = i + 1;
		}
		return to_sender;
	}

}
