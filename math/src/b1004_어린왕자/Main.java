package b1004_어린왕자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			Point[] points = new Point[2];

			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			points[0] = new Point(startX, startY);
			int distX = Integer.parseInt(st.nextToken());
			int distY = Integer.parseInt(st.nextToken());

			points[1] = new Point(distX, distY);
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				int pass = 0;
				st=new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				if (isIn(points[0], x, y, r))
					pass++;
				if (isIn(points[1], x, y, r))
					pass++;

				if (pass == 1)
					cnt++;

			}
			sb.append(cnt).append("\n");

		}
		System.out.println(sb.toString());

	}

	private static boolean isIn(Point point, int x, int y, int r) {

		double dist = Math.abs(point.x - x) * Math.abs(point.x - x) + Math.abs(point.y - y) * Math.abs(point.y - y);
		dist = Math.sqrt(dist);

		if (dist < r)
			return true;

		return false;
	}

}
