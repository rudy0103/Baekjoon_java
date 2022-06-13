package b11052_카드구매하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) dp[i]=Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N-i;j++) {
				dp[i+j]=Math.max(dp[i+j], dp[i]+dp[j]);
			}
		}
		System.out.println(dp[N]);
		
		
	}

}
