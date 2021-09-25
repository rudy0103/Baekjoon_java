package b23061_백남이의여행준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int [][] items=new int[N+1][2]; //w,v
		int [] knapsack=new int[M+1];
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			items[i][0]=Integer.parseInt(st.nextToken());
			items[i][1]=Integer.parseInt(st.nextToken());
		}
		int maxWeight=-1;
		
		for(int i=1;i<=M;i++) {
			knapsack[i]=Integer.parseInt(br.readLine());
			if(knapsack[i]>maxWeight) maxWeight=knapsack[i];
		}
		
		int []dp=new int[maxWeight+1];
		
		for(int i=1;i<=N;i++) {
			for(int w=maxWeight;w>=items[i][0];w--) {
				dp[w]=Math.max(dp[w], dp[w-items[i][0]]+items[i][1]);
			}
		}
		
		double maxVal=-10.0;
		int idx=-1;
		
		for(int i=1;i<=M;i++) {
			if((double)dp[knapsack[i]]/(double)knapsack[i]>maxVal) {
				maxVal=(double)dp[knapsack[i]]/(double)knapsack[i];
				idx=i;
			}
		}
		
		System.out.println(idx);
	}
}
