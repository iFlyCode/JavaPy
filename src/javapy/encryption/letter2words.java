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

package javapy.encryption;

import java.util.Scanner;

public class letter2words {

	/**
	 * I have no idea what this is or means anymore. Deprecated.
	 *
	 * @param args
	 */
	@Deprecated public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Reference Dictionary, seperated by spaces");
		String preDict = scan.nextLine();
		String[] dict = preDict.split(" ");

		System.out.println("Enter middle letter");
		char mid = 'f';

		for (String element : dict) {
			if (element.charAt(1) == mid) {
				if ((element.charAt(0) != element.charAt(2)) && (mid != element.charAt(0)) && (mid != element.charAt(2))) {
					System.out.println(element);
				}
			}
		}

		mid = 'k';
		for (String element : dict) {
			if (element.charAt(1) == mid) {
				if ((element.charAt(0) != element.charAt(2)) && (mid != element.charAt(0)) && (mid != element.charAt(2))) {
					System.out.println(element);
				}
			}
		}

		mid = 'p';
		for (String element : dict) {
			if (element.charAt(1) == mid) {
				if ((element.charAt(0) != element.charAt(2)) && (mid != element.charAt(0)) && (mid != element.charAt(2))) {
					System.out.println(element);
				}
			}
		}

		mid = 's';
		for (String element : dict) {
			if (element.charAt(1) == mid) {
				if ((element.charAt(0) != element.charAt(2)) && (mid != element.charAt(0)) && (mid != element.charAt(2))) {
					System.out.println(element);
				}
			}
		}

		scan.close();
	}
}
