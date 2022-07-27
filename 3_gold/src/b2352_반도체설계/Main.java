package b2352_반도체설계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		int len=0;
		
		for(int i=0;i<N;i++) {
			int num=arr[i];
			
			int idx=Arrays.binarySearch(dp,num);		
			idx=-(idx+1);
			if(idx==len) {
				dp[len]=num;
				len++;
			}else {
				dp[idx]=Math.min(dp[idx], num);
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(len);

	}

}
