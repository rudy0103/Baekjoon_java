package b2293_동전1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);

		int[] dp=new int[k+1];

		ArrayList<Integer> coins = new ArrayList<>();
		coins.add(0);
		
		for (int i = 1; i <=n; i++) {
			int c=Integer.parseInt(br.readLine());
			if(c<=k)
				coins.add(c);
		}
		
		dp[0]=1;
		///////
		for(int i=1;i<coins.size();i++) {
			for(int j=1;j<=k;j++) {
				if(coins.get(i)<=j) {
					dp[j]+=dp[j-coins.get(i)];
				}
			}
		}
        ///출력
		System.out.println(dp[k]);
	}
}
