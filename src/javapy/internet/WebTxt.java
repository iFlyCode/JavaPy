package javapy.internet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * These are methods which all pertain to getting a text return from a web page.
 * There should be no unrelated methods here.
 */
public class WebTxt {

	/**
	 * <ul>
	 * <li><b><i> download </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public void download(URL website, File directory) throws IOException
	 * </p>
	 * <p>
	 * Downloads a file from a URL, then places it into a folder.
	 * </p>
	 * 
	 * @author ifly6
	 * @param urlFrom
	 *            - the URL you're downloading from.
	 * @param directory
	 *            - the place you're putting the file
	 * @throws IOException
	 */
	public void download(URL website, File directory) throws IOException {
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(directory);
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		fos.close();
	}

	/**
	 * <ul>
	 * <li><b><i> readNetPage </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public String readNetPage(String urlFrom) throws IOException
	 * </p>
	 * <p>
	 * Reads the contents of a file online. This will return the <b>pure</b> raw
	 * text form of the file, with no formatting.
	 * </p>
	 * 
	 * @author ifly6
	 * @param urlFrom
	 *            - URL with file you're reading from.
	 * @return String with contents of file.
	 * @throws IOException
	 */
	public String readNetPage(URL website) throws IOException {
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		String contents = rbc.toString();
		return contents;
	}

	/**
	 * <ul>
	 * <li><b><i> newInetFile </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public File newInetFile(String urlFrom, String directory)
	 * </p>
	 * <p>
	 * Convenience method to create a new file based off downloaded data from
	 * the Internet.
	 * </p>
	 * 
	 * @author ifly6
	 * @param urlFrom
	 *            - URL to fetch data from.
	 * @param directory
	 *            - Place to put data.
	 * @return File where the data was placed.
	 * @throws IOException
	 */
	public File newInetFile(URL website, File directory) throws IOException {
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(directory);
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		fos.close();
		return directory;
	}

}
