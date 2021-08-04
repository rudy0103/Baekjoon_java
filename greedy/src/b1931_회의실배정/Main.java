package b1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] meeting = new int[n][2];
		String[] inp;
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
		});

		int meet = -1;

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			meeting[i][0] = Integer.parseInt(inp[0]);
			meeting[i][1] = Integer.parseInt(inp[1]);
			q.add(meeting[i]);
		}

		int cnt = 0;

		while (!q.isEmpty()) {
			if (q.peek()[0] >= meet) {
				meet = q.poll()[1];
				cnt++;
			} else {
				q.poll();
			}
		}
		System.out.println(cnt);
	}
}
