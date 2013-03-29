package com.ifly6.Encryption;

public class AES {

	/**
	 * Takes an an array of strings and and item, and returns true if that array has the item in it
	 * 
	 * @param list
	 *            - the array to check
	 * @param item
	 *            - the string to check for
	 * @return if the array has the item
	 */
	public boolean hasString(String[] list, String item) {
		for (String s : list) {
			if (!s.isEmpty()) {
				if (s.equalsIgnoreCase(item)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Takes an an array of strings and item, and inserts the item into the first empty index of the array
	 * 
	 * @param list
	 *            - the array to have the item inserted into
	 * @param item
	 *            - the string to insert into the list
	 * @return list with the item inserted
	 */
	public String[] append(String[] list, String item) {
		for (int i=0;i<list.length;i++) {
			if (list[i].isEmpty()) {
				list[i] = item;
				return list;
			}
		}
		return list;
	}

	/**
	 * Takes an a string, and returns an array of the strings' letters
	 * 
	 * @param inStr
	 *            - the string
	 * @return array of letters
	 */
	public String[] getListFrom(String inStr) {
		String[] to_sender = new String[inStr.length()];
		for (int i=0;i<inStr.length();i++) {
			to_sender[i] = inStr.substring(i, i+1);
		}
		return to_sender;
	}

	/**
	 * Takes an array of strings, and returns a string of the items in the list concatenated
	 * 
	 * @param inLis
	 *            - the array of strings
	 * @return concatenated string
	 */
	public String seal(String[] inLis) {
		String to_sender = "";
		for (int i=0;i<inLis.length;i++) {
			to_sender += inLis[i];
		}
		return to_sender;
	}
	
	/**
	 * Takes an an array of strings and and item, and returns the index of the array that the item occupies, -1 if not in the array
	 * 
	 * @param list
	 *            - the array to check
	 * @param item
	 *            - the string to check for
	 * @return index of the item
	 */
	public int getIndex(String[] list, String item) {
		for (int i=0;i<list.length;i++) {
			if (list[i].equalsIgnoreCase(item)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Encrypts one string with the Vigenère Cipher, using another string as a keycode.
	 * 
	 * @param plainText
	 *            - the text we're encrypting
	 * @param keyCode
	 *            - the encryption pass-code
	 * @return encrypted text
	 */
	public String encryptVignere(String plainText, String keyCode) {
		
		plainText = plainText.toUpperCase();
		keyCode = keyCode.toUpperCase();
		
		String[] normAlpha = {
				"A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", 
				"O", "P", "Q", "R", "S", "T", "U", 
				"V", "W", "X", "Y", "Z", " "
		};
		String[] codedAlpha = new String[normAlpha.length];
		for (int i=0;i<codedAlpha.length;i++) {
			codedAlpha[i] = "";
		}
		for (int i=0;i<keyCode.length();i++) {
			String letter = keyCode.substring(i, i+1);
			if (!hasString(codedAlpha, letter))
				codedAlpha = append(codedAlpha, letter);
		}
		for (int i=0;i<normAlpha.length;i++) {
			if (!hasString(codedAlpha, normAlpha[i]))
				codedAlpha = append(codedAlpha, normAlpha[i]);
		}
		String[] plainList = getListFrom(plainText);
		String[] codedList = new String[plainList.length];
		for (int i=0;i<plainList.length;i++) {
			for (int j=0;j<codedAlpha.length;j++) {
				if (plainList[i].equals(codedAlpha[j])) {
					codedList[i] = normAlpha[j];
					break;
				}
			}
		}
		
		return seal(codedList);
	}

	/**
	 * Decrypts one string with the Vigenère Cipher, using another string as a keycode.
	 * 
	 * @param encrypted
	 *            - the text encrypted
	 * @param keyCode
	 *            - the keyCode to the text encrypted
	 * @return the plain-text that was encrypted
	 */
	public String decryptVignere(String encrypted, String keyCode) {
		encrypted = encrypted.toUpperCase();
		keyCode = keyCode.toUpperCase();
		
		String[] normAlpha = {
				"A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", 
				"O", "P", "Q", "R", "S", "T", "U", 
				"V", "W", "X", "Y", "Z", " "
		};
		String[] codedAlpha = new String[normAlpha.length];
		for (int i=0;i<codedAlpha.length;i++) {
			codedAlpha[i] = "";
		}
		for (int i=0;i<keyCode.length();i++) {
			String letter = keyCode.substring(i, i+1);
			if (!hasString(codedAlpha, letter))
				codedAlpha = append(codedAlpha, letter);
		}
		for (int i=0;i<normAlpha.length;i++) {
			if (!hasString(codedAlpha, normAlpha[i]))
				codedAlpha = append(codedAlpha, normAlpha[i]);
		}
		String[] plainList = getListFrom(encrypted);
		String[] codedList = new String[plainList.length];
		for (int i=0;i<plainList.length;i++) {
			for (int j=0;j<codedAlpha.length;j++) {
				if (plainList[i].equals(normAlpha[j])) {
					codedList[i] = codedAlpha[j];
					break;
				}
			}
		}
		
		return seal(codedList);
	}

	/**
	 * Encrypts one string with the Dynamic Alphabetical Shift Cipher, using another string as a keycode.
	 * 
	 * @param encrypted
	 *            - the text to encrypt
	 * @param keyCode
	 *            - the keyCode to encrypt the text with
	 * @return the encrypted text
	 */
	public String encryptDAS(String plainText, String keyCode) {

		plainText = plainText.toUpperCase();
		keyCode = keyCode.toUpperCase();
		
		String[] normAlpha = {
				"A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", 
				"O", "P", "Q", "R", "S", "T", "U", 
				"V", "W", "X", "Y", "Z", " "
		};
		String[][] codedAlphas = new String[keyCode.length()][normAlpha.length];
		for (int i=0;i<keyCode.length();i++) {
			int start = getIndex(normAlpha, keyCode.substring(i, i+1));
			for (int j=0;j<codedAlphas[i].length;j++) {
				codedAlphas[i][j] = normAlpha[(j+start)%normAlpha.length];
			}
		}
		String[] plainList = getListFrom(plainText);
		String[] codedList = new String[plainList.length];
		for (int i=0;i<plainList.length;i++) {
			for (int e=0;e<keyCode.length();e++) {
				for (int j=0;j<codedAlphas[e%keyCode.length()].length;j++) {
					if (plainList[i].equals(normAlpha[j])) {
						codedList[i] = codedAlphas[e%keyCode.length()][j];
						break;
					}
				}
			}
		}
		return seal(codedList);
	}

	/**
	 * Decrypts one string with the Dynamic Alphabetical Shift Cipher, using another string as a keycode.
	 * 
	 * @param encrypted
	 *            - the text encrypted
	 * @param keyCode
	 *            - the keyCode to the text encrypted
	 * @return the decrypted text
	 */
	public String decryptDAS(String plainText, String keyCode) {

		plainText = plainText.toUpperCase();
		keyCode = keyCode.toUpperCase();
		
		String[] normAlpha = {
				"A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", 
				"O", "P", "Q", "R", "S", "T", "U", 
				"V", "W", "X", "Y", "Z", " "
		};
		String[][] codedAlphas = new String[keyCode.length()][normAlpha.length];
		for (int i=0;i<keyCode.length();i++) {
			int start = getIndex(normAlpha, keyCode.substring(i, i+1));
			for (int j=0;j<codedAlphas[i].length;j++) {
				codedAlphas[i][j] = normAlpha[(j+start)%normAlpha.length];
			}
		}
		String[] plainList = getListFrom(plainText);
		String[] codedList = new String[plainList.length];
		for (int i=0;i<plainList.length;i++) {
			for (int e=0;e<keyCode.length();e++) {
				for (int j=0;j<codedAlphas[e%keyCode.length()].length;j++) {
					if (plainList[i].equals(codedAlphas[e%keyCode.length()][j])) {
						codedList[i] = normAlpha[j];
						break;
					}
				}
			}
		}
		return seal(codedList);
	}

}
