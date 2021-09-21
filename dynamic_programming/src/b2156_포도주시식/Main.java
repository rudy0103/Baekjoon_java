package b2156_포도주시식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int [] arr = new int[N+1];
		int [][] dp = new int[N+1][3];
		
		for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(br.readLine());
		
		
		dp[1][0]=0;//안마실때
		dp[1][1]=arr[1];//이전 포도주 안마시고 마실 때
		dp[1][2]=arr[1];//이전 포도주 마시고 마실 때
		
		for(int i=2;i<=N;i++) {
			int tmp=Math.max(dp[i-2][1], dp[i-2][2]);
			int tmp2=Math.max(dp[i-1][1], dp[i-1][2]);
			dp[i][0]=Math.max(tmp, tmp2);
			dp[i][1]=dp[i-1][0]+arr[i];
			dp[i][2]=dp[i-1][1]+arr[i];
		}
		int max=-1;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=2;j++) if(dp[i][j]>=max) max=dp[i][j];
		}
		System.out.println(max);
	}
}
