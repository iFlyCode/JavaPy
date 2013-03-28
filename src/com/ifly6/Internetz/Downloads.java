package com.ifly6.Internetz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloads {

	/**
	 * Downloads a file from a URL, then places it into a folder.
	 * 
	 * @param urlFrom
	 *            - the URL you're downloading from.
	 * @param directory
	 *            - the place you're putting the file
	 * @throws IOException
	 */
	public void download(String urlFrom, String directory) throws IOException {
		URL website = new URL(urlFrom);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(directory);
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		fos.close();
	}

	/**
	 * Reads the contents of a file online. This will return the <b>pure</b> raw
	 * text form of the file, with no formatting.
	 * 
	 * @param urlFrom
	 *            - URL with file you're reading from.
	 * @return String with contents of file.
	 * @throws IOException
	 */
	public String readNetPage(String urlFrom) throws IOException {
		URL website = new URL(urlFrom);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		String contents = rbc.toString();
		return contents;
	}

}
