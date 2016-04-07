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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * <code>JPPreferencesWriter</code> is a writer for simple preference files. It writes things into the standard
 * preference style as <code>key=value</code>. It writes each of these keys on a new line. It accepts four variables:
 *
 * <p>
 * <ul>
 * <li><code>outFile</code> – the File to which this is written. Note that this class will <i>always</i> overwrite the
 * original file at this place.
 * <li><code>headers</code> – a <code>List&lt;String&gt;</code> which consists of all the headers. This will
 * automatically be commented, so there is no need to include hashes.
 * <li><code>preferenceData</code> – a <code>Map&lt;String, String&gt;</code> which is a <code>Map</code> that contains
 * all relevant preferences.
 * <li><code>footers</code> – a <code>List&lt;String&gt;</code> which consists of all the footers. This will
 * automatically be commented, so there is no need to include hashes.
 * </ul>
 * </p>
 *
 * <p>
 * The writer is based on the <code>PrintWriter</code> class in the Java libraries. Because of its initialisation
 * format, it is also quite easy to build your own custom preference writer by extending this class and automatically
 * implementing the headers in preferences or automatically implementing whatever is necessary.
 * </p>
 *
 * @author ifly6
 */
public class JPPreferencesWriter {

	File outFile;
	List<String> headers;
	Map<String, String> preferenceData;
	List<String> footers;

	/**
	 * To make sure that the minimum amount of data is provided, independent initialisation has been suppressed.
	 */
	private JPPreferencesWriter() {

	}

	/**
	 * Creates a new <code>JPPreferencesWriter</code> which is targeted at a certain file.
	 *
	 * @param file which is pointed at a certain file. If it already exists, it will be truncated to zero size.
	 */
	public JPPreferencesWriter(File file) {
		this();
		outFile = file;
	}

	/**
	 * Creates a new <code>JPPreferencesWriter</code> which is targeted at a certain file. It also loads the preferences
	 * automatically.
	 *
	 * @param file which is pointed at a certain file. If it already exists, it will be truncated to zero size.
	 * @param preferences to be written in the format <code>Map&lt;String, String&gt;</code> with keys and values.
	 */
	public JPPreferencesWriter(File file, Map<String, String> preferences) {
		this(file);
		this.setPreferences(preferences);
	}

	/**
	 * Creates a new <code>JPPreferencesWriter</code> which is targeted at a certain file. It also loads the preferences
	 * and headers automatically.
	 *
	 * @param file which is pointed at a certain file. If it already exists, it will be truncated to zero size.
	 * @param header to be written in the format <code>List&lt;String&gt;</code>. Comment hashes are included.
	 * @param preferences to be written in the format <code>Map&lt;String, String&gt;</code> with keys and values.
	 */
	public JPPreferencesWriter(File file, List<String> header, Map<String, String> preferences) {
		this(file, preferences);
		headers = header;
	}

	/**
	 * Creates a new <code>JPPreferencesWriter</code> which is targeted at a certain file. It also loads the preferences
	 * and headers automatically.
	 *
	 * @param file which is pointed at a certain file. If it already exists, it will be truncated to zero size.
	 * @param header to be written in the format <code>List&lt;String&gt;</code>. Comment hashes are included.
	 * @param preferences to be written in the format <code>Map&lt;String, String&gt;</code> with keys and values.
	 * @param footer to be written in the format <code>List&lt;String&gt;</code>. Comment hashes are included.
	 */
	public JPPreferencesWriter(File file, List<String> header, Map<String, String> preferences, List<String> footer) {
		this(file, header, preferences);
		footers = footer;
	}

	public void setHeaders(List<String> header) {
		headers = header;
	}

	public void setPreferences(Map<String, String> preferences) {
		preferenceData = preferences;
	}

	public void setFooters(List<String> footer) {
		footers = footer;
	}

	public boolean write() throws IOException {

		PrintWriter writer = new PrintWriter(outFile);
		int linesWritten = 0;

		// Write the headers
		for (String element : headers) {
			writer.println("#" + element);
			linesWritten++;
		}

		// Make a new line for formatting
		writer.println();
		linesWritten++;

		// Write the preferences
		for (Map.Entry<String, String> entry : preferenceData.entrySet()) {
			writer.println(entry.getKey() + "=" + entry.getValue());
			linesWritten++;
		}

		// Make a new line for formatting
		writer.println();
		linesWritten++;

		// Write footers
		for (String element : footers) {
			writer.println("#" + element);
			linesWritten++;
		}

		writer.close();

		// Confirm
		if (linesWritten == new JPFileReader(outFile).countLines()) {
			return true;
		} else {
			return false;
		}
	}
}
