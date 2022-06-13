package b15989_1_2_3더하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		long [] dp=new long[10001];
		int m=1000000009;
		
		dp[0]=1;
		
		for(int i=1;i<=3;i++) {
			for(int j=i;j<=10000;j++) {
				dp[j]+=dp[j-i]%m;
			}
		}
		
	
			
		for(int tc =0;tc<T;tc++) {
			int n=Integer.parseInt(br.readLine());
			sb.append(dp[n]+"\n");
		}
		
		
		System.out.println(sb.toString());
	}

}
