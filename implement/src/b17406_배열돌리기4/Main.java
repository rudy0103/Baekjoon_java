package b17406_배열돌리기4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int n, m, k;
	public static int[][] origin;
	public static int[][] selected;
	public static int[][] command;
	public static boolean[] isSelected;
	public static int min = Integer.MAX_VALUE;

	public static int[] dr = { 1, 0, -1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };

	public static void makePermutaion(int cnt) throws IOException {
		if (cnt == k) {
			int[][] arr = new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					arr[i][j] = origin[i][j];
			}

			for (int i = 0; i < k; i++) {
				int r = selected[i][0];
				int c = selected[i][1];
				int s = selected[i][2];
				rotate(r - s, c - s, r + s, c + s, arr);
			}

			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < m; j++)
					sum += arr[i][j];
				min = sum < min ? sum : min;
			}
		} else {
			for (int i = 0; i < k; i++) {
				if (isSelected[i])
					continue;
				isSelected[i] = true;
				selected[cnt] = command[i];
				makePermutaion(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	public static void rotate(int r, int c, int bottom_r, int right_c, int[][] arr) {
		if (r == bottom_r || c == right_c) {
			return;
		} else {
			int tmp = arr[r][c];
			int dir = 0;
			int before_r = r;
			int before_c = c;
			int next_r = -1;
			int next_c = -1;

			while (dir <= 3) {
				if (before_r + dr[dir] >= r && before_r + dr[dir] <= bottom_r && before_c + dc[dir] >= c
						&& before_c + dc[dir] <= right_c) {
					next_r = before_r + dr[dir];
					next_c = before_c + dc[dir];
					arr[before_r][before_c] = arr[next_r][next_c];
					before_r = next_r;
					before_c = next_c;
				} else {
					dir++;
				}

			}
			arr[r][c + 1] = tmp;
			rotate(r + 1, c + 1, bottom_r - 1, right_c - 1, arr);
		}
	}

	public static void main(String[] args) throws IOException {

		String[] inp = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		k = Integer.parseInt(inp[2]);

		origin = new int[n][m];
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < inp.length; j++)
				origin[i][j] = Integer.parseInt(inp[j]);
		}
		isSelected = new boolean[k];
		command = new int[k][3];
		selected = new int[k][3];

		for (int i = 0; i < k; i++) {
			inp = br.readLine().split(" ");
			command[i][0] = Integer.parseInt(inp[0]) - 1;
			command[i][1] = Integer.parseInt(inp[1]) - 1;
			command[i][2] = Integer.parseInt(inp[2]);
		}
		
		makePermutaion(0);
		bw.write(min + "\n");
		bw.close();
	}
}
