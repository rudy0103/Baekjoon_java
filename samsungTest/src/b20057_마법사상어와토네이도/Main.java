package b20057_마법사상어와토네이도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, sand;
	static int[][] map;
	static int[][] t = new int[5][5];
	static int[][] tmp = new int[5][5];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { -1, 0, 1, 0 };

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		sand = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int d = 0;
		int step = 1;
		int r = N / 2;
		int c = N / 2;

		int cnt = 1;
		while (step <= N) {
			if (step == N)
				step--;
			for (int i = 0; i < step; i++) {
				r += dr[d];
				c += dc[d];
				if (map[r][c] == 0)
					continue;
				tornado(map[r][c], d, r, c);
			}
			if (r == 0 && c == 0)
				break;

			if (cnt < 2)
				cnt++;
			else {
				step++;
				cnt = 1;
			}
			d++;
			if (d == 4)
				d = 0;
		}

		System.out.println(sand);

	}

	private static void spread(int r, int c) {
		map[r][c] = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (t[i][j] == 0)
					continue;
				int rr = r + (i - 2);
				int cc = c + (j - 2);
				if (rr >= 0 && rr < N && cc >= 0 && cc < N)
					map[rr][cc] += t[i][j];
				else
					sand += t[i][j];
			}
		}
	}

	public static void tornado(int s, int d, int r, int c) {
		for (int i = 0; i < 5; i++)
			Arrays.fill(t[i], 0);
		int remained = s;

		t[0][2] = (int) (s * 0.02);
		t[4][2] = (int) (s * 0.02);

		t[1][1] = (int) (s * 0.1);
		t[3][1] = (int) (s * 0.1);

		t[2][0] = (int) (s * 0.05);

		t[1][2] = (int) (s * 0.07);
		t[3][2] = (int) (s * 0.07);

		t[1][3] = (int) (s * 0.01);
		t[3][3] = (int) (s * 0.01);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				remained -= t[i][j];
		}

		t[2][1] = remained;// 알파

		for (int i = 0; i < d; i++)
			turnT();
		spread(r, c);
	}

	private static void turnT() {// 반시계 회전
		for (int i = 0; i < 5; i++)
			System.arraycopy(t[i], 0, tmp[i], 0, 5);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				t[i][j] = tmp[j][5 - 1 - i];
		}

	}

}
