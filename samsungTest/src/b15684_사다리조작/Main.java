package b15684_사다리조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] ladder;
	static int N, M, H, min = 1234;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new int[H + 2][N * 2 + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 행
			int b = Integer.parseInt(st.nextToken()); // 열
			b = b * 2 - 1;
			ladder[a][b] = 1;
			ladder[a][b + 1] = 1;
			ladder[a][b + 2] = 1;
		}

		backtraking(0);
		if (min == 1234)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void backtraking(int d) {

		int flag = 0;

		for (int col = 1; col < N * 2; col += 2) {
			if (col != goingDown(col)) {
				flag++;
			}
		}
		
		if (flag==0) {
			if (d < min)
				min = d;
			return;
		}
		
		if ((3-d)*2<flag||d >= 3 || d > min)
			return;

		for (int r = 1; r <= H; r++) {
			for (int c = 1; c < N * 2 - 1; c += 2) {
				if (ladder[r][c] == 1)
					continue;
				if (ladder[r][c + 2] != 1) {
					ladder[r][c] = 1;
					ladder[r][c + 1] = 1;
					ladder[r][c + 2] = 1;
					backtraking(d + 1);
					ladder[r][c] = 0;
					ladder[r][c + 1] = 0;
					ladder[r][c + 2] = 0;
				}
			}
		}

	}

	private static int goingDown(int col) {
		int c = col;
		int r = 1;
		while (r <= H) {
			if(ladder[r][c]==0) {
				r++;
			}
			else if (ladder[r][c] == 1 && ladder[r][c - 1] == 1) {
				c -= 2;
				r++;
			} else if (ladder[r][c] == 1 && ladder[r][c + 1] == 1) {
				c += 2;
				r++;
			} 
		}

		return c;
	}
}
