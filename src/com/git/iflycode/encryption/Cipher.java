/* Copyright (c) 2015 Kevin Wong and Nicholas Colaprete
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. */

package com.git.iflycode.encryption;

public class Cipher {

	/**
	 * <p>
	 * Takes an an array of strings and item, and inserts the item into the first empty index of the array.
	 * </p>
	 *
	 * @author ncolaprete
	 * @param list - the array to have the item inserted into
	 * @param item - the string to insert into the list
	 * @return list with the item inserted
	 */
	public String[] append(String[] list, String item) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].isEmpty()) {
				list[i] = item;
				return list;
			}
		}
		return list;
	}

	/**
	 * <ul>
	 * <li><b><i> decryptDAS </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public String decryptDAS(String plainText, String keyCode)
	 * </p>
	 * <p>
	 * Decrypts one string with the Dynamic Alphabetical Shift Cipher, using another string as a keycode.
	 * </p>
	 *
	 * @author ncolaprete
	 * @param encrypted - the text encrypted
	 * @param keyCode - the keyCode to the text encrypted
	 * @return the decrypted text
	 */
	public String decryptDAS(String plainText, String keyCode) {

		plainText = plainText.toUpperCase();
		keyCode = keyCode.toUpperCase();

		String[] normAlpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z", " " };
		String[][] codedAlphas = new String[keyCode.length()][normAlpha.length];
		for (int i = 0; i < keyCode.length(); i++) {
			int start = getIndex(normAlpha, keyCode.substring(i, i + 1));
			for (int j = 0; j < codedAlphas[i].length; j++) {
				codedAlphas[i][j] = normAlpha[(j + start) % normAlpha.length];
			}
		}
		String[] plainList = getListFrom(plainText);
		String[] codedList = new String[plainList.length];
		for (int i = 0; i < plainList.length; i++) {
			for (int e = 0; e < keyCode.length(); e++) {
				for (int j = 0; j < codedAlphas[e % keyCode.length()].length; j++) {
					if (plainList[i].equals(codedAlphas[e % keyCode.length()][j])) {
						codedList[i] = normAlpha[j];
						break;
					}
				}
			}
		}
		return seal(codedList);
	}

	/**
	 * <ul>
	 * <li><b><i> decryptVignere </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public String decryptVignere(String encrypted, String keyCode)
	 * </p>
	 * <p>
	 * Decrypts one string with the Vigen�re Cipher, using another string as a keycode.
	 * </p>
	 *
	 * @author ncolaprete
	 *
	 * @param encrypted - the text encrypted
	 * @param keyCode - the keyCode to the text encrypted
	 * @return the plain-text that was encrypted
	 */
	public String decryptVignere(String encrypted, String keyCode) {
		encrypted = encrypted.toUpperCase();
		keyCode = keyCode.toUpperCase();

		String[] normAlpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z", " " };
		String[] codedAlpha = new String[normAlpha.length];
		for (int i = 0; i < codedAlpha.length; i++) {
			codedAlpha[i] = "";
		}
		for (int i = 0; i < keyCode.length(); i++) {
			String letter = keyCode.substring(i, i + 1);
			if (!hasString(codedAlpha, letter)) {
				codedAlpha = append(codedAlpha, letter);
			}
		}
		for (int i = 0; i < normAlpha.length; i++) {
			if (!hasString(codedAlpha, normAlpha[i])) {
				codedAlpha = append(codedAlpha, normAlpha[i]);
			}
		}
		String[] plainList = getListFrom(encrypted);
		String[] codedList = new String[plainList.length];
		for (int i = 0; i < plainList.length; i++) {
			for (int j = 0; j < codedAlpha.length; j++) {
				if (plainList[i].equals(normAlpha[j])) {
					codedList[i] = codedAlpha[j];
					break;
				}
			}
		}

		return seal(codedList);
	}

	/**
	 * <ul>
	 * <li><b><i> encryptDAS </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public String encryptDAS(String plainText, String keyCode)
	 * </p>
	 * <p>
	 * Encrypts one string with the Dynamic Alphabetical Shift Cipher, using another string as a key code.
	 * </p>
	 *
	 * @author ncolaprete
	 *
	 * @param encrypted - the text to encrypt
	 * @param keyCode - the keyCode to encrypt the text with
	 * @return the encrypted text
	 */
	public String encryptDAS(String plainText, String keyCode) {

		plainText = plainText.toUpperCase();
		keyCode = keyCode.toUpperCase();

		String[] normAlpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z", " " };
		String[][] codedAlphas = new String[keyCode.length()][normAlpha.length];
		for (int i = 0; i < keyCode.length(); i++) {
			int start = getIndex(normAlpha, keyCode.substring(i, i + 1));
			for (int j = 0; j < codedAlphas[i].length; j++) {
				codedAlphas[i][j] = normAlpha[(j + start) % normAlpha.length];
			}
		}
		String[] plainList = getListFrom(plainText);
		String[] codedList = new String[plainList.length];
		for (int i = 0; i < plainList.length; i++) {
			for (int e = 0; e < keyCode.length(); e++) {
				for (int j = 0; j < codedAlphas[e % keyCode.length()].length; j++) {
					if (plainList[i].equals(normAlpha[j])) {
						codedList[i] = codedAlphas[e % keyCode.length()][j];
						break;
					}
				}
			}
		}
		return seal(codedList);
	}

	/**
	 * <ul>
	 * <li><b><i> encryptVignere </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public String encryptVignere(String plainText, String keyCode)
	 * </p>
	 * <p>
	 * Encrypts one string with the Vigen�re Cipher, using another string as a key code.
	 * </p>
	 *
	 * @author ncolaprete
	 *
	 * @param plainText - the text we're encrypting
	 * @param keyCode - the encryption pass-code
	 * @return encrypted text
	 */
	public String encryptVignere(String plainText, String keyCode) {

		plainText = plainText.toUpperCase();
		keyCode = keyCode.toUpperCase();

		String[] normAlpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z", " " };
		String[] codedAlpha = new String[normAlpha.length];
		for (int i = 0; i < codedAlpha.length; i++) {
			codedAlpha[i] = "";
		}
		for (int i = 0; i < keyCode.length(); i++) {
			String letter = keyCode.substring(i, i + 1);
			if (!hasString(codedAlpha, letter)) {
				codedAlpha = append(codedAlpha, letter);
			}
		}
		for (int i = 0; i < normAlpha.length; i++) {
			if (!hasString(codedAlpha, normAlpha[i])) {
				codedAlpha = append(codedAlpha, normAlpha[i]);
			}
		}
		String[] plainList = getListFrom(plainText);
		String[] codedList = new String[plainList.length];
		for (int i = 0; i < plainList.length; i++) {
			for (int j = 0; j < codedAlpha.length; j++) {
				if (plainList[i].equals(codedAlpha[j])) {
					codedList[i] = normAlpha[j];
					break;
				}
			}
		}

		return seal(codedList);
	}

	/**
	 * <ul>
	 * <li><b><i> getIndex </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public int getIndex(String[] list, String item)
	 * </p>
	 * <p>
	 * Takes an an array of strings and and item, and returns the index of the array that the item occupies, -1 if not
	 * in the array.
	 * </p>
	 *
	 * @author ncolaprete
	 *
	 * @param list - the array to check
	 * @param item - the string to check for
	 * @return index of the item
	 */
	public int getIndex(String[] list, String item) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].equalsIgnoreCase(item)) { return i; }
		}
		return -1;
	}

	/**
	 * <ul>
	 * <li><b><i> getListFrom </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public String[] getListFrom(String inStr)
	 * </p>
	 * <p>
	 * Takes a string, and returns an array of the strings' letters.
	 * </p>
	 *
	 * @author ncolaprete
	 *
	 * @param inStr - the string
	 * @return array of letters
	 */
	public String[] getListFrom(String inStr) {
		String[] to_sender = new String[inStr.length()];
		for (int i = 0; i < inStr.length(); i++) {
			to_sender[i] = inStr.substring(i, i + 1);
		}
		return to_sender;
	}

	/**
	 * <ul>
	 * <li><b><i> hasString </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public boolean hasString(String[] list, String item)
	 * </p>
	 * <p>
	 * Takes an an array of strings and and item, and returns true if that array has the item in it.
	 * </p>
	 *
	 * @author ncolaprete
	 *
	 * @param list - the array to check
	 * @param item - the string to check for
	 * @return if the array has the item
	 */
	public boolean hasString(String[] list, String item) {
		for (String s : list) {
			if (!s.isEmpty()) {
				if (s.equalsIgnoreCase(item)) { return true; }
			}
		}
		return false;
	}

	/**
	 * <ul>
	 * <li><b><i> seal </i></b></li>
	 * </ul>
	 * <p style="font-family:Courier">
	 * public String seal(String[] inList)
	 * </p>
	 * <p>
	 * Takes an array of strings, and returns a string of the items in the list concatenated together.
	 * </p>
	 *
	 * @author ncolaprete
	 * @author ifly6
	 * @param inList - the array of strings
	 * @return concatenated string
	 */
	public String seal(String[] inList) {
		String outString = "";
		for (String element : inList) {
			outString = new StringBuilder().append(element).toString();
		}
		return outString;
	}

}
