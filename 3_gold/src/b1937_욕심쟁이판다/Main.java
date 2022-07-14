package b1937_욕심쟁이판다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	static int[] dr ={-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int N,max=0;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		int[][] dp=new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(dp[i][j]!=0) continue;
				dfs(i,j,dp,map);
				max=Math.max(max, dp[i][j]);
			}
		}
		
		System.out.println(max);
		
	}
	
	public static int dfs(int r, int c, int[][] dp,int[][] map) {
		
		if(dp[r][c]!=0) {
			return dp[r][c];
		}
		
		dp[r][c]=1;
		int step=dp[r][c];
		boolean flag=false;
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			
			if(nr<0||nr>=N||nc<0||nc>=N||map[nr][nc]<=map[r][c]) continue;
			flag=true;
			dp[r][c]=Math.max(dp[r][c], step+dfs(nr, nc, dp, map));
		}
		
		if(flag==false) return dp[r][c]=1;
	
		
		return dp[r][c];
	}

}
