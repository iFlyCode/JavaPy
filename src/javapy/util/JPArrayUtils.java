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

package javapy.util;

import java.util.Collection;

/**
 * This class contains static methods which are used to manipulate arrays in a more helpful manner than provided by the
 * Java library. Everything here is static, since there is no object to be created by <code>JPArrayUtils</code>.
 *
 * @author ifly6
 */
public class JPArrayUtils {

	/**
	 * This constructor is declared as private to prevent accidental creation of the class.
	 */
	private JPArrayUtils() {

	}

	/**
	 * Creates an <code>int[]</code> containing the range determined by the inputs.
	 *
	 * @param startInt is the starting integer
	 * @param stopInt is the ending integer
	 * @return an <code>int[]</code> containing the range determined by the inputs
	 */
	public static int[] range(int startInt, int stopInt) {

		if (startInt < stopInt) {

			int[] range = new int[stopInt - startInt];

			int init = startInt;
			for (int i = 0; i < range.length; i++) {
				range[i] = init;
				init++;
			}
			return range;

		} else {
			throw new ArrayIndexOutOfBoundsException("Range from " + startInt + " to " + stopInt + " is invalid.");
		}
	}

	/**
	 * Creates an <code>int[]</code> containing the range 0 to the stopping integer.
	 *
	 * @param stopInt the ending integer
	 * @return an <code>int[]</code> containing a range from 0 to the stopping integer
	 */
	public static int[] range(int stopInt) {
		return range(0, stopInt);
	}

	/**
	 * Converts a collection into an array.
	 *
	 * @param collection to be converted into an array
	 * @author ifly6
	 * @return the collection as an array
	 */
	public static Object[] toArray(Collection<?> collection) {
		return collection.toArray(new String[collection.size()]);
	}

	/**
	 * Converts an <code>Integer[]</code> into an <code>int[]</code>.
	 *
	 * @param objectArray the non-primitive array of Integer objects
	 * @author ifly6
	 * @return an <code>int[]</code> from the <code>Integer[]</code>
	 */
	public static int[] toPrimitiveArray(Integer[] objectArray) {
		int[] primitiveArray = new int[objectArray.length];

		for (int i = 0; i < objectArray.length; i++) {
			primitiveArray[i] = objectArray[i];
		}

		return primitiveArray;
	}

	/**
	 * Converts an <code>Double[]</code> into an <code>double[]</code>.
	 *
	 * @param objectArray the non-primitive array of Integer objects
	 * @author ifly6
	 * @return an <code>int[]</code> from the <code>Integer[]</code>
	 */
	public static double[] toPrimitiveArray(Double[] objectArray) {
		double[] primitiveArray = new double[objectArray.length];

		for (int i = 0; i < objectArray.length; i++) {
			primitiveArray[i] = objectArray[i];
		}

		return primitiveArray;
	}

	/**
	 * Converts a collection of <code>String</code> into a single <code>String</code> with character separator.
	 *
	 * @param collection to be converted
	 * @param sepChar to separate each <code>String</code>
	 * @author ifly6
	 * @return
	 */
	public static String toString(Collection<String> collection, char sepChar) {
		StringBuilder sBuilder = new StringBuilder();
		for (String element : collection) {
			sBuilder.append(element + sepChar);
		}
		return sBuilder.toString();
	}

	/**
	 * Converts a collection of <code>String</code> into a single <code>String</code> defaulting to <code>','</code> as
	 * the separator.
	 *
	 * @param collection to be converted
	 * @author ifly6
	 * @return a String with commas between each element
	 */
	public static String toString(Collection<String> collection) {
		return toString(collection, ',');
	}

	/**
	 * Converts a <code>String[]</code> into a single <code>String</code> with character separator.
	 *
	 * @param array to be converted
	 * @param sepChar to be placed between each element
	 * @author ifly6
	 * @return a String with <code>sepChar</code> between each element
	 */
	public static String toString(String[] array, char sepChar) {
		StringBuilder sBuilder = new StringBuilder();
		for (String element : array) {
			sBuilder.append(element + sepChar);
		}
		return sBuilder.toString();
	}

	/**
	 * Converts a <code>String[]</code> into a single <code>String</code> defaulting to <code>','</code> as the
	 * separator.
	 *
	 * @param array to be converted
	 * @author ifly6
	 * @return a String with commas between each element
	 */
	public static String toString(String[] array) {
		return toString(array, ',');
	}

	/**
	 * This filters out all new lines from an array.
	 *
	 * @param array which contains unwanted new lines
	 * @return the array without unwanted new lines
	 * @author ifly6
	 */
	public static String[] filterNewLines(String[] array) {

		// Find the number of new lines in the original array
		int newLines = 0;
		for (String element : array) {
			if (element.equals("\n")) {
				newLines++;
			}
		}

		// Subtract that number and copy the array over, ignoring new lines
		String[] output = new String[array.length - newLines];
		int outputIndex = 0;

		for (int arrayIndex = 0; arrayIndex < output.length; arrayIndex++) {
			if (!array[arrayIndex].equals("\n")) {
				output[outputIndex] = array[arrayIndex];
				outputIndex++;
			}
		}

		return output;
	}
}
