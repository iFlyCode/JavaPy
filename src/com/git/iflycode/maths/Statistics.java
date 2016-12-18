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

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/** Functions with special reference to statistics are in this class. All elements of the class are static as this class
 * should not be 'constructed'.
 *
 * @author ifly6
 * @author ncolaprete */
public class Statistics {
	
	/** Returns the average of the given set of doubles.
	 * @author ifly6
	 * @param set of numbers
	 * @return the average of the set */
	public static double average(double... set) {
		return DoubleStream.of(set).average().getAsDouble();
	}
	
	/** Calculates sample standard deviation. Takes a <code>double[]</code> and processes it to spit out a
	 * <code>double</code>, which is the sample standard deviation of the set.
	 * @author ifly6
	 * @return the sample standard deviation
	 * @param sample, <code>double[]</code> which is the sample in question */
	public static double stdDevS(double[] sample) {
		return Math.sqrt(varianceS(sample));
	}
	
	/** Calculates population standard deviation. Takes a <code>double[]</code> and processes it to spit out a
	 * <code>double</code>, which is the population standard deviation of the set.
	 * @author ifly6
	 * @return the population standard deviation
	 * @param population is a <code>double[]</code> which is the dataset in question */
	public static double stdDevP(double[] population) {
		return Math.sqrt(varianceP(population));
	}
	
	/** Calculates sample variance. Takes a <code>double[]</code> and processes it to spit out a <code>double</code>,
	 * which is the variance of the set.
	 * @author ifly6
	 * @return variance of the sample
	 * @param sample is a <code>double[]</code> which is the sample */
	public static double varianceS(double[] sample) {
		return totalDeviation(sample) / (sample.length - 1);
	}
	
	/** Calculates population variance. Takes a <code>double[]</code> and processes it to spit out a <code>double</code>
	 * , which is the variance of the set.
	 * @author ifly6
	 * @return variance of the population
	 * @param population is a <code>double[]</code> which is the population in question */
	public static double varianceP(double[] population) {
		return totalDeviation(population) / population.length;
	}
	
	/** Calculates total deviation of a set. This is the basis for the variance, and thus, standard deviation methods.
	 * @author ifly6
	 * @param dataset upon which this calculation will be performed
	 * @return the total deviation of the set */
	private static double totalDeviation(double[] dataset) {
		double mean = DoubleStream.of(dataset).average().getAsDouble();
		return DoubleStream.of(dataset).map(item -> Math.pow(item - mean, 2)).sum();
	}
	
	/** Calculates Chi Squared. Takes <code>double[][]</code>, and returns the Chi squared of them.
	 * @author ncolaprete
	 * @param observed matrix of double values, in <code>double[][]</code>
	 * @return Chi squared of the input values */
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
				expected[i][j] = vTotals[i] * hTotals[j] / total;
			}
		}
		
		// Get Chi Values
		double[][] chis = new double[observed.length][observed[0].length];
		for (int i = 0; i < hTotals.length; i++) {
			for (int j = 0; j < vTotals.length; j++) {
				chis[i][j] = Math.pow(observed[i][j] - expected[i][j], 2) / expected[i][j];
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
	
	/** Takes <code>double[][]</code> and returns the calculated F-test values
	 * @author ncolaprete
	 * @param data matrix, <code>double[][]</code>, to do the test on
	 * @return F-test value of the given dataset */
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
		int N = IntStream.of(n).sum();
		
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
	
	/** Takes a two double arrays of observed and expected values and calculates the T-Test result between them. <b>Note
	 * that if one sample is larger than the other, it will be trimmed down to the smaller's size.</b>
	 * @author ncolaprete
	 * @param observed values in <code>double[]</code>
	 * @param expected values in <code>double[]</code>
	 * @return 2-Sample t-Test result */
	public static double twoTTest(double[] observed, double[] expected) {
		
		// Trimming the appropriate arrays if they are in need of it
		if (observed.length > expected.length) {
			double[] newArr = new double[expected.length];
			System.arraycopy(observed, 0, newArr, 0, expected.length);	// Use System.arrayCopy, which is faster.
			observed = newArr;
		} else if (observed.length < expected.length) {
			double[] newArr = new double[observed.length];
			System.arraycopy(expected, 0, newArr, 0, observed.length);
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
