package javapy.application;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javapy.util.JPArrayUtils;

/**
 * Methods pertaining to accessing the launch daemon of the underlying Operating System should go here.
 */
public class ProcessExecutor {

	String[] execCommands = {};

	public ProcessExecutor(String[] commands) {
		execCommands = commands;
	}

	/**
	 * Executes a command line command, then returns the output and error streams inside a String.
	 *
	 * @author ifly6
	 * @param commands to run through ProcessBuilder
	 * @throws IOException
	 * @return String with information given by CLI programme in error and out streams.
	 */
	public String execReturn() throws IOException {

		// Array List which we add to, then convert to String
		final ArrayList<String> total = new ArrayList<String>(0);

		ProcessBuilder builder = new ProcessBuilder(execCommands);
		Process process = builder.start();

		// Output Stream
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

		return JPArrayUtils.toString(total, '\n');
	}

	/**
	 * Just launches a process with the associated command-line functions, there is no return.
	 *
	 * @param command to be executed, in String[] form.
	 * @throws IOException if there is a problem in execution
	 */
	public void exec() throws IOException {
		ProcessBuilder builder = new ProcessBuilder(execCommands);
		builder.start();
	}
}
