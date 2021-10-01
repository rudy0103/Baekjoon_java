package b17143_낚시왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.sound.midi.Soundbank;

public class Main {
	static int R, C;
	static int[][] dir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][][] before = new int[R + 1][C + 1][3];
		int[][][] after = new int[R + 1][C + 1][3];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			before[r][c][0] = Integer.parseInt(st.nextToken());// 속도
			before[r][c][1] = Integer.parseInt(st.nextToken());// 방향
			before[r][c][2] = Integer.parseInt(st.nextToken());// 크기
			if (before[r][c][1] == 1 || before[r][c][1] == 2)
				before[r][c][0] %= (2 * (R - 1));// 속도 조절
			if (before[r][c][1] == 3 || before[r][c][1] == 4)
				before[r][c][0] %= (2 * (C - 1));// 속도 조절
		}

		int total = 0;
		for (int i = 1; i <= C; i++) { // 낚시왕이 가장 끝에 갈 때 까지
			total += fishing(i, before,after);
		}
		System.out.println(total);
	}

	private static int fishing(int f, int[][][] before,int[][][] after) {
		int res = 0;
		
		for (int i = 1; i <= R; i++)
			for (int j = 1; j <= C; j++)
				for(int k=0;k<3;k++)
					after[i][j][k]=0;

		for (int r = 1; r <= R; r++) { // 낚시왕이 상어를 잡음
			if (before[r][f][2] != 0) {
				res = before[r][f][2]; // 상어 크기 저장
				before[r][f][0] = 0; // 상어 없앰
				before[r][f][1] = 0;
				before[r][f][2] = 0;
				break;
			}
		}


		for (int i = 1; i <= R; i++) { 
			for (int j = 1; j <= C; j++) {
				if (before[i][j][2] != 0) {

					int r = i;
					int c = j;
					int move = before[i][j][0];
					int d = before[i][j][1];

					int rr = r;
					int cc = c;

					while (move > 0) {
						move--;
						rr += dir[d][0];
						cc += dir[d][1];
						if (rr < 1 || rr > R || cc < 1 || cc > C) {
							d = changeDir(d);
							rr += dir[d][0] * 2;
							cc += dir[d][1] * 2;
						}
					}

					if (after[rr][cc][2] < before[i][j][2]) {
						after[rr][cc][0] = before[i][j][0];
						after[rr][cc][1] = d;
						after[rr][cc][2] = before[i][j][2];
					}

				}
			}
		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				before[i][j][0] = after[i][j][0];
				before[i][j][1] = after[i][j][1];
				before[i][j][2] = after[i][j][2];
			}
		}
		return res; // 잡은 상어 크기 리턴
	}

	private static int changeDir(int i) {
		if (i == 1)
			return 2;
		if (i == 2)
			return 1;
		if (i == 3)
			return 4;
		if (i == 4)
			return 3;
		return i;
	}
}
