/* Copyright (c) 2015 Kevin Wong and Nicholas Colaprete
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. */

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
		builder.redirectErrorStream(true);
		Process process = builder.start();

		// Output Stream
		InputStream outStream = process.getInputStream();
		InputStreamReader outRead = new InputStreamReader(outStream);
		Scanner scan = new Scanner(outRead);
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
