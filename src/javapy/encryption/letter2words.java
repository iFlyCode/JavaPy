package javapy.encryption;

import java.util.Scanner;

public class letter2words {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Reference Dictionary, seperated by spaces");
		String preDict = scan.nextLine();
		String[] dict = preDict.split(" ");

		System.out.println("Enter middle lettre");
		char mid = 'f';

		for (String element : dict) {
			if (element.charAt(1) == mid) {
				if ((element.charAt(0) != element.charAt(2))
						&& (mid != element.charAt(0))
						&& (mid != element.charAt(2))) {
					System.out.println(element);
				}
			}
		}

		mid = 'k';
		for (String element : dict) {
			if (element.charAt(1) == mid) {
				if ((element.charAt(0) != element.charAt(2))
						&& (mid != element.charAt(0))
						&& (mid != element.charAt(2))) {
					System.out.println(element);
				}
			}
		}

		mid = 'p';
		for (String element : dict) {
			if (element.charAt(1) == mid) {
				if ((element.charAt(0) != element.charAt(2))
						&& (mid != element.charAt(0))
						&& (mid != element.charAt(2))) {
					System.out.println(element);
				}
			}
		}

		mid = 's';
		for (String element : dict) {
			if (element.charAt(1) == mid) {
				if ((element.charAt(0) != element.charAt(2))
						&& (mid != element.charAt(0))
						&& (mid != element.charAt(2))) {
					System.out.println(element);
				}
			}
		}
	}
}
