package b8983_사냥꾼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int M, N, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = 0;

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		int[] lines = new int[M];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++)
			lines[i] = Integer.parseInt(st.nextToken());
		// 사대 정렬

		Arrays.sort(lines);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int idx = Arrays.binarySearch(lines, x);

			if (idx >= 0) {
				if (y <= L) {
					cnt++;
				}
			} else {
				int tmp = -idx - 1;
				if (getDistance(tmp, lines, x,y)) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);

	}

	private static boolean getDistance(int tmp, int[] lines, int x,int y) {

		if (tmp < M) {
			if (Math.abs(lines[tmp] - x) + y <= L)
				return true;
		}

		if (tmp - 1 >= 0) {
			if (Math.abs(lines[tmp - 1] - x) + y <= L)
				return true;
		}

		return false;
	}

}
