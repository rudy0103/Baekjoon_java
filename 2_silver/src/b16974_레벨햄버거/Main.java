package b16974_레벨햄버거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long X = Long.parseLong(st.nextToken());
		long[][] mm = new long[N + 1][2];
		mm[0][1] = 1;
		mm[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			mm[i][0] = mm[i - 1][0] * 2 + 3;
			mm[i][1] = mm[i - 1][1] * 2 + 1;
		}

		recursive(N, X, mm);

		System.out.println(cnt);

	}

	private static void recursive(int n, long x, long[][] mm) {
		if (x == 0) {
			return;
		} else if (n == 0) {
			cnt++;
			return;
		}
		x--;
		if (x == mm[n - 1][0]) {
			cnt += mm[n - 1][1];
			x -= mm[n - 1][0];
			recursive(n - 1, x, mm);
		} else if (x < mm[n - 1][0]) {
			recursive(n - 1, x, mm);
		} else if (x > mm[n - 1][0]) {
			cnt += mm[n - 1][1] + 1;
			x -= (mm[n - 1][0] + 1);
			recursive(n - 1, x, mm);
		}
	}
}
