package b18429_근손실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt=0;
	static boolean [] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		visited=new boolean[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		dfs(arr,N,0,500,K);
		
		System.out.println(cnt);
		
	}

	private static void dfs(int[] arr,int n, int d, int sum, int k) {
		
		if(d>=n) {
			if(sum>=500) cnt++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i]) continue;
			if(sum-k+arr[i]>=500) {
				visited[i]=true;
				dfs(arr, n, d+1, sum-k+arr[i], k);
				visited[i]=false;
			}
			
		}
	}

}
