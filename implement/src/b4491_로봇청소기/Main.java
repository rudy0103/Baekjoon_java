package b4491_로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		do {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			int startR = -1;
			int startC = -1;
			int cnt = 0;
			char[][] map = new char[N][M];

			for (int i = 0; i < N; i++) {
				char[] s = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					map[i][j] = s[j];
					if (map[i][j] == 'o') {
						startR = i;
						startC = j;
					} else if (map[i][j] == '*') {
						map[i][j] = (char) ('0' + cnt);
						cnt++;
					}
				}
			}
			boolean[][][] visited = new boolean[N][M][(int) Math.pow(2, cnt) + 10];

			ArrayDeque<int[]> q = new ArrayDeque<>();

			q.add(new int[] { startR, startC, 0, 0, 0 });
			visited[startR][startC][0] = true;
			int min = -1;
			while (!q.isEmpty()) {
				int[] curr = q.poll();
				if (curr[4] == cnt) {
					min = curr[3];
					break;
				}

				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'x')
						continue;

					if (visited[nr][nc][curr[2]])
						continue;
					if (map[nr][nc] == '.' || map[nr][nc] == 'o') {
						visited[nr][nc][curr[2]] = true;
						q.add(new int[] { nr, nc, curr[2], curr[3] + 1, curr[4] });
					} else {
						if ((curr[2] & 1 << map[nr][nc] - '0') == 0) {
							q.add(new int[] { nr, nc, curr[2] | (1 << map[nr][nc] - '0'), curr[3] + 1, curr[4] + 1 });

						} else {
							q.add(new int[] { nr, nc, curr[2] | (1 << map[nr][nc] - '0'), curr[3] + 1, curr[4] });
						}
						visited[nr][nc][curr[2] | (1 << map[nr][nc] - '0')] = true;
					}
				}
			}
			if (cnt != 0)
				sb.append(min).append("\n");
			else
				sb.append(0).append("\n");
		} while (true);
		System.out.println(sb.toString());
	}
}
