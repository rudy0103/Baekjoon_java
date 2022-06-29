package b2589_보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String inp = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = inp.charAt(j);
		}

		int max = 0;

		ArrayDeque<int[]> dq = new ArrayDeque<>();

		boolean[][] visited = new boolean[N][M];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'W')
					continue;

				for (int k = 0; k < N; k++)
					Arrays.fill(visited[k], false);

				visited[i][j] = true;
				dq.add(new int[] { i, j, 0 });

				while (!dq.isEmpty()) {

					int[] now = dq.poll();
					max=Math.max(max, now[2]);

					for (int d = 0; d < 4; d++) {
						int nr = now[0] + dr[d];
						int nc = now[1] + dc[d];

						if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'W' || visited[nr][nc])
							continue;

						visited[nr][nc] = true;
						dq.add(new int[] { nr, nc, now[2] + 1 });

					}

				}

			}
		}

		System.out.println(max);

	}

}
