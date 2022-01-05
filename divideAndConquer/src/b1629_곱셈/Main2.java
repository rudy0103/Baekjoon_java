package b1629_곱셈;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();

		long res = divideAndConquer(A, B, C);
		System.out.println(res);

	}

	private static long divideAndConquer(long a, long b, long c) {
		
		if(b==1) return a%c;
		
		if(b%2==0) {
			long tmp=divideAndConquer(a, b/2, c);
			long ret=(tmp*tmp)%c;
			return ret;
		}else {
			long tmp=divideAndConquer(a, b/2, c);
			long ret=(tmp*(tmp*a%c)%c)%c;
			return ret;
			
		}
	}
}
