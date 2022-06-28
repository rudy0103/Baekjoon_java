package b18428_감시피하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static boolean flag;
	static int N;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		
		ArrayList<int[]> teachers=new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=st.nextToken().charAt(0);
				if(map[i][j]=='T') teachers.add(new int[] {i,j});
			}
		}
		
		dfs(map,teachers,0,0);
		if(flag) System.out.println("YES");
		else System.out.println("NO");
		
	}

	private static void dfs(char[][] map, ArrayList<int[]> teachers, int d, int start) {
		
		if(d>=3) {
			if(isPossible(map,teachers)) {
				flag=true;
			}
			return;
		}
		
		for(int i=start;i<N*N;i++) {
			
			int r=i/N;
			int c=i%N;
			
			if(map[r][c]!='X') continue;
			map[r][c]='O';
			dfs(map, teachers, d+1, i+1);
			map[r][c]='X';
			
		}
		
		
	}

	private static boolean isPossible(char[][] map, ArrayList<int[]> teachers) {
		
		for(int[] t:teachers) {
			
			int r=t[0];
			int c=t[1];
			
			for(int d=0;d<4;d++) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				while(nr>=0&&nr<N&&nc>=0&&nc<N) {
				
					if(map[nr][nc]=='O') break;
					if(map[nr][nc]=='S') return false;
					nr+=dr[d];
					nc+=dc[d];
				}
			}
			
		}
		
		return true;
	}

}
