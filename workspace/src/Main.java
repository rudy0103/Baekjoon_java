import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int n, m, k, min;
	public static int[][] arr;
	public static int[][] tmp;
	// 반시계 하우상좌
	public static int[] dr = { 1, 0, -1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };

	public static void rotate(int r, int c, int bottom_r, int right_c) {

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
		arr[r + 1][c] = tmp;
		
		rotate(r+1, c+1, bottom_r, right_c);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inp = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		k = Integer.parseInt(inp[2]);

		arr = new int[n][m];
		tmp = new int[n][m];
		min = (n < m ? n : m) / 2 - 1;
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < inp.length; j++)
				arr[i][j] = Integer.parseInt(inp[j]);
		}

		for (int i = 0; i < k; i++) {
			inp = br.readLine().split(" ");
			int r = Integer.parseInt(inp[0]);
			int c = Integer.parseInt(inp[1]);
			int s = Integer.parseInt(inp[2]);
			rotate(r - s, c - s, r + s, c + s);
		}

		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				bw.write(arr[i][j] + " ");
			bw.write("\n");
		}
		bw.close();
	}
}
