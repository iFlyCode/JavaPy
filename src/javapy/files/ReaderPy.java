package javapy.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for methods which relate to reading a file and providing an output, or information about what was read. There
 * should be no methods which actually CHANGE the file inside this class.
 */
public class ReaderPy {

	/**
	 * <ul>
	 * <li><b><i> readFile </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public String[] readFile(String file) throws FileNotFoundException
	 * </p>
	 * <p>
	 * Reads the file, puts it into an Array, by the line number = index.
	 * </p>
	 * 
	 * @author ifly6
	 * @param file
	 * @return ArrayList with the file inside, Line by Line
	 * @throws FileNotFoundException
	 */
	public String[] readFile(File file) throws FileNotFoundException {
		ArrayList<String> contents = new ArrayList<String>(0);

		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		while (scan.hasNextLine()) {
			contents.add(scan.nextLine());
		}
		scan.close();
		return (String[]) contents.toArray();
	}

	/**
	 * <ul>
	 * <li><b><i> readLine </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public String readLine(String file, int line)
	 * </p>
	 * <p>
	 * Method to look inside a file for a certain line, and return the contents of that line.
	 * </p>
	 * 
	 * @param file
	 *            - The file in question
	 * @param line
	 *            - The line in question in the File
	 * @return String with the contents of the line in question, but a blank string if the line is longer than the file
	 * @throws FileNotFoundException
	 * @author ncolaprete
	 */
	public String readLine(File file, int line) throws FileNotFoundException {

		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		int i = 0;
		while (scan.hasNextLine()) {
			/* This is kind of inefficient. It parses the entire file before spitting out the line you want. We can
			 * totally do better than this. I think we should try something different. */
			i++;
			if (line == i) {
				scan.close();
				return scan.nextLine();
			}
		}
		scan.close();
		return "";
	}

	/**
	 * <ul>
	 * <li><b><i> searchFile </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public int[] searchFile(String file, String keyword)
	 * </p>
	 * <p>
	 * A complicated method to search through a file for instances of a certain String inside that file.
	 * </p>
	 * 
	 * @author ifly6
	 * @param file
	 *            - The file we're searching through.
	 * @param keyword
	 *            - What we're looking for.
	 * @return An array of integers with the locations of the string you're looking for appears (by line).
	 * @throws FileNotFoundException
	 */
	public int[] searchFile(String file, String keyword) throws FileNotFoundException {
		ArrayList<String> contents = new ArrayList<String>(0);
		ArrayList<Integer> search = new ArrayList<Integer>(0);
		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		while (scan.hasNextLine()) {
			contents.add(scan.nextLine());
		}
		scan.close();
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
