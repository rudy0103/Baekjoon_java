package b2294_동전2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		HashSet<Integer> set = new HashSet<>();
		
		
		for(int i=0;i<n;i++) {
			int coin=Integer.parseInt(br.readLine());
			if(coin<=k) {
				set.add(coin);
			}
		}
		ArrayList<Integer> coins = new ArrayList<>(set);
		Collections.sort(coins);
		
		
		int[] dp=new int[k+1];
		Arrays.fill(dp, 123456789);
		
		dp[0]=0;
		
		for(int i=0;i<coins.size();i++) {
			int coin=coins.get(i);
			for(int j=0;j<=k;j++) {
				if(j+coin<=k) {
					dp[j+coin]=Math.min(dp[j]+1, dp[j+coin]);
				}
			}
		}
		
		if(dp[k]>=123456789) System.out.println("-1");
		else System.out.println(dp[k]);
		
	}

}
