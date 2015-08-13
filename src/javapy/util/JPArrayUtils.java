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
}
