package javapy.application;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Methods pertaining to accessing the launch daemon of the underlying Operating
 * System should go here.
 */
public class Runtime {

	/**
	 * <ul><li><b><i>
	 * execReturn
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public String execReturn(final String[] input) throws IOExcpetion
	 * </p><p>
	 * Executes a command line command, then returns the output and error
	 * streams inside a String.</p>
	 * 
	 * @author ifly6
	 * @param input
	 *            - String to run through ProcessBuilder
	 * @throws IOException
	 * @return String with information given by CLI programme in error and out
	 *         streams.
	 */
	public String execReturn(final String[] input) throws IOException {

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
		scan.close();
		// Error Stream
		InputStream errStream = process.getErrorStream();
		InputStreamReader errRead = new InputStreamReader(errStream);
		scan = new Scanner(errRead);
		while (scan.hasNextLine()) {
			total.add(scan.nextLine());
		}
		scan.close();
		return total.toString();
	}

	/**
	 * <ul><li><b><i>
	 * exec
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public void exec(final String[] input) throws IOException
	 * </p><p>
	 * Just launches a process with the associated command-line functions, there
	 * is no return.
	 * 
	 * @param input
	 *            - the command to be executed, in String[] form.
	 * @throws IOException
	 */
	public void exec(final String[] input) throws IOException {
		ProcessBuilder builder = new ProcessBuilder(input);
		builder.start();
	}
}
