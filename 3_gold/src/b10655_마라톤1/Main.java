package b10655_마라톤1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] points = new int[N + 1][2];
		int[] distance = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i][0] = x;
			points[i][1] = y;
		}

		int totalDistance = 0;

		for (int i = 1; i <= N - 2; i++) {
			int d1 = getDistance(points[i], points[i + 1]);
			int d2 = getDistance(points[i + 1], points[i + 2]);
			int d3 = getDistance(points[i], points[i + 2]);
			distance[i + 1] = (d1 + d2) - d3;
			totalDistance += d1;
		}
		totalDistance += getDistance(points[N - 1], points[N]);
		
		int min = Integer.MAX_VALUE;

		for (int i = 2; i <= N - 1; i++) {
			min = Math.min(min, totalDistance - distance[i]);
		}
		System.out.println(min);
	}

	private static int getDistance(int[] p1, int[] p2) {

		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}

}
