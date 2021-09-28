package b11333_4xn타일링;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T= sc.nextInt();
		int[] dp = new int[10001];
		int m=1000000007;
		dp[3]=3;
	
		for(int i=6)
		
		
		for(int tc=0;tc<T;tc++) {
			int n=sc.nextInt();
			sb.append(dp[n]).append("\n");
		}
	}

}
