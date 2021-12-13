package b14442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		int K = Integer.parseInt(inp[2]);
		char[][] map = new char[N][M];
		boolean[][][] visited = new boolean[N][M][11];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, 1, K });
		visited[0][0][K] = true;
		int res = -1;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == N - 1 && curr[1] == M - 1) {
				res = curr[2];
				break;
			}

			for (int d = 0; d < 4; d++) {
				int r = curr[0] + dr[d];
				int c = curr[1] + dc[d];

				if (r >= 0 && r < N && c >= 0 && c < M) {
					if (map[r][c] == '0' && !visited[r][c][curr[3]]) {
						q.add(new int[] { r, c, curr[2] + 1, curr[3] });
						visited[r][c][curr[3]] = true;
					} else if (map[r][c] == '1' && curr[3] - 1 >= 0 && !visited[r][c][curr[3] - 1]) {
						q.add(new int[] { r, c, curr[2] + 1, curr[3] - 1 });
						visited[r][c][curr[3] - 1] = true;
					}
				}
			}
		}
		System.out.println(res);
	}
}
