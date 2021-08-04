package b10870_피보나치수5;

import java.util.Scanner;

public class Main {
	static int cnt,cnt2;
	public static int func(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}
		return  func(n-1)+func(n-2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		System.out.println(func(N));
	}
}
