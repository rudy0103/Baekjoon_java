package b1912_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		
		int max=Integer.MIN_VALUE;
		int dp[]=new int[N+1];
		for(int i=1;i<=N;i++) {
			if(dp[i-1]>0) {
				dp[i]=Math.max(dp[i-1]+arr[i], dp[i-1]);
			}else {
				dp[i]=arr[i];
			}
			max=Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}

}
