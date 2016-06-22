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

package com.git.iflycode.files;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reads text from a file with allowance for reading all lines, reading a single line, reading an range of lines, and
 * reading those lines which are only applicable for a certain keyword.
 *
 * <p>
 * This code is designed to use <code>File</code> but also allows in its constructor methods to accept <code>File</code>
 * , <code>Path</code>, and <code>String</code>. It reads all lines utilising the new Java 8 function for reading all
 * lines to a <code>List&lt;String&gt;</code>. However, for more complicated functions, it utilises
 * <code>BufferedReader</code>, especially for line manipulations.
 * </p>
 *
 * <p>
 * The code here is designed to minimise its use of memory and disc, so it does not actually read the entire thing into
 * file, as did the old <code>JPReader</code>. Some of the method names have been changed, but they are all consistent
 * with the original system. For example, the old <code>JPReader</code> used to count lines by reading the entire file
 * into memory and returning the length of the array. This no longer does that. Furthermore, this has switched to the
 * use of <code>List&lt;String&gt;</code> rather than normal arrays, following the precedent set by changes in the Java
 * 7 version of the <code>java.nio.file</code> package.
 * </p>
 *
 * @author ifly6
 */
public class JPFileReader {

	File file;
	int endingLine;

	/* Constructors */
	private JPFileReader() throws IOException {
		endingLine = this.countLines();
	}

	public JPFileReader(File inFile) throws IOException {
		this();
		file = inFile;
	}

	public JPFileReader(Path path) throws IOException {
		this(path.toFile());
	}

	public JPFileReader(String pathStr) throws IOException {
		this(new File(pathStr));
	}

	/* Actual methods */
	/**
	 * Reads all lines from the file. This is a wrapper around <code>Files.readAllLines(Paths.get(file.toURI()))</code>.
	 *
	 * @return a <code>List&lt;String&gt;</code> containing all of the lines
	 * @throws IOException
	 */
	public List<String> readAllLines() throws IOException {
		return Files.readAllLines(Paths.get(file.toURI()));
	}

	/**
	 * Returns an <code>int</code> containing the number of lines in the file
	 *
	 * @return an <code>int</code> with the number of lines in the file
	 * @throws IOException
	 */
	public int countLines() throws IOException {

		// From StackOverflow, http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
		InputStream is = new BufferedInputStream(new FileInputStream(this.file));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}

	/**
	 * Reads a certain line from file. Note that doing so requires the creation of a <code>BufferedReader</code> every
	 * time it runs.
	 *
	 * @param line is an <code>int</code> which tells us which line is to be read
	 * @return the <code>String</code> contents of that line
	 * @throws IOException
	 */
	public String readLine(int line) throws IOException {

		if (line < endingLine) {

			int currentLine = 0;
			String readLine;

			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

			while ((readLine = bufferedReader.readLine()) != null) {
				if (currentLine == line) {
					bufferedReader.close();
					return readLine;
				}
				currentLine++;
			}

		} else {
			throw new ArrayIndexOutOfBoundsException(
					"Attempted to read " + line + " which is more than the number of lines in the file, " + endingLine);
		}

		return null;
	}

	/**
	 * Reads a number of lines to file. Note that doing so requires the creation of a <code>BufferedReader</code> every
	 * time it runs. Also note that if you put in <code>(1, 3)</code>, it will read from line 1 to line 3, inclusive.
	 * The response in a <code>List&lt;String&gt;</code>, will include lines 1, 2, and 3.
	 *
	 * @param startLine an <code>int</code> from which reading will start
	 * @param endLine an <code>int</code> at which reading will end
	 * @return a <code>List&lt;String&gt;</code> containing the relevant lines
	 * @throws IOException
	 */
	public List<String> readLines(int startLine, int endLine) throws IOException {

		List<String> fileLines = new ArrayList<String>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		String readLine;
		int currentLine = 0;

		while ((readLine = bufferedReader.readLine()) != null) {
			if (currentLine <= endLine && currentLine >= startLine) {
				fileLines.add(readLine);
			}
			currentLine++;
		}

		bufferedReader.close();
		return fileLines;
	}

	/**
	 * Find matches of a keyword from file. Note that doing so requires the creation of a <code>BufferedReader</code>
	 * every time it runs.
	 *
	 * @param keyword a <code>String</code> which appears in all read lines
	 * @return a <code>List&lt;String&gt;</code> containing the relevant lines
	 * @throws IOException
	 */
	public Map<Integer, String> getMatches(String keyword) throws IOException {

		Map<Integer, String> results = new HashMap<Integer, String>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		String readLine;
		int currentLine = 0;

		while ((readLine = bufferedReader.readLine()) != null) {
			if (readLine.contains(keyword)) {
				results.put(currentLine, readLine);
			}
			currentLine++;
		}

		bufferedReader.close();
		return results;
	}
}
