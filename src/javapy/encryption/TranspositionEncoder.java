package javapy.encryption;

public class TranspositionEncoder {

	private String text;
	private int rows;
	private int columns;

	public TranspositionEncoder(String inputText, int inputRows) {
		text = inputText;
		rows = inputRows;
	}

	public String encode() {

		if (text.length() % rows > 0) {
			columns = text.length() / rows + 1;
		} else {
			columns = text.length() / rows;
		}

		char[] chars = text.toCharArray();
		char[][] transTable = new char[rows][columns];
		int inText = 0;

		// Load Characters.
		for (int column = 0; column < columns; column++) {
			for (int row = 0; row < rows; row++) {
				try {
					transTable[row][column] = chars[inText];
					inText++;
				} catch (ArrayIndexOutOfBoundsException e) {
					transTable[row][column] = '$';
				}
			}
		}

		// Transpose Characters
		StringBuilder stringBuilder = new StringBuilder();
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				stringBuilder.append(transTable[row][column]);
			}
		}

		return stringBuilder.toString();
	}

	public String decode(int rows, int columns) {
		char[] chars = text.toCharArray();
		char[][] transTable = new char[rows][columns];
		int inText = 0;

		// Load Characters.
		for (int column = 0; column < columns; column++) {
			for (int row = 0; row < rows; row++) {
				transTable[row][column] = chars[inText];
				inText++;
			}
		}

		// Transpose Characters
		StringBuilder stringBuilder = new StringBuilder();
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				stringBuilder.append(transTable[column][row]);
			}
		}

		return stringBuilder.toString();
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
}
