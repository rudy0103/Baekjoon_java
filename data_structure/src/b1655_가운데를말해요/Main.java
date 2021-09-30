package b1655_가운데를말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> leftQ = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});

		PriorityQueue<Integer> rightQ = new PriorityQueue<Integer>();

		int leftMid = Integer.MAX_VALUE;
		int rightMid = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(br.readLine());

			if (tmp <= leftMid) {
				leftQ.add(tmp);

			} else {
				rightQ.add(tmp);
			}

			if (leftQ.size() - rightQ.size() == 2) { //큐가 치우치지 않게
				rightQ.add(leftQ.poll());
			}

			if (rightQ.size() - leftQ.size() == 1) { //큐가 치우치지 않게
				leftQ.add(rightQ.poll());
			}
			sb.append(leftQ.peek()).append("\n");
			
			if(!leftQ.isEmpty())
				leftMid=leftQ.peek();
			
			if(!rightQ.isEmpty())
				rightMid=rightQ.peek();

		}
		System.out.println(sb.toString());

	}
}
