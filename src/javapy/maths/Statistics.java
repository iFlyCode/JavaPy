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
	
	/**
	 * Takes a matrix of doubles and returns the calculated F-test values
	 * 
	 * @author ncolaprete
	 * @param data to do the test on
	 * @return F value
	 */
	public double ANOVA(double[][] data) {
		
		// Calculate Averages
		
		double[] mean = new double[data.length];
		for (int row=0;row<data.length;row++) {
			double cMean = 0;
			for (double i : data[row]) {
				cMean += i;
			}
			mean[row] = cMean/data[row].length;
		}
		
		// Calculate Variance
		
		double[] variance = new double[data.length];
		for (int row=0;row<data.length;row++) {
			variance[row] = Math.pow(standardDeviation(data[row]), 2);
		}
		
		// Caluclate number of items in each row
		
		int[] n = new int[data.length];
		for (int row=0;row<data.length;row++) {
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
		for (int row=0;row<data.length;row++) {
			SSB[row] = Math.pow(mean[row] - grandMean, 2)*n[row];
		}
		
		// Calculate Sum of Squares Within

		double[] SSW = new double[data.length];
		for (int row=0;row<data.length;row++) {
			SSW[row] = (n[row] - 1)*variance[row];
		}
		
		// Calculate Mean Squares Between
		
		double MSB = 0;
		for (int row=0;row<data.length;row++) {
			MSB += SSB[row];
		}
		MSB /= K-1;
		
		// Calculate Mean Squares Within
		
		double MSW = 0;
		for (int row=0;row<data.length;row++) {
			MSW += SSW[row];
		}
		MSW /= N-K;
		
		// Return the F-test result
		
		return MSB/MSW;
		
	}
	
}
