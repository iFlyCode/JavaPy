package javapy.internet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * These are methods which all pertain to getting a text return from a web page. There should be no unrelated methods
 * here.
 */
public class Downloader {

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
	 * @author ifly6
	 * @param website which should be read
	 * @return <code>String</code> with contents of file
	 * @throws IOException if an issue occurs with the download
	 */
	public String readNetPage(URL website) throws IOException {
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		String contents = rbc.toString();
		return contents;
	}
}
