package b10872_팩토리얼;

import java.util.Scanner;

public class Main {
	public static long factorial(long n) {
		
		if(n==1 ||n==0) return 1;
		else {
			
			return n*factorial(n-1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n=sc.nextInt();
		
		System.out.println(factorial(n));
	}
}
