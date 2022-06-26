package b17136_색종이붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int min = 123;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] arr = new boolean[10][10];
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				if (st.nextToken().equals("1")) {
					arr[i][j] = true;
					sum++;
				}

			}
		}

		dfs(arr, 0, 0, 0, new int[6], sum);
		if (min != 123)
			System.out.println(min);
		else
			System.out.println("-1");

	}

	private static void dfs(boolean[][] arr, int r, int c, int cnt, int[] papers, int sum) {

		if (sum == 0 || (r >= 9 && c > 9)) {
			min = Math.min(min, cnt);
			return;
		}

		if (cnt >= min)
			return;
		
		if(c>9&&r+1<=9) {
			dfs(arr, r+1, 0, cnt, papers, sum);
			return;
		}

		if (arr[r][c]) {
			for (int l = 5; l >= 1; l--) {
				if (promising(arr, r, c, l, papers)) {
					toggle(arr, r, c, l);
					papers[l]++;
					dfs(arr, r, c+1, cnt + 1, papers, sum-l*l);
					papers[l]--;
					toggle(arr, r, c, l);
				}
			}
		} else {
			if (c + 1 <= 9)
				dfs(arr, r, c + 1, cnt, papers, sum);
			else
				dfs(arr, r + 1, 0, cnt, papers, sum);
		}

	}



	private static void toggle(boolean[][] arr, int r, int c, int l) {

		for (int i = r; i < r + l; i++) {
			for (int j = c; j < c + l; j++) {
				arr[i][j] = !arr[i][j];
			}
		}

	}

	private static boolean promising(boolean[][] arr, int r, int c, int l, int[] counts) {

		if (counts[l] >= 5)
			return false;
		if (r + l > 10 || c + l > 10)
			return false;

		for (int i = r; i < r + l; i++) {
			for (int j = c; j < c + l; j++) {
				if (arr[i][j] == false)
					return false;
			}
		}

		return true;
	}

}
