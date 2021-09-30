package b1461_도서관;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		int maxAbs = 0;

		PriorityQueue<Integer> leftQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> rightQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (Math.abs(tmp) > maxAbs) {
				maxAbs = Math.abs(tmp);
			}
			if (tmp < 0)
				leftQ.add(tmp);
			else
				rightQ.add(tmp);
		}

		int distance = 0;

		// 오른쪽 큐 부터
		int dist = 0;
		int cnt = M;
		while (!rightQ.isEmpty()) {
			int tmp = rightQ.poll();
			if (dist < tmp)
				dist = tmp;
			cnt--;
			if (cnt == 0 || rightQ.isEmpty()) {
				cnt = M;
				distance += (dist) * 2;
				dist = 0;
			}
		}

		dist = 0;
		cnt = M;
		while (!leftQ.isEmpty()) {
			int tmp = Math.abs(leftQ.poll());
			if (dist < tmp)
				dist = tmp;
			cnt--;
			if (cnt == 0 || leftQ.isEmpty()) {
				cnt = M;
				distance += (dist) * 2;
				dist = 0;
			}
		}

		System.out.println(distance - maxAbs);

	}

}
