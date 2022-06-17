package b2003_수들의합2;

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
		
		st=new StringTokenizer(br.readLine()," ");
		
		long[] sum =new long[N+1];
		
		for(int i=1;i<=N;i++) {
			sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());
		}
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			for(int j=i;j<=N;j++) {
				if(sum[j]-sum[i-1]==M) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
