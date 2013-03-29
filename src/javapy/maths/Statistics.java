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
}
