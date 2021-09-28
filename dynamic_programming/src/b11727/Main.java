package b11727;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int [] dp=new int[1001];
		int m=10007;
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3;i<=1000;i++) {
			dp[i]=dp[i-1]+(2*dp[i-2]);
			dp[i]%=m;
		}
		System.out.println(dp[n]);
	}
	

}
