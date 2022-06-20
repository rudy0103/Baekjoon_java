package b4097_수익;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N=Integer.parseInt(br.readLine());
			
			if(N==0) break;
			
			long []dp=new long[N+1];
		
			Long max=Long.MIN_VALUE;
			
			for(int i=1;i<=N;i++) {
				int num=Integer.parseInt(br.readLine());
				if(num>=0) {
					if(dp[i-1]>=0) {
						dp[i]=dp[i-1]+num;
					}else dp[i]=num;
				}else {
					if(dp[i-1]+num>=0) {
						dp[i]=dp[i-1]+num;
					}else dp[i]=num;
				}
				max=Math.max(max, dp[i]);
			}
			sb.append(max+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
