package b1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int findSet(int x, int[] arr) {
		if (x == arr[x])
			return x;
		else
			return findSet(arr[x], arr);
	}

	public static void union(int a, int b, int[] arr, int[] rank) {
		if (a == b)
			return;

		int setA = findSet(a, arr);
		int setB = findSet(b, arr);
		if (setA == setB)
			return;
		else {
			if (rank[setA] > rank[setB]) {
				arr[setB] = arr[setA];
			} else if (rank[setA] < rank[setB]) {
				arr[setA] = setB;
			}else {
				arr[setA]=setB;
				rank[setB]++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);

		int[] arr = new int[N + 1];
		int[] rank = new int[N + 1];

		for (int i = 0; i <= N; i++)
			arr[i] = i;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 0) {
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), arr, rank);
			} else {
				if (findSet(Integer.parseInt(st.nextToken()), arr) == findSet(Integer.parseInt(st.nextToken()), arr)) {
					sb.append("YES").append("\n");
				} else
					sb.append("NO").append("\n");
			}

		}
		System.out.println(sb.toString());
	}

}
