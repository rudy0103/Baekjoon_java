package b14501_퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N=Integer.parseInt(br.readLine());
		int [][] consulting=new int[N+1][2];
		int []dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			consulting[i][0]=Integer.parseInt(st.nextToken());
			consulting[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=i-1;j>=0;j--) {
				if(j+consulting[j][0]<=i&&i+consulting[i][0]<=N+1) {
					dp[i]=Math.max(dp[i], dp[j]+consulting[i][1]);
				}
			}
		}
		int max=0;
		for(int i=1;i<=N;i++) max=Math.max(max, dp[i]);
		System.out.println(max);
		
	}

}
