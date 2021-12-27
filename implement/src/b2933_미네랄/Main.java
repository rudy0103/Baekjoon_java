package b2933_미네랄;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] groups;
	static int R, C;
	static int[] height = new int[10001];
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		groups = new int[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = R - Integer.parseInt(st.nextToken());
		}

		simulation(map, arr, N);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void simulation(char[][] map, int[] arr, int n) {
		int len = arr.length;
		int[] dc = { 1, -1 };

		for (int i = 0; i < len; i++) {
			int dir = i % 2;
			int r = arr[i];
			int c = -1;
			if (dir == 0)
				c = 0;
			else
				c = C - 1;
			// 1. 막대기를 던져 미네랄을 깬다.
			boolean hit = false;

			while (c >= 0 && c < C && map[r][c] == '.') {
				c += dc[dir];
			}
			if (c >= 0 && c < C)
				hit = true;
			if (hit == false)
				continue;

			map[r][c] = '.';
			bfs(map, r, c);

		}
	}

	private static void bfs(char[][] map, int r, int c) {
		if (r == 0)
			return;

		q.clear();
		Arrays.fill(height, -1);

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		for (int i = 0; i < R; i++) {
			Arrays.fill(groups[i], 0);
		}

		int g = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'x' && groups[i][j] == 0) {
					g++;
					height[g] = 1234;
					groups[i][j] = g;
					q.add(new int[] { i, j });

					while (!q.isEmpty()) {
						int curr[] = q.poll();

						for (int d = 0; d < 4; d++) {
							int rr = curr[0] + dr[d];
							int cc = curr[1] + dc[d];

							if (rr < 0 || rr >= R || cc < 0 || cc >= C || map[rr][cc] == '.' || groups[rr][cc] != 0)
								continue;
							groups[rr][cc] = g;
							q.add(new int[] { rr, cc });
						}
					}

				}
			}
		}
		for (int j = 0; j < C; j++) {
			int group = groups[R - 1][j];
			if (group == 0)
				continue;
			height[group] = 0;
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int group = groups[i][j];
				if (group == 0)
					continue;
				if (height[group] == 0) {
					continue;
				}
				int tmpR = i;
				while (tmpR + 1 < R && (map[tmpR + 1][j] == '.' || groups[tmpR + 1][j] == group)) {
					tmpR++;
				}
				if (groups[tmpR][j] == groups[i][j])
					continue;
				else {
					height[group] = Math.min(height[group], tmpR - i);
				}
			}
		}

		/////// bfs end
		int targetG = -1;
		for (int i = 1; i <= g; i++) {
			if (height[i] == -1)
				break;
			if (height[i] == 0)
				continue;
			if (height[i] > 0) {
				targetG = i;
				break;
			}
		}

		if (targetG == -1)
			return;
		int h = height[targetG];
		for (int row = R - 1; row >= 0; row--) {
			for (int col = 0; col < C; col++) {
				if (groups[row][col] == targetG) {
					map[row + h][col] = map[row][col];
					map[row][col] = '.';
				}
			}
		}

	}
}
