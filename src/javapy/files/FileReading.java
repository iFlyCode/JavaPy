package javapy.files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for methods which relate to reading a file and providing an output, or
 * information about what was read. There should be no methods which actually
 * CHANGE the file inside this class.
 */
public class FileReading {

	/**
	 * Reads the file, puts it into an Array, by the line number = index.
	 * 
	 * @author ifly6
	 * @param file
	 * @return ArrayList with the file inside, Line by Line
	 * @throws FileNotFoundException
	 */
	public String[] readFile(String file) throws FileNotFoundException {
		ArrayList<String> contents = new ArrayList<String>(0);

		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		while (scan.hasNextLine()) {
			contents.add(scan.nextLine());
		}
		return (String[]) contents.toArray();
	}

	/**
	 * Method to look inside a file for a certain line, and return the contents
	 * of that line.
	 * 
	 * @param file
	 *            - The file in question
	 * @param line
	 *            - The line in question in the File
	 * @return String with the contents of the line in question.
	 * @throws FileNotFoundException
	 * @author ifly6
	 */
	public String readLine(String file, int line) throws FileNotFoundException {
		ArrayList<String> contents = new ArrayList<String>(0);

		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		while (scan.hasNextLine()) {
			contents.add(scan.nextLine());
		}
		return contents.get(line);
	}

	/**
	 * A complicated method to search through a file for instances of a certain
	 * String inside that file.
	 * 
	 * @author ifly6
	 * @param file
	 *            - The file we're searching through.
	 * @param keyword
	 *            - What we're looking for.
	 * @return An array of integers with the locations of the string you're
	 *         looking for appears (by line).
	 * @throws FileNotFoundException
	 */
	public int[] searchFile(String file, String keyword)
			throws FileNotFoundException {
		ArrayList<String> contents = new ArrayList<String>(0);
		ArrayList<Integer> search = new ArrayList<Integer>(0);
		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		while (scan.hasNextLine()) {
			contents.add(scan.nextLine());
		}
		for (int x = 0; x < contents.size(); x++) {
			String evaluate = contents.get(x);
			if (evaluate.contains(keyword)) {
				search.add(x);
			}
		}
		String[] strings = (String[]) search.toArray();

		// Convert ArrayList to int[]
		int[] locations = new int[search.size()];
		for (int x = 0; x < strings.length; x++) {
			locations[x] = Integer.getInteger(strings[x]);
		}

		return locations;
	}
}