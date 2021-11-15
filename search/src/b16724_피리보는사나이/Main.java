package b16724_피리보는사나이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		int[][] visited = new int[N][M];

		HashMap<Character, Integer> hMap = new HashMap<>();
		hMap.put('U', 0);
		hMap.put('D', 1);
		hMap.put('L', 2);
		hMap.put('R', 3);

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		int cnt = 0;

		ArrayDeque<int[]> q = new ArrayDeque<>();
		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] != 0)
					continue;
				q.clear();
				stack.clear();
				cnt++;
				visited[i][j] = cnt;
				q.add(new int[] { i, j });
				while (!q.isEmpty()) {
					int[] curr = q.poll();
					stack.add(curr);
					int d = hMap.get(map[curr[0]][curr[1]]);
					int nextR = curr[0] + dr[d];
					int nextC = curr[1] + dc[d];
					if (visited[nextR][nextC] == 0) {
						visited[nextR][nextC] = cnt;
						q.add(new int[] { nextR, nextC });
					} else if (visited[nextR][nextC] == cnt) {
						break;
					} else {
						cnt--;
						int group = visited[nextR][nextC];
						while (!stack.isEmpty()) {
							int[] tmp = stack.pop();
							visited[tmp[0]][tmp[1]] = group;
						}
						break;
					}
				}
			}
		}

		System.out.println(cnt);

	}

}
