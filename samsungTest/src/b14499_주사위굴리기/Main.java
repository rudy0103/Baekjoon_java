package b14499_주사위굴리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[] dr = { 0, 0, 0, -1, 1 }; // 동서북남
	static int[] dc = { 0, 1, -1, 0, 0 };

	static class Dice {
		int r;
		int c;
		int topNum = 1;
		int northNum = 2;
		int eastNum = 3;
		int[] number;

		public Dice(int x, int y) {
			r = x;
			c = y;
			number = new int[7];
		}

		boolean check(int d) {
			int rr = this.r + dr[d];
			int cc = this.c + dc[d];
			if (rr >= 0 && rr < N && cc >= 0 && cc < M) {
				r = rr;
				c = cc;
				go(d);
				return true;
			}
			return false;
		}

		void go(int d) {
			int tmp = topNum;
			if (d == 1) {// 동
				topNum = opposite(eastNum);
				eastNum = tmp;
			} else if (d == 2) {// 서
				topNum = eastNum;
				eastNum = opposite(tmp);
			} else if (d == 3) {// 북
				topNum = opposite(northNum);
				northNum = tmp;
			} else if (d == 4) {// 남
				topNum = northNum;
				northNum = opposite(tmp);
			}

			if (map[r][c] == 0) {
				map[r][c] = number[opposite(topNum)];
			} else {
				number[opposite(topNum)] = map[r][c];
				map[r][c] = 0;
			}

		}

		int opposite(int n) {
			if (n == 1)
				return 6;
			if (n == 6)
				return 1;
			if (n == 2)
				return 5;
			if (n == 5)
				return 2;
			if (n == 3)
				return 4;
			if (n == 4)
				return 3;
			return 0;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Dice dice = new Dice(x, y);

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < K; i++) {
			if (dice.check(Integer.parseInt(st.nextToken()))) {
				sb.append(dice.number[dice.topNum]).append("\n");
			}
		}
		System.out.println(sb.toString());

	}
}
