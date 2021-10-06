package b2239_스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void printMap(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean promising(int num, int r, int c, int[][] map) {

		for (int i = 0; i < 9; i++) {
			if (map[r][i] == num)
				return false;
			if (map[i][c] == num)
				return false;
		}

		int rr = r / 3;
		int cc = c / 3;

		for (int i = 3 * rr; i < 3 * rr + 3; i++)
			for (int j = 3 * cc; j < 3 * cc + 3; j++)
				if (map[i][j] == num)
					return false;

		return true;
	}

	public static void backtracking(int depth, int[][] map, int end, ArrayList<int[]> zeroList) {
		if (depth == end) {
			printMap(map);
			System.exit(0);
		}
		int r = zeroList.get(depth)[0];
		int c = zeroList.get(depth)[1];
		for (int i = 1; i <= 9; i++) {
			if (promising(i, r, c, map)) {
				map[r][c] = i;
				backtracking(depth + 1, map, end, zeroList);
				map[r][c] = 0;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int[][] map = new int[9][9];
		int cnt = 0;

		ArrayList<int[]> zeroList = new ArrayList<int[]>();
		for (int i = 0; i < 9; i++) {
			String inp=br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = inp.charAt(j)-'0';
				if (map[i][j] == 0) {
					cnt++;
					zeroList.add(new int[] { i, j });
				}
			}
		}
		backtracking(0, map, cnt, zeroList);
	}
}
