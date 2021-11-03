package b2776_암기왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		HashSet<Integer> hset = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			hset.clear();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				hset.add(Integer.parseInt(st.nextToken()));
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				if (hset.contains(Integer.parseInt(st.nextToken()))) {
					sb.append("1\n");
				} else
					sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}

}
