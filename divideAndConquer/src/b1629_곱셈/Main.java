package b1629_곱셈;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A=sc.nextLong();
		long B=sc.nextLong();
		long C=sc.nextLong();
		
		System.out.println(power(A,B,C));
	}

	private static long power(long a, long b, long c) {
		long res=1L;
		
		while (b > 0) {
			if (b % 2 == 1)
				res = (res * a) % c;
			b = b >> 1;
			a = (a * a) % c;
		}
		
		return res;
	}

}
