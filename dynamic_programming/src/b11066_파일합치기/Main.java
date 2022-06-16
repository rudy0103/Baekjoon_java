package b11066_파일합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0;tc<T;tc++) {
			
			int K=Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[K+5];
			int[] prefixSum=new int[K+5];
			int[][] dp = new int[501][501];
			
			for(int i=0;i<501;i++)
				Arrays.fill(dp[i], -1);
			
			for(int i=0;i<K;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				prefixSum[i+1]=prefixSum[i]+arr[i];
			}
			
			int res=Integer.MAX_VALUE;
			for(int i=0;i<K-1;i++) {
				res=Math.min(res, getMin(arr, prefixSum, dp, 0, i)+getMin(arr, prefixSum, dp, i+1, K-1));	
			}
			sb.append(res+"\n");
		}
		System.out.println(sb.toString());
	}

	private static int getMin(int[] arr,int[] prefixSum,int[][]dp, int start, int end) {
		
		if(start==end) return arr[start];

		if(dp[start][end]!=-1) return dp[start][end];
		
		int ret=Integer.MAX_VALUE;
		
		int sum=prefixSum[end+1]-prefixSum[start];
		
		for(int i=start;i<end;i++) {
			ret=Math.min(ret, sum+getMin(arr, prefixSum, dp, start, i)+getMin(arr, prefixSum, dp, i+1, end));
		}
		return dp[start][end]=ret;
		
	}

}
