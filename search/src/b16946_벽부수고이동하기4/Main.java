package b16946_벽부수고이동하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	static ArrayDeque<int[]> q = new ArrayDeque<>();
	static ArrayDeque<int[]> q2 = new ArrayDeque<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M;
	static int group = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] inp = br.readLine().split(" ");

		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		int[][] origin = new int[N][M];
		int[][] visited = new int[N][M];
		int[][] canGo = new int[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				origin[i][j] = tmp.charAt(j) - '0';
				canGo[i][j] = origin[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (origin[i][j] == 0 && visited[i][j] == 0) {
					group++;
					bfs(i, j, origin, visited, canGo);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (origin[i][j] == 0)
					sb.append("0");
				else
					sb.append(canGo[i][j] % 10);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void bfs(int i, int j, int[][] origin, int[][] visited, int[][] canGo) {

		q.add(new int[] { i, j });

		visited[i][j] = group;
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			cnt++;

			for (int d = 0; d < 4; d++) {
				int rr = r + dr[d];
				int cc = c + dc[d];
				if (rr >= 0 && rr < N && cc >= 0 && cc < M && visited[rr][cc] != group) {
					visited[rr][cc] = group;
					if (origin[rr][cc] == 0)
						q.add(new int[] { rr, cc });
					else
						q2.add(new int[] { rr, cc });
				}
			}

		}
		while (!q2.isEmpty()) {
			int[] tmp = q2.poll();
			canGo[tmp[0]][tmp[1]] += cnt;
		}

	}

}
