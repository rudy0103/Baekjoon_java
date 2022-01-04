package b18290_NM과K_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int res=Integer.MIN_VALUE;
	static int N,M,K;
	static int []dr= {-1,1,0,0};
	static int []dc= {0,0,-1,1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		int [][] map=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		backtracking(0,0,0,map);
		
		System.out.println(res);
		
	}

	private static void backtracking(int depth,int sum,int start, int[][] map) {
		
		if(depth==K) {
			res=Math.max(res, sum);
			return;
		}
		
		
		for(int i=start;i<N*M;i++) {
			int r=i/M;
			int c=i%M;
			
			
			if(isPromising(map,r,c)) {
				int tmp=map[r][c];
				map[r][c]=-123456789;
				backtracking(depth+1, sum+tmp, i+1, map);
				map[r][c]=tmp;
			}
		}
	}

	private static boolean isPromising(int[][] map, int r, int c) {
		
		
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0&&nr<N&&nc>=0&&nc<M) {
				if(map[nr][nc]==-123456789) return false;
			}
			
		}
		
		return true;
	}
}
