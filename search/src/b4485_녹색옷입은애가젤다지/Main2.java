package b4485_녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int tc = 1;
		while (N != 0) {
			int[][] map = new int[N][N];
			boolean[][] visited=new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[2], o2[2]);

				}
			});
			q.add(new int[] { 0, 0, map[0][0] });
			visited[0][0]=true;
			
			while (!q.isEmpty()) {

				int[] tmp = q.poll();
				int r = tmp[0];
				int c = tmp[1];
				if (r == N - 1 && c == N - 1) {
					sb.append("Problem " + tc + ": " + tmp[2]).append("\n");
					break;
				}
				for (int i = 0; i < 4; i++) {
					int rr = r + dr[i];
					int cc = c + dc[i];

					if (rr >= 0 && rr < N && cc >= 0 && cc < N&&visited[rr][cc]!=true) {
						visited[rr][cc]=true;
						q.add(new int[] { rr, cc, tmp[2] + map[rr][cc] });
					}
				}

			}
			tc++;
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb.toString());
	}
}
