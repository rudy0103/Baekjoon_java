package b12094_2048Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N;
	static int max = 2;
	static int[][] origin;
	static int[][][] copy;//depth 마다 copy배열을 저장해 메모리 절약 가능

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		origin = new int[N][N];
		copy = new int[11][N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (N == 1)
			max = origin[0][0];
		else {
			game(0);
		}
		System.out.println(max);

	}

	private static void game(int d) {
		if (d > 10) {
			return;
		}

		int tmp = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (origin[r][c] > tmp)
					tmp = origin[r][c];
			}
		}
		if (tmp > max)
			max = tmp;

		if (Math.pow(tmp, 10 - d) < max)
			return;

		for (int j = 0; j < N; j++)
			System.arraycopy(origin[j], 0, copy[d][j], 0, N);

		for (int i = 0; i < 4; i++) {
			move(i);
			game(d + 1);
			for (int j = 0; j < N; j++)
				System.arraycopy(copy[d][j], 0, origin[j], 0, N);
		}

	}

	private static void move(int d) {
		int tmp;
		if (d == 0 || d == 1) {// 상 ,하
			int start = d == 0 ? 0 : N - 1;
			int dr = d == 0 ? 1 : -1;
			for (int c = 0; c < N; c++) {
				int rp = start;
				int r = start;
				while (r >= 0 && r < N) {
					if (origin[r][c] == 0) {
						r += dr;
						continue;
					} else {
						tmp = origin[r][c];
					}

					origin[r][c] = 0;
					if (origin[rp][c] == tmp) {
						origin[rp][c] *= 2;
						rp += dr;
					} else if (origin[rp][c] != 0) {
						rp += dr;
						origin[rp][c] = tmp;
					} else {
						origin[rp][c] = tmp;

					}
					r += dr;
				}

			}
		} else {// 좌 우
			int start = d == 2 ? 0 : N - 1;
			int dc = d == 2 ? 1 : -1;

			for (int r = 0; r < N; r++) {
				int cp = start;
				int c = start;
				while (c >= 0 && c < N) {
					if (origin[r][c] == 0) {
						c += dc;
						continue;
					} else
						tmp = origin[r][c];
					origin[r][c] = 0;
					if (origin[r][cp] == tmp) {
						origin[r][cp] *= 2;
						cp += dc;
					} else if (origin[r][cp] != 0) {
						cp += dc;
						origin[r][cp] = tmp;
					} else {
						origin[r][cp] = tmp;

					}
					c += dc;
				}

			}
		}
	}

}
