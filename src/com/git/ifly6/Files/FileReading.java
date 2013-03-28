package com.git.ifly6.Files;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
		ArrayList<String> commText = new ArrayList<String>(1);
		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		commText.add(scan.nextLine());
		return commText.get(line);
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
		ArrayList<String> contents = new ArrayList<String>(1);
		ArrayList<Integer> search = new ArrayList<Integer>(1);
		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		contents.add(scan.nextLine());
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
}
