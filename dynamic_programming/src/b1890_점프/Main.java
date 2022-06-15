package b1890_점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		int N=Integer.parseInt(br.readLine());
		
		int [][]map=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		long[][]dp=new long[N][N];
		dp[0][0]=1;
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int step=map[i][j];
				if(step==0) continue;
				
				if(i+step<N) {
					dp[step+i][j]+=dp[i][j];
				}
				
				if(j+step<N) {
					dp[i][j+step]+=dp[i][j];
				}
				
			}
		}
		
		System.out.println(dp[N-1][N-1]);
		
	}

}
