package b1699_제곱수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int [] dp=new int[N+1];
		
		
		ArrayList<Integer> list =new ArrayList<>();
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1]=1;
		dp[0]=0;
		
		int n=1;
		
		while(n*n<=N) {
			list.add(n*n);
			dp[n*n]=1;
			n++;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<list.size();j++) {
				
				if(i+list.get(j)<=N) {
					dp[i+list.get(j)]=Math.min(dp[i+list.get(j)], dp[i]+1);
				}else break;
			}
		}
		
		System.out.println(dp[N]);
		
		
	}

}
