package b12738_가장긴증가하는부분수열3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int size=0;
		
		for (int i = 0; i < n; i++) {
			int tmp=Arrays.binarySearch(dp, 0,size,arr[i]);
			if(tmp>=0) continue;
			tmp=Math.abs(tmp)-1;
			dp[tmp]=arr[i];
			if(tmp==size) size++;
		}
		
		System.out.println(size);
	}
}
