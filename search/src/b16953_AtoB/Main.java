package b16953_AtoB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long A = sc.nextLong();
		long B = sc.nextLong();
		long min = Integer.MAX_VALUE;
		boolean isPossible = false;

		ArrayDeque<long[]> q = new ArrayDeque<>();
		q.add(new long[] { A, 1 });

		while (!q.isEmpty()) {
			long[] curr = q.poll();

			if (curr[0] == B) {
				isPossible = true;
				min = curr[1];
				break;
			}

			long a = curr[0] * 2;
			if (a <= B)
				q.add(new long[] { a, curr[1] + 1 });

			long b = curr[0] * 10 + 1;
			if (b <= B)
				q.add(new long[] { b, curr[1] + 1 });

		}

		if (isPossible) {
			System.out.println(min);
		} else
			System.out.println(-1);

	}

}
