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

package com.git.iflycode.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** This class contains static methods which are used to manipulate arrays in a more helpful manner than provided by the
 * Java library. Everything here is static, since there is no object to be created by <code>JPArrayUtils</code>.
 *
 * @author ifly6 */
public class JPArrayUtils {
	
	/** This constructor is declared as private to prevent accidental creation of the class. */
	private JPArrayUtils() {
		
	}
	
	/** Creates an <code>int[]</code> containing the range determined by the inputs.
	 * @param startInt is the starting integer
	 * @param stopInt is the ending integer
	 * @return an <code>int[]</code> containing the range determined by the inputs */
	public static int[] range(int startInt, int stopInt) {
		return IntStream.range(startInt, stopInt).toArray();
	}
	
	/** Creates an <code>int[]</code> containing the range 0 to the stopping integer.
	 *
	 * @param stopInt the ending integer
	 * @return an <code>int[]</code> containing a range from 0 to the stopping integer */
	public static int[] range(int stopInt) {
		return range(0, stopInt);
	}
	
	/** Converts a collection into an array.
	 *
	 * @param collection to be converted into an array
	 * @author ifly6
	 * @return the collection as an array */
	public static Object[] toArray(Collection<?> collection) {
		return collection.toArray(new String[collection.size()]);
	}
	
	/** Converts an <code>Integer[]</code> into an <code>int[]</code>.
	 * @author ifly6
	 * @param objectArray as <code>Integer[]</code>
	 * @return an <code>int[]</code> from the <code>Integer[]</code> */
	public static int[] toPrimitiveArray(Integer[] objectArray) {
		return Stream.of(objectArray).mapToInt(Integer::intValue).toArray();
	}
	
	/** Converts an <code>Double[]</code> into an <code>double[]</code>.
	 * @param objectArray the non-primitive array of Integer objects
	 * @author ifly6
	 * @return an <code>int[]</code> from the <code>Integer[]</code> */
	public static double[] toPrimitiveArray(Double[] objectArray) {
		return Stream.of(objectArray).mapToDouble(Double::doubleValue).toArray();
	}
	
	/** Converts a collection of <code>String</code> into a single <code>String</code> with character separator.
	 *
	 * @param collection to be converted
	 * @param sepChar to separate each <code>String</code>
	 * @author ifly6
	 * @return */
	public static String toString(Collection<String> collection, char sepChar) {
		StringBuilder sBuilder = new StringBuilder();
		collection.stream().forEach(s -> sBuilder.append(s + sepChar));
		return sBuilder.toString();
	}
	
	/** Converts a collection of <code>String</code> into a single <code>String</code> defaulting to <code>','</code> as
	 * the separator.
	 * @param collection to be converted
	 * @author ifly6
	 * @return a String with commas between each element */
	public static String toString(Collection<String> collection) {
		return toString(collection, ',');
	}
	
	/** Converts a <code>String[]</code> into a single <code>String</code> with character separator.
	 * @param array to be converted
	 * @param sepChar to be placed between each element
	 * @author ifly6
	 * @return a <code>String</code> with <code>sepChar</code> between each element */
	public static String toString(String[] array, char sepChar) {
		StringBuilder sBuilder = new StringBuilder();
		Arrays.stream(array).forEach(s -> sBuilder.append(s + sepChar));
		return sBuilder.toString();
	}
	
	/** Converts a <code>String[]</code> into a single <code>String</code> defaulting to <code>','</code> as the
	 * separator.
	 * @param array to be converted
	 * @author ifly6
	 * @return a String with commas between each element */
	public static String toString(String[] array) {
		return toString(array, ',');
	}
	
	/** Filters out all empty lines from an array.
	 * @param array which contains unwanted empty lines
	 * @return the array without unwanted empty lines
	 * @author ifly6 */
	public static String[] filterEmptyLines(String[] array) {
		return Arrays.stream(array).filter(s -> s.trim().length() != 0).toArray(String[]::new);
	}
}
