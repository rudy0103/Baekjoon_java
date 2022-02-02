import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int minCnt = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] A = new boolean[N][M];
		boolean[][] B = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] inp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (inp[j] == '1')
					A[i][j] = true;
			}
		}

		for (int i = 0; i < N; i++) {
			char[] inp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (inp[j] == '1')
					B[i][j] = true;
			}
		}

		if (N < 3 || M < 3) {
			if (isSame(A, B, N, M))
				System.out.println(0);
			else
				System.out.println(-1);
		} else {
			f(A, B, N, M);
			System.out.println(minCnt);
		}
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