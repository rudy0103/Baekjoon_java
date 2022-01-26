package b16933_벽부수고이동하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][][] visited = new int[N][M][K + 1];
		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();

		q.add(new int[] { 0, 0, 0, K, 0 });

		visited[0][0][K] = 0;

		int R = N - 1;
		int C = M - 1;
		int min = Integer.MAX_VALUE;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == R && curr[1] == C) {
				min = Math.min(min, curr[2]);
			}

			for (int d = 0; d < 4; d++) {
				int day = curr[4];
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr > R || nr < 0 || nc > C || nc < 0)
					continue;

				if (map[nr][nc] == '1') {
					if (curr[3] == 0)
						continue;
					if (day == 1 && visited[nr][nc][curr[3] - 1] > curr[2] + 2) {
						visited[nr][nc][curr[3] - 1] = curr[2] + 2;
						q.add(new int[] { nr, nc, curr[2] + 2, curr[3] - 1, 1 });
					} else if (day == 0 && visited[nr][nc][curr[3] - 1] > curr[2] + 1) {
						visited[nr][nc][curr[3] - 1] = curr[2] + 1;
						q.add(new int[] { nr, nc, curr[2] + 1, curr[3] - 1, 1 });
					}
				} else {
					if (visited[nr][nc][curr[3]] <= curr[2] + 1)
						continue;
					if (day == 1) {
						day = 0;
					} else {
						day = 1;
					}
					q.add(new int[] { nr, nc, curr[2] + 1, curr[3], day });
					visited[nr][nc][curr[3]] = curr[2] + 1;
				}

			}

		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min + 1);

	}

}
