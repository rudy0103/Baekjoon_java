package b3055_탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int sR = -1;
		int sC = -1;
		int wR = -1;
		int wC = -1;
		int res = -1;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];

		ArrayDeque<int[]> dq = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '.' || map[i][j] == 'X' || map[i][j] == 'D')
					continue;
				if (map[i][j] == 'S') {
					sR = i;
					sC = j;
					visited[sR][sC] = true;
				} else {
					wR = i;
					wC = j;
					visited[wR][wC] = true;
					dq.add(new int[] { wR, wC, Integer.MIN_VALUE });
				}
			}
		}

		dq.addFirst(new int[] { sR, sC, 0 });
		boolean cont = true;
		while (!dq.isEmpty() && cont) {
			int[] curr = dq.poll();
			int r = curr[0];
			int c = curr[1];
			int time = curr[2];

			for (int i = 0; i < 4; i++) {
				int rr = r + dr[i];
				int cc = c + dc[i];
				if (rr >= 0 && rr < R && cc >= 0 && cc < C && map[rr][cc] != 'X') {
					if (time >= 0) {
						if (visited[rr][cc])
							continue;
						visited[rr][cc] = true;
						if (map[rr][cc] == '.') {
							boolean flag = false;
							for (int d = 0; d < 4; d++) {
								int nr = rr + dr[d];
								int nc = cc + dc[d];
								if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
									if (map[nr][nc] == '*')
										flag = true;
								}

							}

							if (flag)
								continue;
							dq.add(new int[] { rr, cc, time + 1 });

						} else if (map[rr][cc] == 'D') {
							res = time + 1;
							cont = false;
							break;
						}
					} else {
						if (map[rr][cc] == 'D')
							continue;
						if (map[rr][cc] == '*')
							continue;
						visited[rr][cc] = true;
						map[rr][cc] = '*';
						dq.add(new int[] { rr, cc, time + 1 });

					}

				}
			}

		}
		if (res == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(res);

	}

}
