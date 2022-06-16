package b10422_괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		int [] dp=new int[5001];
		
		
		dp[0]=1;
		dp[2]=1;
		dp[4]=2;
		
		for(int i=6;i<=5000;i++) {
			for(int j=i-2;j>=0;j-=2) {
				dp[i]+=dp[j]*dp[i-j-2];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0;tc<T;tc++) {
			int num=Integer.parseInt(br.readLine());
			if(num%2==1) sb.append("0\n");
			else sb.append(dp[num]+"\n");
		}
		System.out.println(sb.toString());
		
	}

}
