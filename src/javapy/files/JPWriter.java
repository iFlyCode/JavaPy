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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javapy.util.JPArrayUtils;

/**
 * The place for methods which involve a file, and involve the changing of the contents of that file.
 */
public class JPWriter {

	File file;
	BufferedWriter writer;

	/**
	 * Constructs <code>WriterPy</code> with a certain file.
	 *
	 * @param givenFile the relevant file
	 * @throws IOException if there is a problem in constructing the BufferedWriter
	 */
	public JPWriter(File givenFile) throws IOException {
		writer = new BufferedWriter(new FileWriter(file));
		file = givenFile;
	}

	/**
	 * Constructs <code>WriterPy</code> with a certain path.
	 *
	 * @param givenFile the path to the relevant file
	 * @throws IOException if there is a problem in constructing the BufferedWriter
	 */
	public JPWriter(String path) throws IOException {
		this(new File(path));
	}

	/**
	 * Method for reading file, integrating file, replacing instances of a certain <code>String</code> and replacing it
	 * with another. Should not be used on massive files.
	 *
	 * @author ifly6
	 * @param file in question
	 * @param findString is the <code>String</code> we're looking for
	 * @param replaceString is the <code>String</code> you want to replace all instances of the <code>findString</code>
	 *            with.
	 * @throws IOException if there is an error in reading or writing the <code>String</code>
	 */
	public void replaceInstance(String findString, String replaceString) throws IOException {
		ArrayList<String> contents = new ArrayList<String>(0);
		FileReader configRead = new FileReader(file);
		Scanner scan = new Scanner(configRead);

		while (scan.hasNextLine()) {
			contents.add(scan.nextLine());
		}
		scan.close();

		String replaced = JPArrayUtils.toString(contents, '\n').replaceAll(findString, replaceString);

		writer.write(replaced);
		writer.close();
	}

	/**
	 * Method to write a file with the contents of a provided <code>String</code>. Does not provide for appending.
	 *
	 * @author ifly6
	 * @param contents of file that you're going to write to <code>File</code> directory
	 * @throws IOException if there is a problem in writing the <code>String</code>
	 */
	public void write(String contents) throws IOException {
		writer.write(contents);
		writer.close();
	}

	/**
	 * Method to write a file with the contents of a provided <code>String</code>. Provides the necessary boolean for
	 * appending.
	 *
	 * @author ifly6
	 * @param contents of file to write to file
	 * @param append is a <code>boolean</code> which determines whether to append or not
	 * @throws IOException if there is a problem in writing to file
	 */
	public void write(String contents, boolean append) throws IOException {
		if (append) {
			writer = new BufferedWriter(new FileWriter(file, append));
			writer.write(contents);
			writer.close();
		} else if (!append) {
			write(contents);
		}
	}

	/**
	 * Method for convenience for writing an <code>String[]</code> to a file by line.
	 *
	 * @author ifly6
	 * @param file to written to
	 * @param array to write to file
	 * @throws IOException if there is a problem in writing the file
	 */
	public void writeArray(String[] array) throws IOException {
		this.write(JPArrayUtils.toString(array, '\n'));
	}

	/**
	 * Reads a file, finds the line in question, replaces that line, writes the line.
	 *
	 * @author ifly6
	 * @param file in question
	 * @param toWrite new contents of the line
	 * @param line number in question
	 * @throws IOException if something goes wrong in writing or if the line specified is greater than the number of
	 *             lines in the file
	 */
	public void writeLine(String toWrite, int line) throws IOException {
		JPReader readerPy = new JPReader(file);

		if (line < readerPy.getLenth()) {
			String[] file = readerPy.readToArray();
			file[line] = toWrite;
			this.writeArray(file);
		} else {
			throw new IOException("Line specified is greater than length of file");
		}
	}
}
