package b1189_컴백홈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };

	static int[] dc = { 0, 0, -1, 1 };

	static int cnt = 0;
	static int R, C, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		boolean[][] visited = new boolean[R][C];
		char[][] map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String inp = br.readLine();
			for (int j = 0; j < C; j++)
				map[i][j] = inp.charAt(j);
		}
		visited[R - 1][0] = true;

		dfs(map, R - 1, 0, visited, 1);

		System.out.println(cnt);

	}

	private static void dfs(char[][] map, int r, int c, boolean[][] visited, int k) {

		if (r == 0 && c == C - 1) {
			if (k == K)
				cnt++;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 'T') {
				if (visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				dfs(map, nr, nc, visited, k + 1);
				visited[nr][nc] = false;
			}

		}

	}

}
