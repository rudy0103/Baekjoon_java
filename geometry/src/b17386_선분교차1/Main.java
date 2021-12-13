package b17386_선분교차1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x1 = Integer.parseInt(st.nextToken());
		long y1 = Integer.parseInt(st.nextToken());
		long x2 = Integer.parseInt(st.nextToken());
		long y2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long x3 = Integer.parseInt(st.nextToken());
		long y3 = Integer.parseInt(st.nextToken());
		long x4 = Integer.parseInt(st.nextToken());
		long y4 = Integer.parseInt(st.nextToken());

		boolean flag = false;
		if (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) < 0) {
			if (ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) < 0) {
				flag = true;
			}
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
		} else
			return -1;
	}
}
