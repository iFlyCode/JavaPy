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

package javapy.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javapy.util.JPArrayUtils;

/**
 * Class for methods which relate to reading a file and providing an output, or information about what was read. There
 * should be no methods which actually CHANGE the file inside this class.
 */
public class JPReader {

	FileReader reader;

	/**
	 * Constructs the reader based around a certain file.
	 *
	 * @param file to be read
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public JPReader(File file) throws FileNotFoundException {
		reader = new FileReader(file);
	}

	/**
	 * Constructs the readers based around a certain file path.
	 *
	 * @param path to the file to be read
	 * @throws FileNotFoundException if the path's file cannot be found
	 */
	public JPReader(String path) throws FileNotFoundException {
		this(new File(path));
	}

	/**
	 * Reads the file, puts it into a <code>String[]</code> based on new lines.
	 *
	 * @author ifly6
	 * @param file
	 * @return ArrayList with the file inside, Line by Line
	 * @throws IOException if there is a problem in reading the file
	 */
	public String[] readToArray() throws IOException {
		ArrayList<String> contents = new ArrayList<String>(0);

		String line;
		BufferedReader bufferedReader = new BufferedReader(reader);
		while ((line = bufferedReader.readLine()) != null) {
			contents.add(line);
		}
		bufferedReader.close();

		return (String[]) JPArrayUtils.toArray(contents);
	}

	/**
	 * Looks for the contents of a certain line in the file.
	 *
	 * @param file where the scanning is occurring
	 * @param line which is requested
	 * @return <code>String</code> with the contents of the line in question, but a blank string if the line is longer
	 *         than the file
	 * @author ncolaprete
	 * @author ifly6
	 * @throws IOException
	 */
	public String readLine(File file, int line) throws IOException {

		int lineNum = 0;
		String readLine;
		BufferedReader bufferedReader = new BufferedReader(reader);

		while ((readLine = bufferedReader.readLine()) != null) {
			lineNum++;

			if (lineNum == line) {
				bufferedReader.close();
				return readLine;
			}
		}

		bufferedReader.close();
		return null;
	}

	/**
	 * <ul>
	 * <li><b><i> searchFile </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public int[] searchFile(String file, String keyword)
	 * </p>
	 * <p>
	 * A complicated method to search through a file for instances of a certain String inside that file.
	 * </p>
	 *
	 * @author ifly6
	 * @param file - The file we're searching through.
	 * @param keyword - What we're looking for.
	 * @return An array of integers with the locations of the string you're looking for appears (by line).
	 * @throws IOException if there is a problem reading the file
	 */
	public int[] searchFile(String keyword) throws IOException {
		ArrayList<Integer> search = new ArrayList<Integer>();

		String[] contents = this.readToArray();

		for (int i = 0; i < contents.length; i++) {
			String evaluate = contents[i];
			if (evaluate.contains(keyword)) {
				search.add(i);
			}
		}

		String[] strings = (String[]) search.toArray();

		// Convert ArrayList to int[]
		Integer[] locations = search.toArray(new Integer[search.size()]);
		for (int x = 0; x < strings.length; x++) {
			locations[x] = Integer.getInteger(strings[x]);
		}

		return JPArrayUtils.toPrimitiveArray(locations);
	}

	/**
	 * Gets the length of the file in lines.
	 *
	 * @return an <code>int</code> containing the number of lines in the file
	 * @throws IOException
	 */
	public int getLenth() throws IOException {
		String[] file = this.readToArray();
		return file.length;
	}
}
