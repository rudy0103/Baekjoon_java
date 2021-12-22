package b9376_탈옥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int H, W;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			LinkedList<int[]> target = new LinkedList<>();
			for (int i = 0; i < H; i++) {
				String inp = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = inp.charAt(j);
					if (map[i][j] == '$') {
						target.add(new int[] { i, j, 0 });
					}
				}
			}

			min = 0;
			min += simulation(target.get(0), map);
			min += simulation(target.get(1), map);



		}
		System.out.println(sb.toString());
	}

	private static int simulation(int[] target, char[][] map) {

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		pq.add(new int[] { target[0], target[1], 0 });
		boolean visited[][] = new boolean[H][W];
		visited[target[0]][target[1]] = true;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			for (int d = 0; d < 4; d++) {
				int rr = curr[0] + dr[d];
				int cc = curr[1] + dc[d];

				if (rr < 0 || rr >= H || cc < 0 && cc >= W)
					return curr[2];
				if (visited[rr][cc] || map[rr][cc] == '*')
					continue;
				visited[rr][cc] = true;
				if (map[rr][cc] == '#')
					pq.add(new int[] { rr, cc, curr[2] + 1 });
				else
					pq.add(new int[] { rr, cc, curr[2] });
			}

		}

		return 0;
	}

	

//	private static void printMap(int[][] visitedA2) {
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
//		for (int i = 0; i < visitedA2.length; i++) {
//			for (int j = 0; j < visitedA2[i].length; j++) {
//				if (visitedA2[i][j] >= 123456789)
//					System.out.print(0 + " ");
//				else
//					System.out.print(visitedA2[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

}
