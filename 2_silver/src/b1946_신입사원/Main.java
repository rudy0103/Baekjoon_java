package b1946_신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			int[] scores = new int[N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int s1 = Integer.parseInt(st.nextToken());
				int s2 = Integer.parseInt(st.nextToken());
				scores[s1] = s2;
			}
			int cnt = N;
			int cut = scores[1];

			for (int i = 2; i <= N; i++) {
				if (scores[i] > cut) {
					cnt--;
				} else
					cut = scores[i];
			}

			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());

	}

}
