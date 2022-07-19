package b9466_텀프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N + 1];
			int[] count = new int[N + 1];
			boolean[] visited = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (i == arr[i])
					count[i] = 2;
			}

			for (int i = 1; i <= N; i++) {
				if (count[i] > 1)
					continue;
				dfs(count, arr, arr[i], visited);
			}

			int cnt = 0;

			for (int i = 1; i <= N; i++) {
				if (count[i] < 2)
					cnt++;
			}

			sb.append(cnt).append("\n");

		}
		System.out.println(sb.toString());

	}

	private static boolean dfs(int[] count, int[] arr, int s, boolean[] visited) {
		if (count[s] > 0)
			return false;

		if (visited[s]) {
			return true;
		}

		visited[s] = true;
		boolean f = dfs(count, arr, arr[s], visited);
		if (f && visited[arr[s]]) {
			visited[arr[s]] = false;
			count[s] = 2;
			return true;
		} else
			count[s] = 1;
		return false;

	}

}
