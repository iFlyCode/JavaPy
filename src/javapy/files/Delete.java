package javapy.files;

import java.io.File;

/**
 * Methods which pertain to the deletion of a file/files, should all go here.
 */
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
