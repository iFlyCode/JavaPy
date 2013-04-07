package javapy.files;

import java.io.File;

/**
 * Methods which pertain to the deletion of a file/files, should all go here.
 */
public class Delete {

	/**
	 * <ul><li><b><i>
	 * delete
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public void delete(String[] directories)
	 * </p><p>
	 * Delete a file.</p>
	 * 
	 * @author ifly6
	 * @param directory
	 *            - the file in question that you're deleting
	 */
	public void delete(String directory) {
		File file = new File(directory);
		file.delete();
	}

	/**
	 * <ul><li><b><i>
	 * delete
	 * </i></b></li></ul><p style="font-family:Courier">
	 * public void delete(String[] directiories)
	 * </p><p>
	 * Deletes files that are declared in an array of Strings.</p>
	 * 
	 * @param directories
	 *            - the files in question which are to be deleted.
	 */
	public void delete(String[] directories) {
		for (String element : directories) {
			File file = new File(element);
			file.delete();
		}
	}

}
