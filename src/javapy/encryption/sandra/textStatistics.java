package javapy.encryption.sandra;

public class textStatistics {

	/**
	 * as this is built for the Sandra and woo voynich thing, it will be using
	 * the German alphabet, with the added characters: Š, š, Ÿ, and §. It will
	 * also process the special character '&'. This will use the built alphabet
	 * which was created by Ryan, and will be using the additions I put on it
	 * for conversion to the German Alphabet.
	 * 
	 * @param args
	 */
	public static void frequency(String text) {
		char[] charArray = text.toCharArray();

		// Make a variable for every letter.
		int aggregate = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		int g = 0;
		int h = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int m = 0;
		int n = 0;
		int o = 0;
		int p = 0;
		int q = 0;
		int r = 0;
		int s = 0;
		int t = 0;
		int u = 0;
		int v = 0;
		int w = 0;
		int x = 0;
		int y = 0;
		int z = 0;
		int Š = 0;
		int š = 0;
		int Ÿ = 0;
		int § = 0;
		int et = 0;

		// Iterate through the entire array.
		for (char test : charArray) {

			if (test == 'a') {
				a++;
			}
			if (test == 'b') {
				b++;
			}
			if (test == 'c') {
				c++;
			}
			if (test == 'd') {
				d++;
			}
			if (test == 'e') {
				e++;
			}
			if (test == 'f') {
				f++;
			}
			if (test == 'g') {
				g++;
			}
			if (test == 'h') {
				h++;
			}
			if (test == 'i') {
				i++;
			}
			if (test == 'j') {
				j++;
			}
			if (test == 'k') {
				k++;
			}
			if (test == 'l') {
				l++;
			}
			if (test == 'm') {
				m++;
			}
			if (test == 'n') {
				n++;
			}
			if (test == 'o') {
				o++;
			}
			if (test == 'p') {
				p++;
			}
			if (test == 'q') {
				q++;
			}
			if (test == 'r') {
				r++;
			}
			if (test == 's') {
				s++;
			}
			if (test == 't') {
				t++;
			}
			if (test == 'u') {
				u++;
			}
			if (test == 'v') {
				v++;
			}
			if (test == 'w') {
				w++;
			}
			if (test == 'x') {
				x++;
			}
			if (test == 'y') {
				y++;
			}
			if (test == 'z') {
				z++;
			}
			if (test == 'Š') {
				Š++;
			}
			if (test == 'š') {
				š++;
			}
			if (test == 'Ÿ') {
				Ÿ++;
			}
			if (test == '§') {
				§++;
			}
			if (test == '&') {
				et++;
			}
		}

		// Output
		System.out.println("aggregate sum of chars	" + aggregate);
		System.out.println("a	" + a);
		System.out.println("b	" + b);
		System.out.println("c	" + c);
		System.out.println("d	" + d);
		System.out.println("e	" + e);
		System.out.println("f	" + f);
		System.out.println("g	" + g);
		System.out.println("h	" + h);
		System.out.println("i	" + i);
		System.out.println("j	" + j);
		System.out.println("k	" + k);
		System.out.println("l	" + l);
		System.out.println("m	" + m);
		System.out.println("n	" + n);
		System.out.println("o	" + o);
		System.out.println("p	" + p);
		System.out.println("q	" + q);
		System.out.println("r	" + r);
		System.out.println("s	" + s);
		System.out.println("t	" + t);
		System.out.println("u	" + u);
		System.out.println("v	" + v);
		System.out.println("w	" + w);
		System.out.println("x	" + x);
		System.out.println("y	" + y);
		System.out.println("z	" + z);
		System.out.println("Š	" + Š);
		System.out.println("š	" + š);
		System.out.println("Ÿ	" + Ÿ);
		System.out.println("§	" + §);
		System.out.println("&	" + et);
	}
}
