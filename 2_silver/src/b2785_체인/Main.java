package b2785_체인;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		LinkedList<Long> dq = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			dq.add(Long.parseLong(st.nextToken()));
		}
		Collections.sort(dq);

		int cnt = 0;

		while (dq.size()>1) {

			long n = dq.poll();
			n--;
			cnt++;
			if (n > 0)
				dq.addFirst(n);
			if (dq.size() <= 2) {
				break;
			} else {
				long a = dq.pollLast();
				long b = dq.pollLast();
				dq.add(a + b);
			}
		}
		System.out.println(cnt);
	}
}
