package b1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,S;
	static int cnt;
	static int []arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine()," ");
		arr= new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		getSum(0,0);
		if(S==0) cnt--;
		System.out.println(cnt);
		
		
	}

	private static void getSum(int depth, int sum) {
		if(depth==N) {
			if(sum==S) cnt++;
			return;
		}
		getSum(depth+1, sum+arr[depth]);
		getSum(depth+1,sum);
	}
}
