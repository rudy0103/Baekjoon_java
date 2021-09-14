package b9461_파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		long [] dp=new long[101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		
		for(int i=4;i<101;i++) {
			dp[i]=dp[i-3]+dp[i-2];
		}
		
		for(int tc=0;tc<T;tc++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb.toString());
		System.out.println(Arrays.toString(dp));
	}
}
