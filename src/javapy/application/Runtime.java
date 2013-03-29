package javapy.application;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Runtime {

	/**
	 * Executes a command line command, then returns the output and error
	 * streams inside a String
	 * 
	 * @author ifly6
	 * @param input
	 *            - String to run through ProcessBuilder
	 * @throws IOException
	 * @return String with information given by CLI programme in error and out
	 *         streams.
	 */
	public static String exec(final String[] input) throws IOException {

		// Array List which we add to, then convert to String
		final ArrayList<String> total = new ArrayList<String>(0);

		// Output Stream
		ProcessBuilder builder = new ProcessBuilder(input);
		Process process = builder.start();
		InputStream outStream = process.getInputStream();
		InputStreamReader outRead = new InputStreamReader(outStream);
		Scanner scan = new Scanner(outRead);
		while (scan.hasNextLine()) {
			total.add(scan.nextLine());
		}

		// Error Stream
		InputStream errStream = process.getErrorStream();
		InputStreamReader errRead = new InputStreamReader(errStream);
		scan = new Scanner(errRead);
		while (scan.hasNextLine()) {
			total.add(scan.nextLine());
		}

		return total.toString();
	}

}
