package b21939_문제추천시스템Version1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[] problems = new int[100001];

		PriorityQueue<int[]> minQ = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		PriorityQueue<int[]> maxQ = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1])
					return o2[1] - o1[1];
				else
					return o2[0] - o1[0];
			}
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int lv = Integer.parseInt(st.nextToken());
			minQ.add(new int[] { num, lv });
			maxQ.add(new int[] { num, lv });
			problems[num] = lv;
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			if (command.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				int lv = Integer.parseInt(st.nextToken());
				minQ.add(new int[] { num, lv });
				maxQ.add(new int[] { num, lv });
				problems[num] = lv;
			} else if (command.equals("solved")) {
				int num = Integer.parseInt(st.nextToken());
				problems[num] = -1;
			} else {// recommend
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					while (problems[maxQ.peek()[0]] != maxQ.peek()[1]) {
						maxQ.poll();
					}
					int num = maxQ.peek()[0];
					sb.append(num).append("\n");
				} else {
					while (problems[minQ.peek()[0]] != minQ.peek()[1]) {
						minQ.poll();
					}
					int num = minQ.peek()[0];
					sb.append(num).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
