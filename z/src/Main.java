import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int minCnt = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String A="CABADSA";
		String B="BBSADAS";
		System.out.println(A.compareTo(B));
	}

	private static void f(boolean[][] a, boolean[][] b, int N, int M) {

		if (isSame(a, b, N, M)) {
			minCnt = 0;
			return;
		}
		int cnt = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (a[i][j] != b[i][j]) {
					change(i, j, a);
					cnt++;
					if (isSame(a, b, N, M)) {
						minCnt = cnt;
						return;
					}
				}
			}
		}

	}

	private static void change(int i, int j, boolean[][] a) {

		for (int r = i; r < i + 3; r++) {
			for (int c = j; c < j + 3; c++) {
				if (a[r][c])
					a[r][c] = false;
				else
					a[r][c] = true;
			}
		}

	}

	private static boolean isSame(boolean[][] a, boolean[][] b, int N, int M) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] != b[i][j])
					return false;
			}
		}

		return true;
	}

}