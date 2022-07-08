package b5014_스타트링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());

		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[F + 1];

		visited[S] = true;

		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { S, 0 });

		int min = -1;

		while (!dq.isEmpty()) {

			int[] now = dq.poll();
			int h = now[0];
			if (h == G) {
				min = now[1];
				break;
			}

			if ( U > 0) {
				if (h + U <= F && visited[h + U] == false) {
					visited[h + U] = true;
					dq.add(new int[] { h + U, now[1] + 1 });
				}

			}
			if (D > 0 && h - D >= 1 && visited[h - D] == false) {
				visited[h - D] = true;
				dq.add(new int[] { h - D, now[1] + 1 });
			}

		}
		if (min == -1) {
			System.out.println("use the stairs");
		} else
			System.out.println(min);

	}

}
