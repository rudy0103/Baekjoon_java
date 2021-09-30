package b1261_알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] cost = new int[N][M];
		int[] dr = { -1, 1, 0, 0, };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = ch[j] - '0';
				cost[i][j]=123456;
			}
		}
		cost[0][0]=0;
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			int r= cur[0];
			int c= cur[1];
			
			
			for(int d=0;d<4;d++) {
				int rr= r+dr[d];
				int cc= c+dc[d];
				
				if(rr>=0&&rr<N&&cc>=0&&cc<M) {
					if(cost[rr][cc]>map[rr][cc]+cost[r][c]) {
						q.add(new int[] {rr,cc});
						cost[rr][cc]=map[rr][cc]+cost[r][c];
					}
				}
			}
			
		}
		System.out.println(cost[N-1][M-1]);

	}

}
