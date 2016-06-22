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

package com.git.iflycode.encryption;

public class TranspositionEncoder {

	private String text;
	private int rows;
	private int columns;

	public TranspositionEncoder(String inputText, int inputRows) {
		text = inputText;
		rows = inputRows;
	}

	public String encode() {

		if (text.length() % rows > 0) {
			columns = text.length() / rows + 1;
		} else {
			columns = text.length() / rows;
		}

		char[] chars = text.toCharArray();
		char[][] transTable = new char[rows][columns];
		int inText = 0;

		// Load Characters.
		for (int column = 0; column < columns; column++) {
			for (int row = 0; row < rows; row++) {
				try {
					transTable[row][column] = chars[inText];
					inText++;
				} catch (ArrayIndexOutOfBoundsException e) {
					transTable[row][column] = '$';
				}
			}
		}

		// Transpose Characters
		StringBuilder stringBuilder = new StringBuilder();
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				stringBuilder.append(transTable[row][column]);
			}
		}

		return stringBuilder.toString();
	}

	public String decode(int rows, int columns) {
		char[] chars = text.toCharArray();
		char[][] transTable = new char[rows][columns];
		int inText = 0;

		// Load Characters.
		for (int column = 0; column < columns; column++) {
			for (int row = 0; row < rows; row++) {
				transTable[row][column] = chars[inText];
				inText++;
			}
		}

		// Transpose Characters
		StringBuilder stringBuilder = new StringBuilder();
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				stringBuilder.append(transTable[column][row]);
			}
		}

		return stringBuilder.toString();
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
}
