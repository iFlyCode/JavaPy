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

/**
 * The <code>VarSubstitutionEncoder</code> class is a way to create a cipher which changes itself every time it encodes
 * a letter. For every encoding of a character, it changes the place at which the letter is encoded so that it
 * manipulates the letter variation.
 *
 * @author ifly6
 */
public class VarSubstitutionEncoder {

	private String text;
	private int start;
	private char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z', ' ' };

	/**
	 * Creates an instance of the variable substitution encoder.
	 *
	 * @param inText text to be encoded or decoded
	 * @param startInt starting stepping point
	 */
	public VarSubstitutionEncoder(String inText, int startInt) {
		text = inText;
		start = startInt;
	}

	/**
	 * Creates an instance of the variable substitution encoder. Generic
	 *
	 * @param inText text to be encoded or decoded
	 */
	public VarSubstitutionEncoder(String inText) {
		text = inText;
		start = 0;
	}

	/**
	 * Encodes the provided text based on the implementation of the stepper and the starting integer.
	 *
	 * @return an encoded version of the text
	 */
	public String encode() {
		char[] subArray = text.toCharArray();

		int stepper = 0;
		for (int i = 0; i < subArray.length; i++) {
			int letterInt = getAlphabetNumber(subArray[i]);
			subArray[i] = alphabet[overflow(letterInt + stepper + start)];
			stepper = nextStepper(stepper);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (char element : subArray) {
			stringBuilder.append(element);
		}

		return stringBuilder.toString();
	}

	/**
	 * Allows for the stepper to be easily changed based on an algorithm. Override this function if necessary.
	 *
	 * @param current value of the stepper
	 * @return the next step in the cycle
	 */
	private int nextStepper(int current) {
		return current++;
	}

	/**
	 * Decodes the provided text based on the implementation of the stepper and the starting integer.
	 *
	 * @return a decoded version of the text
	 */
	// TODO Write this.
	public String decode() {
		return null;
	}

	/**
	 * Gets the place of a character in the alphabet.
	 *
	 * @param letter of the alphabet
	 * @return the numerical representation thereof
	 */
	private int getAlphabetNumber(char letter) {
		for (int i = 0; i < alphabet.length; i++) {
			if (letter == alphabet[i]) { return i; }
		}
		return 0;
	}

	/**
	 * Prevents numbers from overflowing past the alphabet array.
	 *
	 * @param input number of the steps taken
	 * @return that number overflowed such that it cannot throw an <code>ArrayOutOfBoundsException</code>
	 */
	private int overflow(int input) {
		return input % alphabet.length;
	}
}
