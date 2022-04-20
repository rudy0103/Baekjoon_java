package b14502_연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

//start : 21:35 ~ 21:52
public class Main {
	
	static int maxSafeArea=0;
	static boolean[][] visited;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static boolean [][] infected;
	static int R,C;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		R=N;
		C=M;
		
		int [][] origin = new int[N][M];
		visited=new boolean[N][M];
		infected=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				origin[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		solution(origin);
		
		
		System.out.println(maxSafeArea);

	}

	private static void solution(int[][] origin) {
		
		dfs(0,origin,0);
		
	}

	private static void dfs(int d, int[][] origin,int start) {
		
		if(d==3) {
			maxSafeArea=Math.max(getSafeArea(origin),maxSafeArea);
			return;
		}
		
		for(int i=start;i<R*C;i++) {
			int r=i/C;
			int c=i%C;
			if(origin[r][c]!=0) continue;
			origin[r][c]=1;
			dfs(d+1, origin,i+1);
			origin[r][c]=0;
			
		}
		
	}

	private static int getSafeArea(int[][] origin) {

		int cnt=0;
		
		for(int i=0;i<R;i++) {
			Arrays.fill(infected[i], false);
			Arrays.fill(visited[i], false);
		}
		
		ArrayDeque<int[]> dq=new ArrayDeque<>();
		
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(visited[i][j]||origin[i][j]!=2) continue;
				dq.add(new int[] {i,j});
				visited[i][j]=true;
				infected[i][j]=true;
				while(!dq.isEmpty()) {
					int[] curr=dq.poll();
					
					for(int d=0;d<4;d++) {
						int nr=curr[0]+dr[d];
						int nc=curr[1]+dc[d];
						
						if(nr>=R||nr<0||nc>=C||nc<0||visited[nr][nc]||origin[nr][nc]!=0) continue;
						visited[nr][nc]=true;
						infected[nr][nc]=true;
						dq.add(new int[] {nr,nc});
					}
					
				}
				
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(origin[i][j]==0&&!infected[i][j]) cnt++;
			}
		}
		
		
		return cnt;
	}

}
