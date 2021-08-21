package b1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int su = Integer.parseInt(inp[0]);
		int bro = Integer.parseInt(inp[1]);
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { su, 0 });
		int time = -1;
		boolean[] visited = new boolean[100001];
		visited[su] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == bro) {
				time = tmp[1];
				if (tmp[1] == time)
					break;
			}
			if (tmp[0] < bro) {
				if (tmp[0] * 2 <= 100000 && !visited[tmp[0] * 2]) {
					if (tmp[0] * 2 != bro)
						visited[tmp[0] * 2] = true;
					q.add(new int[] { tmp[0] * 2, tmp[1] + 1 });
				}
				if (tmp[0] + 1 <= 100000 && !visited[tmp[0] + 1]) {
					if (tmp[0] + 1 != bro)
						visited[tmp[0] + 1] = true;
					q.add(new int[] { tmp[0] + 1, tmp[1] + 1 });
				}
				if (tmp[0] - 1 >= 0 && !visited[tmp[0] - 1]) {
					if (tmp[0] - 1 != bro)
						visited[tmp[0] - 1] = true;
					q.add(new int[] { tmp[0] - 1, tmp[1] + 1 });
				}

			} else {
				if (tmp[0] - 1 >= 0 && !visited[tmp[0] - 1]) {
					if (tmp[0] - 1 != bro)
						visited[tmp[0] - 1] = true;
					q.add(new int[] { tmp[0] - 1, tmp[1] + 1 });
				}
			}
		}

		System.out.println(time);
	}
}
