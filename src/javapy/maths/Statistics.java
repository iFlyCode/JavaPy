package javapy.maths;

/**
 * Functions with special reference to statistics are in this class. All elements of the class are static as this class
 * should not be 'constructed'.
 *
 * @author ifly6
 * @author ncolaprete
 */
public class Statistics {

	/**
	 * Method for the calculation of sample standard deviation. Takes an array of doubles and processes it to spit out a
	 * double, which is the standard deviation of the set.
	 *
	 * @author ifly6
	 * @return standard deviation of the data set given.
	 * @param population is a <code>double[]</code> which is the sample in question, that we are to calculate the
	 *            standard deviation for.
	 */
	public static double stdDevS(double[] sample) {
		return Math.sqrt(varianceS(sample));		// Return square root of variance
	}

	/**
	 * Method for the calculation of population standard deviation. Takes an array of doubles and processes it to spit
	 * out a double, which is the standard deviation of the set.
	 *
	 * @author ifly6
	 * @return standard deviation of the data set given.
	 * @param population is a <code>double[]</code> which is the sample in question, that we are to calculate the
	 *            standard deviation for.
	 */
	public static double stdDevP(double[] population) {
		return Math.sqrt(varianceP(population));
	}

	/**
	 * Method for the calculation of sample variance. Takes a <code>double[]</code> and processes it to spit out a
	 * <code>double</code>, which is the variance of the set.
	 *
	 * @author ifly6
	 * @return variance of the data set given.
	 * @param sample is a <code>double[]</code> which is the sample in question, that we are to calculate the standard
	 *            deviation for.
	 */
	public static double varianceS(double[] sample) {
		return totalDeviation(sample) / (sample.length + 1);
	}

	/**
	 * Method for the calculation of population variance. Takes a <code>double[]</code> and processes it to spit out a
	 * <code>double</code>, which is the variance of the set.
	 *
	 * @author ifly6
	 * @return variance of the data set given.
	 * @param sample is a <code>double[]</code> which is the population in question, that we are to calculate the
	 *            standard deviation for.
	 */
	public static double varianceP(double[] population) {
		return totalDeviation(population) / population.length;
	}

	/**
	 * Determines the total deviation of a set. This is the basis for the variance, and thus, standard deviation
	 * methods.
	 *
	 * @param dataset the dataset upon which this calculation will be performed
	 * @return the total deviation of the set
	 */
	private static double totalDeviation(double[] dataset) {
		// Get Mean of the population
		double mean = 0;
		for (double x : dataset) {
			mean = mean + x;
		}
		mean = mean / dataset.length;

		// Get all differences between the Means and square them
		double[] sqRepo = new double[dataset.length];
		for (int i = 0; i < sqRepo.length; i++) {
			sqRepo[i] = Math.pow(sqRepo[i] - mean, 2);
		}

		// Take the square root of the average of those differences
		double deviation = 0;
		for (double x : sqRepo) {
			deviation = deviation + x;
		}

		return deviation;
	}

	/**
	 * Calculates Chi Squared. Takes a multidimensional array of doubles, and returns the Chi squared of them.
	 *
	 * @author ncolaprete
	 * @param observed - Matrix of double values
	 * @return Chi squared of the input values
	 */
	public static double chiSquared(double[][] observed) {
		double[] hTotals = new double[observed.length];
		double[] vTotals = new double[observed[0].length];
		double total = 0;

		// Get Totals
		for (int i = 0; i < hTotals.length; i++) {
			for (int j = 0; j < vTotals.length; j++) {
				hTotals[i] += observed[i][j];
				vTotals[j] += observed[j][i];
				total += observed[i][j];
			}
		}

		// Get Expected Values
		double[][] expected = new double[observed.length][observed[0].length];
		for (int i = 0; i < hTotals.length; i++) {
			for (int j = 0; j < vTotals.length; j++) {
				expected[i][j] = (vTotals[i] * hTotals[j]) / total;
			}
		}

		// Get Chi Values
		double[][] chis = new double[observed.length][observed[0].length];
		for (int i = 0; i < hTotals.length; i++) {
			for (int j = 0; j < vTotals.length; j++) {
				chis[i][j] = (Math.pow(observed[i][j] - expected[i][j], 2)) / expected[i][j];
			}
		}

		// Get Chi Total
		double chi = 0;
		for (int i = 0; i < hTotals.length; i++) {
			for (int j = 0; j < vTotals.length; j++) {
				chi += chis[i][j];
			}
		}

		return chi;
	}

