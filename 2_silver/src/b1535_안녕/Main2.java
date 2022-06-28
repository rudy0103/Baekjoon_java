package b1535_안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] hp = new int[N + 1];
		for (int i = 1; i <= N; i++)
			hp[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] pleasure = new int[N + 1];
		for (int i = 1; i <= N; i++)
			pleasure[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[101];
		
		for(int i=2;i<=100;i++) dp[i]=-1;
		
		
		
		for(int i=1;i<=N;i++) {			
			for(int j=100;j>=1;j--) {
				if(j-hp[i]>0&&dp[j-hp[i]]!=-1) {
					dp[j]=Math.max(dp[j-hp[i]]+pleasure[i], dp[j]);
				}
				
			}
		}
		
		int max=0;
		for(int i=1;i<=100;i++) max=Math.max(max, dp[i]);
		System.out.println(max);

	}

}
