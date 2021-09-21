package b1912_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		int [] arr= new int[N+1];
		int [] dp = new int[N+1];
		for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken());
		// 그 전단계까지 이어서 더한게 양수면 이어서 더하고 아니면 이어서 더하지 않는다.
		dp[1]=arr[1];

		int max=dp[1];
		for(int i=2;i<=N;i++) {
			if(dp[i-1]>0) dp[i]=dp[i-1]+arr[i];
			else dp[i]=arr[i];
            if(max<dp[i]) max=dp[i];
		}
		System.out.println(max);
	}
}

