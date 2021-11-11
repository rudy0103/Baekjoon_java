package b1826_연료채우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[][] gasStation = new int[N + 1][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			gasStation[i][0] = Integer.parseInt(st.nextToken());
			gasStation[i][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int gas = Integer.parseInt(st.nextToken());
		gasStation[N][0] = L;
		int current = 0;

		Arrays.sort(gasStation, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int cnt = 0;
		boolean flag = true;
		for (int i = 0; i <= N; i++) {
			if (gas < gasStation[i][0] - current) {
				while (!pq.isEmpty() && gas < gasStation[i][0] - current) {
					gas += pq.poll();
					cnt++;
				}
			}
			if (gas < gasStation[i][0] - current) {
				flag = false;
				break;
			}
			gas -= (gasStation[i][0] - current);
			current = gasStation[i][0];
			pq.add(gasStation[i][1]);
		}
		if (flag)
			System.out.println(cnt);
		else
			System.out.println(-1);
	}

}
