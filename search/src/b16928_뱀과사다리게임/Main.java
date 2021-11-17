package b16928_뱀과사다리게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[101];
		boolean[] visited = new boolean[101];

		for (int i = 1; i <= 100; i++)
			arr[i] = i;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 1, 0 });
		visited[1] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == 100) {
				System.out.println(curr[1]);
				break;
			}
			for (int i = 1; i <= 6; i++) {
				if (curr[0] + i > 100 || visited[curr[0] + i])
					continue;
				else {
					visited[curr[0] + i] = true;
					q.add(new int[] { arr[curr[0] + i], curr[1] + 1 });
				}
			}
		}

	}

}
