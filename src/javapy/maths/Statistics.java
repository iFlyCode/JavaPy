package javapy.maths;

import java.util.ArrayList;

/**
 * Methods which perform statistical analysis should go here.
 */
public class Statistics {

	/**
	 * Method for the calculation of standard deviation. Takes an array of
	 * doubles and processes it to spit out a double, which is the standard
	 * deviation of the data set.
	 * 
	 * @author ifly6
	 * @return Standard deviation of the data set given.
	 * @param population
	 *            - array of doubles which is the population in question, that
	 *            we are to calculate the standard deviation for.
	 */
	public double standardDeviation(double[] population) {

		// Get Mean of the population
		double mean = 0;
		for (double x : population) {
			mean = mean + x;
		}
		mean = mean / population.length;

		// Get difference between the Means
		ArrayList<Double> sqRepo = new ArrayList<Double>(0);
		for (double x : population) {
			sqRepo.add(x - mean);
		}

		// Square all those differences
		for (int x = 0; x < sqRepo.size(); x++) {
			sqRepo.set(x, sqRepo.get(x) * sqRepo.get(x));
		}

		// Take the square root of the average of those differences
		mean = 0;
		for (double x : sqRepo) {
			mean = mean + x;
		}
		mean = mean / sqRepo.size();
		double deviation = Math.sqrt(mean);

		return deviation;
	}

	/**
	 * Calculates Chi Squared. Takes a multi-dimensional array of doubles, and
	 * returns the Chi squared of them.
	 * 
	 * @author ncolaprete
	 * 
	 * @param Matrix
	 *            of double values
	 * 
	 * @return Chi squared of the inputed values
	 */
	public double chiSquared(double[][] observed) {
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
				chis[i][j] = (Math.pow(observed[i][j] - expected[i][j], 2))
						/ expected[i][j];
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
}
