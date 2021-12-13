package b17387_선분교차2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long x3 = Long.parseLong(st.nextToken());
		long y3 = Long.parseLong(st.nextToken());
		long x4 = Long.parseLong(st.nextToken());
		long y4 = Long.parseLong(st.nextToken());

		boolean flag = false;
		int ret1 = ccw(x1, y1, x2, y2, x3, y3);
		int ret2 = ccw(x1, y1, x2, y2, x4, y4);
		int ret3 = ccw(x3, y3, x4, y4, x1, y1);
		int ret4 = ccw(x3, y3, x4, y4, x2, y2);

		if (ret1 == 0) {
			if (check(x1, y1, x2, y2, x3, y3) == 0)
				flag = true;

		}
		if (ret2 == 0) {
			if (check(x1, y1, x2, y2, x4, y4) == 0)
				flag = true;

		}
		if (ret3 == 0) {
			if (check(x3, y3, x4, y4, x1, y1) == 0)
				flag = true;

		}
		if (ret4 == 0) {
			if (check(x3, y3, x4, y4, x2, y2) == 0)
				flag = true;
		}
		if (ret1 * ret2 < 0 && ret3 * ret4 < 0) {
			flag = true;
		}

		if (flag)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {

		long a = x1 * y2 + x2 * y3 + x3 * y1;
		long b = x2 * y1 + x3 * y2 + x1 * y3;

		if (a - b < 0) {
			return 1;
		} else if (a == b) {
			return 0;
		} else
			return -1;
	}

	private static int check(long x1, long y1, long x2, long y2, long x3, long y3) {

		if (x3 >= Math.min(x1, x2) && x3 <= Math.max(x1, x2)) {
			if (y3 >= Math.min(y1, y2) && y3 <= Math.max(y1, y2)) {
				return 0;
			} else
				return 1;
		} else {
			return 1;
		}
	}
}
