package b3085_사탕게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[][] candy = new char[N][N];
		for (int i = 0; i < N; i++) {
			candy[i] = br.readLine().toCharArray();
		}

		int max = 0;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		for (int i = 0; i < N; i++) {
			max = Math.max(max, getCnt(i, candy, 0));
			max = Math.max(max, getCnt(i, candy, 1));
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char tmp = candy[i][j];
				for (int d = 0; d < 4; d++) {
					int rr = i + dr[d];
					int cc = j + dc[d];
					if (rr >= 0 && rr < N && cc >= 0 && cc < N) {
						char change = candy[rr][cc];
						candy[rr][cc] = tmp;
						candy[i][j] = change;
						int cnt = 0;
						cnt = Math.max(cnt, getCnt(i, candy, 0));
						cnt = Math.max(cnt, getCnt(rr, candy, 0));
						cnt = Math.max(cnt, getCnt(j, candy, 1));
						cnt = Math.max(cnt, getCnt(cc, candy, 1));
						candy[rr][cc] = change;
						candy[i][j] = tmp;
						if (cnt > max)
							max = cnt;
					}
				}
			}
		}
		System.out.println(max);
	}

	private static int getCnt(int n, char[][] map, int rc) {

		int cnt = 1;
		int maxCnt = 0;

		if (rc == 0) {
			for (int i = 0; i < N - 1; i++) {
				if (map[n][i] == map[n][i + 1])
					cnt++;
				else {
					if (cnt > maxCnt)
						maxCnt = cnt;
					cnt = 1;
				}
			}
			if (cnt > maxCnt)
				maxCnt = cnt;
		} else {
			for (int i = 0; i < N - 1; i++) {
				if (map[i][n] == map[i+1][n])
					cnt++;
				else {
					if (cnt > maxCnt)
						maxCnt = cnt;
					cnt = 1;
				}
			}
			if (cnt > maxCnt)
				maxCnt = cnt;
		}

		return maxCnt;
	}

}
