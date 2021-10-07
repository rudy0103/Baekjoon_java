package b14890_경사로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int X = Integer.parseInt(inp[1]);

		int[][] map = new int[N][N];
		int[][] map2 = new int[N][N];
		boolean[] row = new boolean[N];
		boolean[] col = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map2[j][i] = map[i][j];
			}
		}
		visited = new boolean[N][N];
		check(map, row, X);
		visited = new boolean[N][N];
		check(map2, col, X);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!row[i])
				cnt++;
			if (!col[i])
				cnt++;
		}

		System.out.println(cnt);

	}

	private static void check(int[][] map, boolean[] arr, int x) {

		for (int i = 0; i < arr.length; i++) {
			int tmp = map[i][0];
			int cnt = 1;
			for (int c = 1; c < map.length; c++) {
				if (tmp == map[i][c])
					cnt++;
				else if (map[i][c] > tmp) {// 오르막길일 때
					if (map[i][c] - tmp >= 2) {
						arr[i] = true;
						break;
					} else {
						if (cnt >= x) {
							cnt = 1;
							for (int k = 1; k <= x; k++) {
								if (visited[i][c - k] == true) {
									arr[i] = true;
									break;
								} else
									visited[i][c - k] = true;
							}
							tmp = map[i][c];
						} else {
							arr[i] = true;
							break;
						}
					}
				} else {
					cnt = 1;
					tmp = map[i][c];
				}

			}
		}
		check2(map, arr, x);

	}

	private static void check2(int[][] map, boolean[] arr, int x) {
		int len = arr.length;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i])
				continue;
			int tmp = map[i][len - 1];
			int cnt = 1;
			for (int c = len - 2; c >= 0; c--) {
				if (tmp == map[i][c])
					cnt++;
				else if (map[i][c] > tmp) {// 오르막길일 때
					if (map[i][c] - tmp >= 2) {
						arr[i] = true;
						break;
					} else {
						if (cnt >= x) {
							cnt = 1;
							for (int k = 1; k <= x; k++) {
								if (visited[i][c + k] == true) {
									arr[i] = true;
									break;
								} else
									visited[i][c + k] = true;
							}
							tmp = map[i][c];
						} else {
							arr[i] = true;
							break;
						}
					}
				} else {
					cnt = 1;
					tmp = map[i][c];
				}

			}
		}
	}

}
