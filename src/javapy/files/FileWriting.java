package javapy.files;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The place for methods which involve a file, and involve the changing of the
 * contents of that file.
 */
public class FileWriting {

	/**
	 * Method for reading file, integrating file, replacing instances of a
	 * certain String and replacing it with another. Should not be used on
	 * massive files.
	 * 
	 * @param file
	 *            - file in question
	 * @param findString
	 *            - the String we're looking for
	 * @param replaceString
	 *            - the String you want to replace all instances of the other
	 *            with.
	 * @throws IOException
	 */
	public void replaceInstance(String file, String findString,
			String replaceString) throws IOException {
		ArrayList<String> contents = new ArrayList<String>(0);

		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		while (scan.hasNextLine()) {
			contents.add(scan.nextLine());
		}
		String newContents = contents.toString();
		newContents.replace(findString, replaceString);

		FileWriter fstream = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(newContents);
		out.close();
	}

	/**
	 * Method to write a file with the contents of a provided string. Does not
	 * provide for appending.
	 * 
	 * @param directory
	 *            - directory to write to
	 * @param contents
	 *            - contents of file that you're going to write to File
	 *            directory
	 * @throws IOException
	 *             Catch this, and do what you want.
	 */
	public void write(String directory, String contents) throws IOException {
		FileWriter fstream = new FileWriter(directory);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(contents);
		out.close();
	}

	/**
	 * Method to write a file with the contents of a provided string. Provides
	 * the necessary boolean for appending.
	 * 
	 * @param directory
	 *            - directory to write to
	 * @param contents
	 *            - contents of file that you're going to write to File
	 *            directory
	 * @param append
	 *            - boolean on whether you're going to append or not.
	 * @throws IOException
	 *             Catch this, and do what you want.
	 */
	public void write(String directory, String contents, boolean append)
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
	 * Method for convenience for writing an array of Strings to a file by line.
	 * It appends, instead of writes over.
	 * 
	 * @author ifly6
	 * @param file
	 *            - The file to write to.
	 * @param input
	 *            - The String Array given to write to lines by index.
	 * @throws IOException
	 */
	public void writeArray(String file, String[] input) throws IOException {
		FileWriter fstream = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(fstream);
		for (String element : input) {
			out.append(element);
			out.newLine();
		}
		out.close();
	}

	/**
	 * Read a file, find the line in question, replace that line, put all that
	 * into a string, write the string. Gentlemen, we're done here.
	 * 
	 * @param file
	 *            - The file in question
	 * @param toWrite
	 *            - What you're going to write to that line
	 * @param line
	 *            - The line in question
	 * @throws IOException
	 *             Catch this exception. Its caused by FileWriter
	 */
	public void writeLine(String file, String toWrite, int line)
			throws IOException {

		ArrayList<String> contents = new ArrayList<String>(0);

		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);
		contents.add(scan.nextLine());
		contents.set(line, toWrite);
		String rewrite = contents.toString();
		FileWriter fstream = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(rewrite);
		out.close();
	}

}
