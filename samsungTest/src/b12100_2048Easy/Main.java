package b12100_2048Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int max = 2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int[][] origin = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (N == 1)
			max = origin[0][0];
		else {
			game(0, origin);
		}
		System.out.println(max);

	}

	private static void game(int d, int[][] origin) {
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

		int[][] copy = new int[N][N];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N; j++)
				System.arraycopy(origin[j], 0, copy[j], 0, N);
			move(i, copy);
			game(d + 1, copy);
		}

	}

	private static void move(int d, int[][] copy) {
		int tmp;
		if (d == 0 || d == 1) {// 상 ,하
			int start = d == 0 ? 0 : N - 1;
			int dr = d == 0 ? 1 : -1;
			for (int c = 0; c < N; c++) {
				int rp = start;
				int r = start;
				while (r >= 0 && r < N) {
					if (copy[r][c] == 0) {
						r += dr;
						continue;
					} else {
						tmp = copy[r][c];
					}

					copy[r][c] = 0;
					if (copy[rp][c] == tmp) {
						copy[rp][c] *= 2;
						rp += dr;
					} else if (copy[rp][c] != 0) {
						rp += dr;
						copy[rp][c] = tmp;
					} else {
						copy[rp][c] = tmp;

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
					if (copy[r][c] == 0) {
						c += dc;
						continue;
					} else
						tmp = copy[r][c];
					copy[r][c] = 0;
					if (copy[r][cp] == tmp) {
						copy[r][cp] *= 2;
						cp += dc;
					} else if (copy[r][cp] != 0) {
						cp += dc;
						copy[r][cp] = tmp;
					} else {
						copy[r][cp] = tmp;

					}
					c += dc;
				}

			}
		}
	}

}
