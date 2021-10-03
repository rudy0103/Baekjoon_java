package b1932_정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int [][] dp=new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				int tmp=Integer.parseInt(st.nextToken());
				dp[i][j]=Math.max(dp[i-1][j-1]+tmp, dp[i-1][j]+tmp);
			}
		}
		int max=-1;
		
		for(int i=1;i<=N;i++) {
			if(dp[N][i]>max) max=dp[N][i];
		}
		
		System.out.println(max);
		

	}

}
