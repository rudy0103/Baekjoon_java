package b1992_쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[][] map = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (tmp[j] == '1')
					map[i][j] = true;
			}
		}

		System.out.println(divideAndConquer(0, 0, N, map));

	}

	private static String divideAndConquer(int r, int c, int len, boolean[][] map) {

		if (len == 2) {
			int cnt = 0;
			String tmp = "";

			for (int i = r; i < r + 2; i++) {
				for (int j = c; j < c + 2; j++) {
					if (map[i][j]) {
						tmp += "1";
						cnt++;
					} else {
						tmp += "0";
					}
				}
			}

			if (cnt == 0)
				return "0";
			else if (cnt == 4)
				return "1";
			else
				return "(" + tmp + ")";
		}

		String tmp = "";

		for (int i = 0; i < 4; i++) {
			int l = len / 2;
			int dr = i / 2;
			int dc = i % 2;

			tmp += divideAndConquer(r + dr * l, c + dc * l, l, map);
		}

		if (tmp.equals("0000"))
			return "0";
		else if (tmp.equals("1111"))
			return "1";
		else
			return "(" + tmp + ")";

	}

}
