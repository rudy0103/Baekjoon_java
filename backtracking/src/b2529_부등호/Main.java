package b2529_부등호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited = new boolean[10];
	static char[] selected;
	static char[] op;
	static String max = "0";
	static String min = "9999999999";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int K = Integer.parseInt(br.readLine());

		op = new char[K];
		selected = new char[K + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			op[i] = st.nextToken().charAt(0);
		}

		for (int i = 0; i <= 9; i++) {
			selected[0] = (char) (i + '0');
			visited[i] = true;
			backtracking(1, K);
			visited[i] = false;
		}
		System.out.println(max);
		System.out.println(min);
	}

	private static void backtracking(int d, int k) {
		if (d == k + 1) {
			String num = String.copyValueOf(selected);

			if (max.compareTo(num) < 0)
				max = num;
			if (num.compareTo(min) < 0)
				min = num;

			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (visited[i])
				continue;
			if (op[d - 1] == '<') {
				if (i + '0' > selected[d - 1]) {
					visited[i] = true;
					selected[d] = (char) (i + '0');
					backtracking(d + 1, k);
					visited[i] = false;
				}
			} else {
				if (i + '0' < selected[d - 1]) {
					visited[i] = true;
					selected[d] = (char) (i + '0');
					backtracking(d + 1, k);
					visited[i] = false;
				}
			}
		}

	}

}
