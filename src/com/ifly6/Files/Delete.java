package com.ifly6.Files;

import java.io.File;

public class Delete {

	/**
	 * Delete a file.
	 * 
	 * @author ifly6
	 * @param directory
	 *            - the file in question that you're deleting
	 */
	public void delete(String directory) {
		File file = new File(directory);
		file.delete();
	}

}
