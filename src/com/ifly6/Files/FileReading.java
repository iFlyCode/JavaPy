package com.ifly6.Files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReading {

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
		int[] locations = new int[search.size()];
		for (int x = 0; x < strings.length; x++) {
			locations[x] = Integer.getInteger(strings[x]);
		}
		return locations;
	}

	/**
	 * Reads the file, puts it into an ArrayList, then returns the ArrayList
	 * 
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
	 * Search for the line of text in the file provided
	 * 
	 * @author ncolaprete
	 * 
	 * @param fileDir
	 *            - Directory of the file to search in
	 * @param text
	 *            - Text to search for
	 * @return array of all the lines the text was found on
	 */
	public static int[] findInFile(String fileDir, String text) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		try {
			Scanner scan = new Scanner(new FileReader(fileDir));
			int l = 0;
			String curLine = "";
			while (scan.hasNextLine()) {
				l++;
				int len = text.length();
				curLine = scan.nextLine();
				for (int i=0;i<curLine.length() - len + 1;i++) {
					String sub = curLine.substring(i,i+len);
					if (sub.equals(text)) {
						indexes.add(l);
						break;
					}
				}
			}
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return com.ifly6.General.array.ArrayListToArray(indexes);
	}
}
