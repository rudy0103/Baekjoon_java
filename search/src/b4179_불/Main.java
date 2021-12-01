package b4179_불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		boolean flag = false;
		int res = -1;
		int[][] time = new int[R + 2][C + 2];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int startR = -1;
		int startC = -1;

		ArrayDeque<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < row.length(); j++) {
				char tmp = row.charAt(j);
				if (tmp == '#') {
					time[i + 1][j + 1] = -1;
				} else if (tmp == '.') {
					time[i + 1][j + 1] = 99999999;
				} else if (tmp == 'F') {
					q.add(new int[] { i + 1, j + 1, 0 });
				} else {
					startR = i + 1;
					startC = j + 1;
					time[i + 1][j + 1] = 99999999;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int d = 0; d < 4; d++) {
				int rr = r + dr[d];
				int cc = c + dc[d];
				if (rr > 0 && rr < R + 1 && cc > 0 && cc < C + 1 && time[rr][cc] == 99999999) {
					q.add(new int[] { rr, cc, tmp[2] + 1 });
					time[rr][cc] = tmp[2] + 1;
				}
			}

		}

		q.add(new int[] { startR, startC, 0 });

		while (flag == false && !q.isEmpty()) {
			int[] jihun = q.poll();
			int r = jihun[0];
			int c = jihun[1];

			for (int d = 0; d < 4; d++) {
				int rr = r + dr[d];
				int cc = c + dc[d];
				if (rr >= 0 && rr <= R + 1 && cc >= 0 && cc <= C + 1) {

					if (rr == 0 || cc == 0 || rr == R + 1 || cc == C + 1) {
						flag = true;
						res = jihun[2] + 1;
						break;
					}
					if (time[rr][cc] > jihun[2] + 1) {
						q.add(new int[] { rr, cc, jihun[2] + 1 });
						time[rr][cc] = -1;
					}

				}
			}
		}

		if (flag)
			System.out.println(res);
		else
			System.out.println("IMPOSSIBLE");

	}

}
