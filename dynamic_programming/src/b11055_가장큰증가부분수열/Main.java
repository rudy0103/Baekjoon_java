package b11055_가장큰증가부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int [] arr = new int[N+1];
		for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		int[] dp=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=i;j++) {
				if(arr[i]>arr[j]) dp[i]=Math.max(dp[i], dp[j]+arr[i]);
			}
		}
		int max=dp[0];
		
		for(int i=1;i<=N;i++) {
			if(dp[i]>max) max=dp[i];
		}
		System.out.println(max);
	}
}
