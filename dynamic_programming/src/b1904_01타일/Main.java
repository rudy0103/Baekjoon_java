package b1904_01타일;

import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] dp=new int[n+5];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		dp[3]=3;
		for(int i=4; i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
			dp[i]%=15746;
		}
		System.out.println(dp[n]);
	}
}
