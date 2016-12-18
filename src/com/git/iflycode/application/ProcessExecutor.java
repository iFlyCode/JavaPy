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

package com.git.iflycode.application;

import java.io.IOException;
import java.io.InputStream;

/** Methods pertaining to accessing the launch daemon of the underlying Operating System should go here. */
public class ProcessExecutor {
	
	String[] execCommands = {};

	public ProcessExecutor(String[] commands) {
		execCommands = commands;
	}

	/** Executes a command line command, then returns the output and error streams.
	 * @author ifly6
	 * @throws IOException
	 * @return an <code>InputStream</code> which the process returns. */
	public InputStream execReturn() throws IOException {
		ProcessBuilder builder = new ProcessBuilder(execCommands);
		builder.redirectErrorStream(true);
		Process process = builder.start();
		return process.getInputStream();
	}

	/** Just launches a process with the associated command-line functions, there is no return.
	 * @param command to be executed, in String[] form.
	 * @throws IOException if there is a problem in execution */
	public void exec() throws IOException {
		ProcessBuilder builder = new ProcessBuilder(execCommands);
		builder.start();
	}
}
