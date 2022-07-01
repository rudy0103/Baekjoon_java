package b19951_태상이의훈련소생활;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		
		int [] prefixSum=new int[N+1];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			
			prefixSum[s]+=k;
			if(e+1<=N) {
				prefixSum[e+1]-=k;
			}
			
		}
		
		for(int i=2;i<=N;i++) {
			prefixSum[i]+=prefixSum[i-1];
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			arr[i]+=prefixSum[i];
			sb.append(arr[i]+" ");
		}
		System.out.println(sb.toString());
		
		
		
		
	}

}
