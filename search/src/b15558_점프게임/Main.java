package b15558_점프게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] left = br.readLine().toCharArray();
		char[] right = br.readLine().toCharArray();

		boolean[][] arr = new boolean[N][2];

		boolean[][] visited = new boolean[N][2];

		for (int i = 0; i < N; i++) {
			if (left[i] == '1')
				arr[i][0] = true;
			if (right[i] == '1')
				arr[i][1] = true;
		}

		boolean clear = false;

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, 0 });// idx, left=0,right=1,time
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			int next = curr[0] + 1;
			int type = curr[1];
			int time = curr[2]+1;

			if (curr[0] >= N || curr[0] + K >= N) {
				clear = true;
				break;
			}

			if (next >= time && !visited[next][type] && arr[next][type]) {
				visited[next][type] = true;
				q.add(new int[] { next, type, time });
			}

			next = curr[0] - 1;

			if ( next >= time && !visited[next][type] && arr[next][type]) {
				visited[next][type] = true;
				q.add(new int[] { next, type, time});
			}

			next = curr[0] + K;
			
			if (curr[1] == 1)
				type = 0;
			else
				type = 1;

			if (next >= time && !visited[next][type] && arr[next][type]) {
				visited[next][type] = true;
				q.add(new int[] { next, type, time });
			}

		}

		if (clear)
			System.out.println(1);
		else
			System.out.println(0);

	}

}
