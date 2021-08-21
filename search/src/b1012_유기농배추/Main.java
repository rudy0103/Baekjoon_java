package b1012_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = { -1, 1, 0, 0, };
	static int[] dc = { 0, 0, -1, 1 };

	public static void bfs(int r, int c, int[][] map, boolean[][] visited, int[] worm) {

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c });
		visited[r][c] = true;
		worm[0]++;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int d = 0; d < 4; d++) {
				int rr = tmp[0] + dr[d];
				int cc = tmp[1] + dc[d];
				if (rr >= 0 && rr < map.length && cc >= 0 && cc < map[0].length && map[rr][cc] == 1
						&& !visited[rr][cc]) {
					visited[rr][cc] = true;
					q.add(new int[] { rr, cc });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] inp = br.readLine().split(" ");
			int N = Integer.parseInt(inp[1]);
			int M = Integer.parseInt(inp[0]);
			int K = Integer.parseInt(inp[2]);
			int[] worm = { 0 };
			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			while (K-- > 0) {
				inp = br.readLine().split(" ");
				map[Integer.parseInt(inp[1])][Integer.parseInt(inp[0])] = 1;
			}

			for (int r = 0; r < N; r++)
				for (int c = 0; c < M; c++)
					if (map[r][c] == 1 && !visited[r][c])
						bfs(r, c, map, visited, worm);
			sb.append(worm[0]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
