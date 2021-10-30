package b2638_치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int totalCnt = 0;
		int time = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					totalCnt++;
			}
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();

		while (totalCnt > 0) {

			q.add(new int[] { 0, 0 });
			int meltCnt = 0;

			while (!q.isEmpty()) {
				int[] curr = q.poll();

				for (int i = 0; i < 4; i++) {
					int rr = curr[0] + dr[i];
					int cc = curr[1] + dc[i];

					if (rr >= 0 && rr < N && cc >= 0 && cc < M) {
						if (map[rr][cc] > 0) {
							map[rr][cc]++;
						} else if (!visited[rr][cc]) {
							visited[rr][cc] = true;
							q.add(new int[] { rr, cc });
						}
					}
				}

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					visited[i][j] = false;
					if (map[i][j] == 0)
						continue;
					if (map[i][j] >= 3) {
						meltCnt++;
						map[i][j] = 0;
					} else
						map[i][j] = 1;
				}
			}
			totalCnt -= meltCnt;
			time++;
		}
		System.out.println(time);

	}

}
