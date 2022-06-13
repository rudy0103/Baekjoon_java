package b15988_1_2_3더하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int [] dp=new int[1000001];
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		int m=1000000009;
		
		for(int i=4;i<1000001;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%m+dp[i-3];
			dp[i]%=m;
		}
		
		for(int tc =0;tc<T;tc++) {
			int n=Integer.parseInt(br.readLine());
			sb.append(dp[n]+"\n");
		}
		
		
		System.out.println(sb.toString());
		
	}

}
