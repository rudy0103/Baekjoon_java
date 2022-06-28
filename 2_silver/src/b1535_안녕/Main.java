package b1535_안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] pleasure = new int[N];
		for (int i = 0; i < N; i++)
			pleasure[i] = Integer.parseInt(st.nextToken());

		dfs(arr, pleasure, 0, 100, 0, 0);

		System.out.println(max);
	}

	private static void dfs(int[] arr, int[] pleasure, int d, int hp, int sum, int start) {
		if (d >= N) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = start; i < N; i++) {

			if (hp - arr[i] > 0) {
				max = Math.max(max, sum + pleasure[i]);
				dfs(arr, pleasure, d, hp - arr[i], sum + pleasure[i], i + 1);
			}

		}

	}

}
