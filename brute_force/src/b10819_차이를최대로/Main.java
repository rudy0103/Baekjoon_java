package b10819_차이를최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int[] selected, arr;
	public static boolean[] visited;
	public static int max, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		selected = new int[N];
		arr = new int[N];
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		permutation(0);

		System.out.println(max);

	}

	private static void permutation(int d) {
		if (d == N) {
			int tmp = 0;

			for (int i = 1; i < N; i++) {
				tmp += Math.abs(selected[i] - selected[i - 1]);
			}
			if (tmp > max) {
				max = tmp;
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			selected[d] = arr[i];
			permutation(d + 1);
			visited[i] = false;
		}

	}

}
