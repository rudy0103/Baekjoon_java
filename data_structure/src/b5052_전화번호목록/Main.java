package b5052_전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		LinkedList<String> list = new LinkedList<>();

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(br.readLine());
			}
			Collections.sort(list);

			String before = list.poll();
			boolean flag = false;

			while (!list.isEmpty()) {
				String next = list.poll();
				if (next.length() <= before.length()) {
					before = next;
					continue;
				}
				if (next.substring(0,before.length()).equals((before))) {
					flag = true;
					break;
				} else
					before = next;
			}

			if (flag)
				sb.append("NO\n");
			else
				sb.append("YES\n");
			
		}
		System.out.println(sb.toString());
	}
}
