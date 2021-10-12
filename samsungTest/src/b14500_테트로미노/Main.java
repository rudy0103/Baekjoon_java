package b14500_테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, max = 0;

	public static int[][] map;
	public static int[][] selected;
	public static boolean[][] visited;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		selected = new int[4][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				selected[0][0] = i;
				selected[0][1] = j;
				dfs(1, i, j);
				visited[i][j] = false;
			}
		}

		System.out.println(max);
	}

	private static void dfs(int d, int r, int c) {
		if (d == 4) {
			int tmp = 0;
			for (int i = 0; i < 4; i++) {
				tmp += map[selected[i][0]][selected[i][1]];
			}
			if (tmp > max)
				max = tmp;
			return;
		}

		if (d == 3) {
			boolean flag = true;
			int t = selected[0][0];
			for (int i = 1; i < 3; i++) {
				if (selected[i][0] != t)
					flag = false;
			}

			if (flag) {// 가로 일자
				if (selected[1][0] - 1 >= 0) {
					int rr=selected[1][0]-1;
					int cc=selected[1][1];
					visited[rr][cc] = true;
					selected[d][0] = rr;
					selected[d][1] = cc;
					dfs(d + 1, rr, cc);
					visited[rr][cc] = false;
				}
				if (selected[1][0] + 1 < N) {
					int rr=selected[1][0]+1;
					int cc=selected[1][1];
					visited[rr][cc] = true;
					selected[d][0] = rr;
					selected[d][1] = cc;
					dfs(d + 1, rr, cc);
					visited[rr][cc] = false;
				}
			}
			flag=true;
			t=selected[0][1];//세로 일자
			for(int i=1;i<3;i++) {
				if(selected[i][1]!=t) flag=false;
			}
			if(flag) {//가로 일자
				if(selected[1][1]-1>=0) {
					int rr=selected[1][0];
					int cc=selected[1][1]-1;
					visited[rr][cc] = true;
					selected[d][0] = rr;
					selected[d][1] = cc;
					dfs(d + 1, rr, cc);
					visited[rr][cc] = false;
				}
				
				if(selected[1][1]+1<M) {
					int rr=selected[1][0];
					int cc=selected[1][1]+1;
					visited[rr][cc] = true;
					selected[d][0] = rr;
					selected[d][1] = cc;
					dfs(d + 1, rr, cc);
					visited[rr][cc] = false;
				}
			}

		}

		for (int i = 0; i < 4; i++) {
			int rr = r + dr[i];
			int cc = c + dc[i];
			if (rr >= 0 && rr < N && cc >= 0 && cc < M && !visited[rr][cc]) {
				visited[rr][cc] = true;
				selected[d][0] = rr;
				selected[d][1] = cc;
				dfs(d + 1, rr, cc);
				visited[rr][cc] = false;
			}
		}
	}
}
