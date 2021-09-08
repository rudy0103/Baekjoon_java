package b11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		String [] inp = br.readLine().split(" ");
		int N=Integer.parseInt(inp[0]);
		int M=Integer.parseInt(inp[1]);
		int [] prefixSum=new int[N+1];
		st=new StringTokenizer(br.readLine()," ");
		prefixSum[0]=0;
		for(int i=1;i<=N;i++) {
			prefixSum[i]=prefixSum[i-1]+Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			sb.append(prefixSum[b]-prefixSum[a-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
