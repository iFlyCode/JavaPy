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
import java.util.ArrayList;

import com.git.iflycode.files.JPFileWriter;

/**
 * <code>JPTableWriter</code> is both a table creator and a table writer. For it to work, first set a number of various
 * variables.
 *
 * <p>
 * <ul>
 * <li><code>columnsInTable</code> – which is simply the number of columns in the table. This must be set for anything
 * else to be formatted.
 * <li><code>header</code> – a <code>String[]</code> which allows for headers to be set.
 * <li><code>rows</code> — an <code>ArrayList&lt;String[]&gt;</code> which is an <code>ArrayList</code> of
 * <code>String[]</code> which requires that the <code>String[]</code> be consistent with those from the
 * <code>header</code> setting and the <code>columnsInTable</code>.
 * <li><code>sepChar</code> – which is the character from which the horizontal separators are created.
 * </ul>
 * </p>
 *
 * There are two mechanisms to get the actual table from <code>JPTableWriter</code>:
 *
 * <p>
 * <ul>
 * <li><code>print()</code> and <code>toString()</code>, which simply returns a single <code>String</code> containing
 * the entire table.
 * <li><code>write(File)</code>, which writes the file to some <code>File</code> utilising <code>JPFileWriter</code>.
 * </ul>
 * </p>
 *
 * @author ifly6
 */
public class JPTableWriter {

	private String[] header;
	private ArrayList<String[]> rows = new ArrayList<String[]>();

	private int columnsInTable;
	private char sepChar = '-';

	public JPTableWriter(int columns) {
		setColumnNumber(columns);
		header = new String[columns];
	}

	public void setColumnNumber(int columns) {
		columnsInTable = columns;
	}

	public void setSeparatorChar(char newSepChar) {
		sepChar = newSepChar;
	}

	public void setHeaders(String[] headers) {
		if (headers.length != columnsInTable) {
			throw new ArrayIndexOutOfBoundsException("headers.length, " + headers.length + ", not same as columnsInTable, " + columnsInTable);
		} else {
			for (int i = 0; i < headers.length; i++) {
				headers[i] = headers[i].trim();
			}

			header = headers;
		}
	}

	public void setHeader(int column, String headerString) {
		if (column > columnsInTable) {
			throw new RuntimeException("Column specified, " + column + ", greater than columnsInTable, " + columnsInTable);
		} else {
			header[column] = headerString.trim();
		}
	}

	private String createSeparator(int tableLength) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tableLength; i++) {
			builder.append(sepChar);
		}
		return builder.toString() + "\n";
	}

	public void addRow(String[] row) {
		if (row.length == columnsInTable) {
			rows.add(row);
		} else {
			throw new RuntimeException("Row columns, " + row.length + ", not same as columnsInTable, " + columnsInTable);
		}
	}

	public void addRows(String[]... inRows) {
		for (String[] row : inRows) {
			if (inRows.length == columnsInTable) {
				rows.add(row);
			} else {
				throw new RuntimeException("row.length, " + row.length + ", not same as columnsInTable, " + columnsInTable);
			}
		}
	}

	public void replaceRow(int column, String[] inRow) {
		rows.set(column, inRow);
	}

	public void replaceElement(int column, int row, String element) {
		String[] tempRowContents = rows.get(column);
		tempRowContents[row] = element;
		rows.set(column, tempRowContents);
	}

	public String print() {

		// Calculate length of the table
		int length = 0;
		int[] longestText = new int[columnsInTable];

		// Duplicate rows for search
		ArrayList<String[]> allRows = new ArrayList<String[]>(rows);
		allRows.add(header);

		// Find longest element in each column
		for (String[] row : allRows) {
			for (int x = 0; x < row.length; x++) {
				String element = row[x];
				if (element.length() > longestText[x]) {
					longestText[x] = element.length();
				}
			}
		}

		// Add three spaces
		for (int x = 0; x < longestText.length; x++) {
			longestText[x] = longestText[x] + 3;
		}

		// Sum up to the total length
		for (int x : longestText) {
			length = length + x;
		}

		// Create the total
		StringBuilder builder = new StringBuilder();

		// Append the header
		for (int x = 0; x < header.length; x++) {
			String cell = header[x];
			builder.append(cell);

			int remainder = longestText[x] - cell.length();
			for (int i = 0; i < remainder; i++) {
				builder.append(" ");
			}
		}
		builder.append(System.lineSeparator());

		// Append the separator
		builder.append(createSeparator(length));

		// Deal with the body of the text itself
		for (String[] row : rows) {
			StringBuilder rowText = new StringBuilder();

			// Create each row
			for (int x = 0; x < row.length; x++) {
				if (row[0].startsWith(createSeparator(3))) {
					// Allow creation of a separator by three '-'
					rowText.append(createSeparator(length));

				} else {
					String cell = row[x];
					rowText.append(cell);

					int remainder = longestText[x] - cell.length();
					for (int i = 0; i < remainder; i++) {
						rowText.append(" ");
					}
				}
			}

			builder.append(rowText.toString() + System.lineSeparator());
		}

		// Return it
		return builder.toString();
	}

	@Override public String toString() {
		return print();
	}

	/**
	 * Writes the table to some file utilising <code>JPFileWriter</code>.
	 * 
	 * @param file to which this is to be written
	 * @throws IOException
	 */
	public void write(File file) throws IOException {
		JPFileWriter writer = new JPFileWriter(file);
		writer.write(this.toString());
	}
}