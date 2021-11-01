package b9019_DSLR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class DSLR {
		int n;
		String op;

		public DSLR(int n, String op) {
			super();
			this.n = n;
			this.op = op;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[10001];

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			ArrayDeque<DSLR> dq = new ArrayDeque<>();
			dq.add(new DSLR(A, ""));
			visited[A] = true;
			while (!dq.isEmpty()) {
				DSLR one = dq.poll();

				// D
				int tmp = (one.n * 2) % 10000;
				if (tmp == B) {
					sb.append(one.op + "D\n");
					break;
				} else {
					if (!visited[tmp]) {
						visited[tmp] = true;
						dq.add(new DSLR(tmp, one.op + "D"));
					}
				}

				// S
				
				if (one.n == 0)
					tmp = 9999;
				else 
					tmp = one.n - 1;
				if (tmp == B) {
					sb.append(one.op + "S\n");
					break;
				} else {
					if (!visited[tmp]) {
						visited[tmp] = true;
						dq.add(new DSLR(tmp, one.op + "S"));
					}
				}

				// L
				int x = one.n / 1000;
				tmp = (one.n % 1000) * 10 + x;
				if (tmp == B) {
					sb.append(one.op + "L\n");
					break;
				} else {
					if (!visited[tmp]) {
						visited[tmp] = true;
						dq.add(new DSLR(tmp, one.op + "L"));
					}
				}

				// R
				x = one.n % 10;
				tmp = (one.n / 10) + x * 1000;
				if (tmp == B) {
					sb.append(one.op + "R\n");
					break;
				} else {
					if (!visited[tmp]) {
						visited[tmp] = true;
						dq.add(new DSLR(tmp, one.op + "R"));
					}
				}

			}
			Arrays.fill(visited, false);

		}

		System.out.println(sb.toString());
	}

}
