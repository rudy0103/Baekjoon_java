package b2798_블랙잭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int max = -1;
	public static int[] arr;
	public static int[] visited;

	public static void bruteForce(int a, int l) {
		if (l == 3) {
			int sum = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == 1)
					sum += arr[i];
			}
			if (sum >= max && sum <= m) {
				max = sum;
			}
		} else {
			for (int i = a + 1; i < arr.length; i++) {
				visited[i] = 1;
				bruteForce(i, l + 1);
				visited[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String[] s = br.readLine().split(" ");
		arr = new int[s.length];
		visited = new int[s.length];
		int i = 0;
		for (String str : s) {
			visited[i] = 0;
			arr[i++] = Integer.parseInt(str);
		}
		for (i = 0; i < arr.length; i++) {
			visited[i] = 1;
			bruteForce(i, 1);
			visited[i] = 0;
		}
		System.out.println(max);
	}

}
