package com.ifly6.Files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import com.ifly6.General.*;

public class FileWriting {

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
	
	/**
	 * Append the line to the end of the file specified. Simple, easy, quick.
	 * If the file doesn't exist, then it returns false.
	 * 
	 * @author ncolaprete
	 * 
	 * @param fileDir
	 *            - The directory of the file
	 * @param toAppend
	 *            - Text to append to the file
	 * @return False if the file doesn't exist, or an error was encountered
	 */
	public boolean appendToFile(String fileDir, String toAppend) {
		try {
			File file = new File(fileDir);
			if (!file.exists())
				return false;
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileDir, true)));
			out.println(toAppend);
			out.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Find every instance of the given text and replace it with something else.
	 * 
	 * @author ncolaprete
	 * 
	 * @param fileDir
	 *            - Directory of the file to search
	 * @param find
	 *            - Text to search for
	 * @param replace
	 *            - Text to replace with
	 * @return array of all the lines the text was found on
	 */
	public static int[] findAndReplace(String fileDir, String find, String replace) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		ArrayList<String> lines = new ArrayList<String>();
		try {
			Scanner scan = new Scanner(new FileReader(fileDir));
			while (scan.hasNextLine()) {
				lines.add(scan.nextLine());
			}
			scan.close();
			int l = -1;
			for (String line : lines) {
				l++;
				int len = find.length();
				for (int i=0;i<line.length() - len + 1;i++) {
					String sub = line.substring(i,i+len);
					if (sub.equalsIgnoreCase(find)) {
						indexes.add(l+1);
						lines.set(l, line.substring(0,i) + replace + line.substring(i+len,line.length()));
					}
				}
			}
			BufferedWriter clear = new BufferedWriter(new FileWriter(fileDir));
			clear.write("");
			clear.close();
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileDir, true)));
			for (String line : lines) {
				out.println(line);
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return com.ifly6.General.array.ArrayListToArray(indexes);
	}
}
