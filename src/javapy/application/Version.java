package javapy.application;

public class Version {

	static int[] version;

	Version() {
		this(version);
	}

	Version(int[] input) {
		for (int x = 0; x < 3; x++) {
			version[x] = input[x];
		}
	}

	public String getVersion() throws JPException {
		String output = "";
		for (int x = 0; x < 3; x++) {
			output = output + Integer.toString(version[x]) + ".";
		}

		// Throw Exception if Boring
		if (output.equals("...")) {
			throw new JPException("There is no version set.");

		}

		return output;
	}

	public void setMajorVersion(int input) {
		version[0] = input;
	}

	public void setMinorVersion(int input) {
		version[1] = input;
	}

	public void setBugVersion(int input) {
		version[2] = input;
	}
}
