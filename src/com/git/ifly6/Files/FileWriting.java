package com.git.ifly6.Files;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWriting {

	/**
	 * Method to write a file with the contents of a provided string. Provides
	 * the necessary boolean for appending.
	 * 
	 * @param directory
	 *            directory to write to
	 * @param contents
	 *            contents of file that you're going to write to File directory
	 * @param append
	 *            boolean on whether you're going to append or not.
	 * @throws IOException
	 *             Catch this, and do what you want.
	 */
	public static void write(String directory, String contents, boolean append)
			throws IOException {
		if (append == true) {
			FileWriter fstream = new FileWriter(directory, append);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(contents);
			out.close();
		}
		if (append == false) {
			write(directory, contents);
		}
	}

	/**
	 * Method to write a file with the contents of a provided string. Does not
	 * provide for appending.
	 * 
	 * @param directory
	 *            directory to write to
	 * @param contents
	 *            contents of file that you're going to write to File directory
	 * @throws IOException
	 *             Catch this, and do what you want.
	 */
	public static void write(String directory, String contents)
			throws IOException {
		FileWriter fstream = new FileWriter(directory);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(contents);
		out.close();
	}

	/**
	 * Read a file, find the line in question, replace that line, put all that
	 * into a string, write the string. Gentlemen, we're done here.
	 * 
	 * @param file
	 *            The file in question
	 * @param toWrite
	 *            What you're going to write to that line
	 * @param line
	 *            The line in question
	 * @throws IOException
	 *             Catch this exception. Its caused by FileWriter
	 */
	public static void writeLine(String file, String toWrite, int line)
			throws IOException {

		ArrayList<String> commText = new ArrayList<String>(1);
		String rewrite = "";

		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		commText.add(scan.nextLine());
		commText.set(line, toWrite);
		rewrite = commText.toString();
		FileWriter fstream = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(rewrite);
		out.close();
	}
}
