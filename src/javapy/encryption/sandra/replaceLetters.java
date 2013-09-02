package javapy.encryption.sandra;

public class replaceLetters {

	/**
	 * @param args
	 */
	public static String shift(int shiftBy, String text) {
		/*
		 * int shiftValue = 1; char[] alphabet = new char[] { 'a', 'b', 'c',
		 * 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
		 * 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '!', ' ' }; boolean[]
		 * replace = new boolean[alphabet.length];
		 * 
		 * Scanner kb = new Scanner(System.in);
		 * 
		 * System.out.print("$ "); String input = kb.nextLine().toLowerCase();
		 * 
		 * Arrays.fill(replace, false); for (char c : input.toCharArray()) { int
		 * index = -1; for (int i = 0; i < alphabet.length; i++) { if
		 * (alphabet[i] == c) { index = i; break; } } if (index >= 0) {
		 * replace[index] = true; } }
		 * 
		 * for (int i = alphabet.length - 1; i > 0; i--) { if (replace[i]) {
		 * text = text.replace(alphabet[i], alphabet[(i + shiftValue) %
		 * alphabet.length]); } } System.out.println(text);
		 */

		// Conversion to computer alphabet.
		for (int x = 0; x < text.length(); x++) {
			char[] tempArray = text.toCharArray();
			char temp = tempArray[x];
			if (temp == 'Š') {
				tempArray[x] = '{';
			}
			if (temp == 'š') {
				tempArray[x] = '|';
			}
			if (temp == 'Ÿ') {
				tempArray[x] = '}';
			}
			if (temp == '§') {
				tempArray[x] = '~';
			}

			text = new String(tempArray);
		}

		// BEGIN code from Internet
		String output = "";

		for (char temp : text.toCharArray()) {
			output += Character
					.toString((char) (((temp - 'a' + shiftBy) % 30) + 'a'));
		}
		// END code from Internet

		// Conversion to German Alphabet, instead of some computer one.
		char[] tempArray = output.toCharArray();
		char[] refArray = text.toCharArray();

		for (int x = 0; x < output.length(); x++) {
			char temp = tempArray[x];
			if (temp == '{') {
				tempArray[x] = 'Š';
			}
			if (temp == '|') {
				tempArray[x] = 'š';
			}
			if (temp == '}') {
				tempArray[x] = 'Ÿ';
			}
			if (temp == '~') {
				tempArray[x] = '§';
			}
			if (temp == ']') {
				tempArray[x] = ' ';
			}
			if (Character.isUpperCase(temp) || temp == '^') {
				tempArray[x] = refArray[x];
			}

			output = new String(tempArray);
		}

		return (output);
	}

}
