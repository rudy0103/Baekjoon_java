package b15988_1_2_3더하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		long [][] dp=new long[100001][4];
		
		dp[1][1]=1;
		dp[1][0]=1;
		
		dp[2][2]=1;
		dp[2][0]=1;
		
		dp[3][1]=1;
		dp[3][2]=1;
		dp[3][3]=1;
		dp[3][0]=3;
		
		int m=1000000009;
		for(int i=4;i<=100000;i++) {
			dp[i][1]=(dp[i-1][2]+dp[i-1][3])%m;
			dp[i][2]=(dp[i-2][1]+dp[i-2][3])%m;
			dp[i][3]=(dp[i-3][1]+dp[i-3][2])%m;
			dp[i][0]=(dp[i][1]+dp[i][2])%m+dp[i][3];
			dp[i][0]%=m;
		}
		
		
		for(int tc =0;tc<T;tc++) {
			int n=Integer.parseInt(br.readLine());
			sb.append(dp[n][0]+"\n");
		}
		
		
		System.out.println(sb.toString());
	}

}
