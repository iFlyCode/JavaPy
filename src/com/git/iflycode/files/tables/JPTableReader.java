/* Copyright (c) 2016 Kevin Wong
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
package com.git.iflycode.files.tables;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.git.iflycode.files.JPFileReader;

/**
 * @author Kevin
 *
 */
public class JPTableReader {

	private int lines;
	private int columns;

	private List<String> fileContents;

	public enum MatchMode {
		EQUALS, CONTAINS, STARTSWITH
	}

	public JPTableReader(File file) throws IOException {

		JPFileReader fileReader = new JPFileReader(file);
		this.lines = fileReader.countLines();
		fileContents = fileReader.readAllLines();

	}

	// TODO implement reader, problem in parsing out information
	public List<List<String>> readToList() {

		return null;

	}

}
