package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class primes2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

		String[] in = s.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);
		boolean[] p = new boolean[(int) Math.sqrt(m)];
		p[0] = true;

		for (int i = 2; i < p.length; i++) {
			if (p[i - 1] == false) {
				int add = 2 * i;
				while (add <= p.length) {
					p[add - 1] = true;
					add += i;
				}
			}
		}

		boolean[] pR = new boolean[m + 1 - n];
		if (n == 1) {
			pR[0] = true;
		}
		for (int i = 0; i < p.length; i++) {
			if (p[i] == false) {
				int add = (((n - 1) / (i + 1)) + 1) * (i + 1);
				if (add == (i + 1)) {
					add += add;
				}
				while (add < m + 1) {
					pR[add - n] = true;
					add += i + 1;
				}
			}
		}
		for (int i = 0; i < pR.length; i++) {
			if (pR[i] == false) {
				System.out.println(i + n);
			}
		}
	}
}

/*
Given two integers N and M (N ≤ M), output all the prime numbers between N and M inclusive, one per line.

N and M will be positive integers less than or equal to 1,000,000,000.
The difference between N and M will be less than or equal to 5,000,000.

Sample Input
5 20

Sample Output
5
7
11
13
17
19

*/