	/**
	 * Takes a matrix of doubles and returns the calculated F-test values
	 *
	 * @author ncolaprete
	 * @param data matrix to do the test on
	 * @return F-test value of the given dataset
	 */
	public static double ANOVA(double[][] data) {

		// Calculate Averages

		double[] mean = new double[data.length];
		for (int row = 0; row < data.length; row++) {
			double cMean = 0;
			for (double i : data[row]) {
				cMean += i;
			}
			mean[row] = cMean / data[row].length;
		}

		// Calculate Variance

		double[] variance = new double[data.length];
		for (int row = 0; row < data.length; row++) {
			variance[row] = Math.pow(stdDevS(data[row]), 2);
		}

		// Caluclate number of items in each row

		int[] n = new int[data.length];
		for (int row = 0; row < data.length; row++) {
			n[row] = data[row].length;
		}

		// Calculate total number of items

		int N = 0;
		for (int i : n) {
			N += i;
		}

		// Calculate number of rows

		int K = data.length;

		// Calculate Grand Mean

		double grandMean = 0;
		for (double i : mean) {
			grandMean += i;
		}
		grandMean /= mean.length;

		// Calculate Sum of Squares Between

		double[] SSB = new double[data.length];
		for (int row = 0; row < data.length; row++) {
			SSB[row] = Math.pow(mean[row] - grandMean, 2) * n[row];
		}

		// Calculate Sum of Squares Within

		double[] SSW = new double[data.length];
		for (int row = 0; row < data.length; row++) {
			SSW[row] = (n[row] - 1) * variance[row];
		}

		// Calculate Mean Squares Between

		double MSB = 0;
		for (int row = 0; row < data.length; row++) {
			MSB += SSB[row];
		}
		MSB /= K - 1;

		// Calculate Mean Squares Within

		double MSW = 0;
		for (int row = 0; row < data.length; row++) {
			MSW += SSW[row];
		}
		MSW /= N - K;

		// Return the F-test result

		return MSB / MSW;

	}

	/**
	 * Takes a two double arrays of observed and expected values and calculates the T-Test result between them.
	 *
	 * <p>
	 * <b>Note that if one sample is larger than the other, it will be trimmed down to the smaller's size.</b>
	 * </p>
	 *
	 * @author ncolaprete
	 * @param observed values in an array
	 * @param expected values in an array
	 * @return 2-Sample t-Test result
	 */
	public static double twoTTest(double[] observed, double[] expected) {

		// Trimming the appropriate arrays if they are in need of it
		if (observed.length > expected.length) {
			double[] newArr = new double[expected.length];
			for (int i = 0; i < expected.length; i++) {
				newArr[i] = observed[i];
			}
			observed = newArr;
		} else if (observed.length < expected.length) {
			double[] newArr = new double[observed.length];
			for (int i = 0; i < observed.length; i++) {
				newArr[i] = expected[i];
			}
			expected = newArr;
		}

		// Calculating the T-Test value
		double[] step_vals = new double[observed.length];
		for (int i = 0; i < observed.length; i++) {
			step_vals[i] = Math.pow(expected[i] - observed[i], 2) / expected[i];
		}
		double to_sender = 0;
		for (double step_val : step_vals) {
			to_sender += step_val;
		}
		return to_sender;
	}

}
