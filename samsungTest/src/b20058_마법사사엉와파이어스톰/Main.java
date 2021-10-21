package b20058_마법사사엉와파이어스톰;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N, Q, L;
	static int size;
	static int[][] map;
	static int[][] copy;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		map = new int[size][size];
		boolean[][] visited = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayDeque<int[]> q = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < Q; i++) {
			L = Integer.parseInt(st.nextToken());
			int s = (int) Math.pow(2, L);
			copy = new int[s][s];
			if (s != 1)
				fireStorm(s);

			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					int cnt = 0;
					if (map[r][c] <= 0)
						continue;
					for (int d = 0; d < 4; d++) {
						int rr = r + dr[d];
						int cc = c + dc[d];

						if (rr >= 0 && rr < size && cc >= 0 && cc < size && map[rr][cc] > 0)
							cnt++;
					}
					if (cnt < 3)
						q.add(new int[] { r, c });

				}
			}
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				map[tmp[0]][tmp[1]]--;
			}
		}

		long ice = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				ice += map[i][j];
			}
		}
		int area = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] > 0 && !visited[i][j]) {
					int cnt = 0;
					visited[i][j] = true;
					q.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] curr = q.poll();
						cnt++;
						for (int d = 0; d < 4; d++) {
							int rr = curr[0] + dr[d];
							int cc = curr[1] + dc[d];

							if (rr >= 0 && rr < size && cc >= 0 && cc < size && map[rr][cc] > 0 && !visited[rr][cc]) {
								visited[rr][cc] = true;
								q.add(new int[] { rr, cc });
							}
						}
					}

					if (cnt > area)
						area = cnt;
				}
			}
		}

		System.out.println(ice);
		if (area == 1)
			System.out.println(0);
		else
			System.out.println(area);

	}

	private static void fireStorm(int len) {
		for (int i = 0; i < size; i += len) {
			for (int j = 0; j < size; j += len) {

				for (int r = 0; r < len; r++) { // copy
					for (int c = 0; c < len; c++) {
						copy[r][c] = map[i + r][j + c];
					}
				}
				for (int r = 0; r < len; r++) { // turn
					for (int c = 0; c < len; c++) {
						map[i + r][j + c] = copy[len - 1 - c][r];
					}
				}

			}
		}

	}

}
