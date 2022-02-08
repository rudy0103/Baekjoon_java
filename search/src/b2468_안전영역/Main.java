package b2468_안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int maxCnt = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		HashSet<Integer> set = new HashSet<>();
		set.add(0);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				set.add(map[i][j]);
			}
		}

		for (int n : set) {

			int res = bfs(map, n, new boolean[N][N]);
			maxCnt = Math.max(res, maxCnt);
		}

		System.out.println(maxCnt);
	}

	private static int bfs(int[][] map, int n, boolean[][] visited) {

		int cnt = 0;
		int len = visited.length;

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		ArrayDeque<int[]> dq = new ArrayDeque<>();

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (visited[i][j] || map[i][j] <= n)
					continue;
				cnt++;
				dq.add(new int[] { i, j });

				while (!dq.isEmpty()) {
					int [] curr=dq.poll();
					
					
					for(int d=0;d<4;d++) {
						int nr=curr[0]+dr[d];
						int nc=curr[1]+dc[d];
						
						
						if(nr<0||nr>=len||nc<0||nc>=len||visited[nr][nc]||map[nr][nc]<=n) continue;
						visited[nr][nc]=true;
						dq.add(new int[] {nr,nc});
						
					}
					
				}

			}
		}

		return cnt;
	}

}
