package b1202_보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] list = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];

			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int[] bag = new int[K];

		for (int i = 0; i < K; i++) {// 가방
			bag[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(bag);

		long totalValue = 0L;

		for (int i = 0, j = 0; i < K; i++) {

			while (j < N && list[j][0] <= bag[i]) {
				pq.add(list[j++][1]);
			}

			if (!pq.isEmpty())
				totalValue += pq.poll();
		}

		System.out.println(totalValue);
	}
}
