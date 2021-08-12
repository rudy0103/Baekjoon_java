package b16935_배열돌리기3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int n, m, r, big;
	public static int[][] arr;
	public static int[][] tmp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void copy(int[][] tmp) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = tmp[i][j];
			}
		}
	}

	public static void print(int[][] tmp) throws IOException {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write((tmp[i][j] + " "));
			}
			bw.write("\n");
		}
	}

	public static void do1() {

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m; j++) {
				tmp[i][j] = arr[n - 1 - i][j];
				tmp[n - 1 - i][j] = arr[i][j];
			}
		}
		copy(tmp);
	}

	public static void do2() {

		for (int c = 0; c < m / 2; c++) {
			for (int r = 0; r < n; r++) {
				tmp[r][c] = arr[r][m - 1 - c];
				tmp[r][m - 1 - c] = arr[r][c];
			}
		}

		copy(tmp);
	}

	public static void do3() {
		int tmp_n = n;
		n = m;
		m = tmp_n;
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				tmp[c][m - 1 - r] = arr[r][c];
			}
		}

		copy(tmp);
	}

	public static void do4() {
		int tmp_n = n;
		n = m;
		m = tmp_n;

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				tmp[n - 1 - c][r] = arr[r][c];
			}
		}
		copy(tmp);
	}

	public static void do5() {

		for (int r = 0; r < n / 2; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp[r][m / 2 + c] = arr[r][c];
			}
		}

		for (int r = 0; r < n / 2; r++) {
			for (int c = m / 2; c < m; c++) {
				tmp[n / 2 + r][c] = arr[r][c];
			}
		}

		for (int r = n / 2; r < n; r++) {
			for (int c = m / 2; c < m; c++) {
				tmp[r][c - m / 2] = arr[r][c];
			}
		}

		for (int r = n / 2; r < n; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp[r - n / 2][c] = arr[r][c];
			}
		}

		copy(tmp);
	}

	public static void do6() {

		for (int r = 0; r < n / 2; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp[r + n / 2][c] = arr[r][c];
			}
		}

		for (int r = 0; r < n / 2; r++) {
			for (int c = m / 2; c < m; c++) {
				tmp[r][c - m / 2] = arr[r][c];
			}
		}

		for (int r = n / 2; r < n; r++) {
			for (int c = m / 2; c < m; c++) {
				tmp[r - n / 2][c] = arr[r][c];
			}
		}

		for (int r = n / 2; r < n; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp[r][c + m / 2] = arr[r][c];
			}
		}

		copy(tmp);
	}

	public static void main(String[] args) throws IOException {

		String[] inp = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		r = Integer.parseInt(inp[2]);

		big = n > m ? n : m;
		arr = new int[big][big];
		tmp = new int[big][big];

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(inp[j]);
		}

		inp = br.readLine().split(" ");

		for (int i = 0; i < inp.length; i++) {
			if (Integer.parseInt(inp[i]) == 1)
				do1();
			else if (Integer.parseInt(inp[i]) == 2)
				do2();
			else if (Integer.parseInt(inp[i]) == 3)
				do3();
			else if (Integer.parseInt(inp[i]) == 4)
				do4();
			else if (Integer.parseInt(inp[i]) == 5)
				do5();
			else if (Integer.parseInt(inp[i]) == 6)
				do6();
		}
		print(arr);
		bw.close();

	}
}
