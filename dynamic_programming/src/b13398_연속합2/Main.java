package b13398_연속합2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		int [] arr= new int[N+1];
		int [][] dp = new int[N+1][2];
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) 
		{
			arr[i]=Integer.parseInt(st.nextToken());
			max=Math.max(max, arr[i]);
		}
		
		if(max<=0) {
			System.out.println(max);
			return;
		}
		
		
		for(int i=1;i<=N;i++) {
			if(arr[i]>=0) {
				dp[i][0]=Math.max(dp[i-1][0]+arr[i],arr[i]);
				dp[i][1]=Math.max(dp[i-1][1]+arr[i],arr[i]);
			}else {
				dp[i][0]=Math.max(0, dp[i-1][0]+arr[i]);
				dp[i][1]=Math.max(dp[i-1][1]+arr[i],dp[i-1][0]);

			}
			max=Math.max(max, dp[i][0]);
			max=Math.max(max, dp[i][1]);
		}
		System.out.println(max);
	}

}
