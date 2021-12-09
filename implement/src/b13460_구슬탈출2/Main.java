package b13460_구슬탈출2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][][] copy;
	static boolean isPossible = false;
	static int min = 11;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		copy = new char[11][N][M];
		char[][] map = new char[N][M];
		int[] red = new int[2];
		int[] blue = new int[2];

		for (int i = 0; i < N; i++) {
			String inp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = inp.charAt(j);
				if (inp.charAt(j) == 'R') {
					red[0] = i;
					red[1] = j;
				} else if (inp.charAt(j) == 'B') {
					blue[0] = i;
					blue[1] = j;
				}
			}
		}

		simulation(0, map, red, blue);
		if (min<11)
			System.out.println(min);
		else
			System.out.println(-1);

	}

	private static void simulation(int depth, char[][] map, int[] red, int[] blue) {
		if (depth > 10 || blue[0] == -1) {
			return;
		}
		if (red[0] == -1) {
			if (min > depth)
				min = depth;
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[depth][i][j] = map[i][j];
			}
		}
		int[] copiedRed = new int[2];
		copiedRed[0] = red[0];
		copiedRed[1] = red[1];
		int[] copiedBlue = new int[2];
		copiedBlue[0] = blue[0];
		copiedBlue[1] = blue[1];

		for (int d = 0; d < 4; d++) {
			moveBeads(d, map, red, blue);
			if (copiedRed[0] != red[0] || copiedRed[1] != red[1] || copiedBlue[0] != blue[0]
					|| copiedBlue[1] != blue[1]) {
				simulation(depth + 1, map, red, blue);
			} else
				continue;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = copy[depth][i][j];
				}
			}
			red[0] = copiedRed[0];
			red[1] = copiedRed[1];
			blue[0] = copiedBlue[0];
			blue[1] = copiedBlue[1];
		}

	}

	private static void moveBeads(int d, char[][] map, int[] red, int[] blue) {
		// d->0,1,2,3 -->상하좌우

		if (d == 0) {// 상
			if (red[0] < blue[0]) {
				move(map, red, d);
				move(map, blue, d);
			} else {
				move(map, blue, d);
				move(map, red, d);
			}
		} else if (d == 1) {
			if (red[0] > blue[0]) {
				move(map, red, d);
				move(map, blue, d);
			} else {
				move(map, blue, d);
				move(map, red, d);
			}
		} else if (d == 2) {
			if (red[1] < blue[1]) {
				move(map, red, d);
				move(map, blue, d);
			} else {
				move(map, blue, d);
				move(map, red, d);
			}
		} else {
			if (red[1] > blue[1]) {
				move(map, red, d);
				move(map, blue, d);
			} else {
				move(map, blue, d);
				move(map, red, d);
			}
		}
	}

	private static void move(char[][] map, int[] bead, int d) {

		int r = bead[0];
		int c = bead[1];
		char tmp = map[r][c];
		map[r][c] = '.';

		while (true) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (map[nr][nc] == '.') {
				r += dr[d];
				c += dc[d];
			} else if (map[nr][nc] == '#' || map[nr][nc] == 'R' || map[nr][nc] == 'B') {
				map[r][c] = tmp;
				bead[0] = r;
				bead[1] = c;
				break;
			} else {
				bead[0] = -1;
				break;
			}
		}

	}

}
