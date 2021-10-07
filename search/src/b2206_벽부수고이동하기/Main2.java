package b2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		boolean[][][] visited = new boolean[N][M][2];
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = input.charAt(j)-'0';
		}
		boolean flag = false;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		
		q.add(new int[] { 0, 0, 1, 1 });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r=tmp[0];
			int c=tmp[1];
			
			if(r==N-1&&c==M-1) {
				System.out.println(tmp[2]);
				flag=true;
				break;
			}
			
			for(int d=0;d<4;d++) {
				int rr=r+dr[d];
				int cc=c+dc[d];
				
				if(rr>=0&&rr<N&&cc>=0&&cc<M&&visited[rr][cc][tmp[3]]==false) {
					if(map[rr][cc]==0) {
						q.add(new int[] {rr,cc,tmp[2]+1,tmp[3]});
						visited[rr][cc][tmp[3]]=true;
					}else {
						if(tmp[3]==1) {
							q.add(new int[] {rr,cc,tmp[2]+1,tmp[3]-1});
							visited[rr][cc][tmp[3]]=true;
						}
					}
				}
				
				
			}
			
		}

		if (!flag)
			System.out.println(-1);

	}
}