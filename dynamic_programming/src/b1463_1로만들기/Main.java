package b1463_1로만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int [] dp=new int[n+1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1]=0;
		for(int i=2;i<=n;i++) {
			dp[i]=Math.min(dp[i], dp[i-1]+1);
			if(i%2==0) dp[i]=Math.min(dp[i], dp[i/2]+1);
			if(i%3==0) dp[i]=Math.min(dp[i], dp[i/3]+1);
		}
		System.out.println(dp[n]);
	}
}
