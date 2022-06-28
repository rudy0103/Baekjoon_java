package b2166_다각형의면접;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static class Point {
		long x;
		long y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y);
		}
		long res = 0;
		for (int i = 1; i < N - 1; i++) {
			res += ccw(points[0], points[i], points[i + 1]);
		}

		res = Math.abs(res);
		if (res % 2 == 0) {
			System.out.println(res / 2 + ".0");
		} else
			System.out.println(res / 2 + ".5");
	}

	public static long ccw(Point p1, Point p2, Point p3) {
		return ((p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y)) - ((p1.y * p2.x) + (p2.y * p3.x) + (p3.y * p1.x));

	}

}