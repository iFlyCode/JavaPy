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

package com.git.iflycode.internet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * These are methods which all pertain to getting a text return from a web page. There should be no unrelated methods
 * here.
 */
public class JPDownloader {

	/**
	 * Downloads a file from a URL, then places it into a folder. It does not return the file created, since it was
	 * provided as the second argument.
	 *
	 * @author ifly6
	 * @param website from which the file should be downloaded
	 * @param directory to place the file in
	 * @throws IOException if an issue occurs with the download or the writing to file
	 */
	protected void download(URL website, File directory) throws IOException {
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(directory);
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		fos.close();
	}

	/**
	 * Reads the contents of a file online. This will return the raw text form of the file, with no formatting.
	 *
	 * @param website to read
	 * @return <code>String</code> with contents of file
	 * @throws IOException if an issue occurs with the download
	 */
	public String readUrltoString(URL website) throws IOException {

		StringBuilder builder = new StringBuilder();
		for (String element : readUrlLines(website)) {
			builder.append(element + "\n");
		}

		return builder.toString();
	}

	/**
	 * Reads the contents of a file online. This will return the raw text form of the file, with no formatting.
	 *
	 * @param website to read
	 * @return <code>List&lt;String&gt;</code> with contents of file
	 * @throws IOException if an issue occurs with the download
	 */
	public List<String> readUrlLines(URL website) throws IOException {

		List<String> dataList = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			dataList.add(inputLine);
		}
		in.close();

		return dataList;
	}
}
