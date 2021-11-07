package b2251_물통;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		boolean[][][] visited = new boolean[201][201][201];

		ArrayDeque<int[]> dq = new ArrayDeque<>();
		HashSet<Integer> set = new HashSet<>();
		dq.add(new int[] { 0, 0, C });
		visited[0][0][C] = true;

		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int a = cur[0];
			int b = cur[1];
			int c = cur[2];

			if (a == 0)
				set.add(c);

			// a를 붓는경우
			if (a > 0) {
				// b에 붓는 경우
				if (a + b <= B) {
					if (!visited[0][a + b][c]) {
						visited[0][a + b][c] = true;
						dq.add(new int[] { 0, a + b, c });
					}
				} else {
					if (!visited[a + b - B][B][c]) {
						visited[a + b - B][B][c] = true;
						dq.add(new int[] { a + b - B, B, c });
					}
				}
				// c에 붓는 경우
				if (a + c <= C) {
					if (!visited[0][b][a + c]) {
						visited[0][b][a + c] = true;
						dq.add(new int[] { 0, b, a + c });
					}
				} else {
					if (!visited[a + c - C][b][C]) {
						visited[a + c - C][b][C] = true;
						dq.add(new int[] { a + c - C, b, C });
					}
				}
			}

			// b를 붓는경우
			if (b > 0) {

				// a에 붓는 경우
				if (a + b <= A) {
					if (!visited[a + b][0][c]) {
						visited[a + b][0][c] = true;
						dq.add(new int[] { a + b, 0, c });
					}
				} else {
					if (!visited[A][a + b - A][c]) {
						visited[A][a + b - A][c] = true;
						dq.add(new int[] { A, a + b - A, c });
					}
				}
				// c에 붓는 경우
				if (b + c <= C) {
					if (!visited[a][0][b + c]) {
						visited[a][0][b + c] = true;
						dq.add(new int[] { a, 0, b + c });
					}
				} else {
					if (!visited[a][b + c - C][C]) {
						visited[a][b + c - C][C] = true;
						dq.add(new int[] { a, b + c - C, C });
					}
				}

			}

			// c를 붓는 경우
			if (c > 0) {
				// a에 붓는 경우
				if (a + c <= A) {
					if (!visited[a + c][b][0]) {
						visited[a + c][b][0] = true;
						dq.add(new int[] { a + c, b, 0 });
					}
				} else {
					if (!visited[A][b][a + c - A]) {
						visited[A][b][a + c - A] = true;
						dq.add(new int[] { A, b, a + c - A });
					}
				}
				// b에 붓는 경우
				if (b + c <= B) {
					if (!visited[a][b + c][0]) {
						visited[a][b + c][0] = true;
						dq.add(new int[] { a, b + c, 0 });
					}
				} else {
					if (!visited[a][B][b + c - B]) {
						visited[a][B][b + c - B] = true;
						dq.add(new int[] { a, B, b + c - B });
					}
				}

			}
		}

		LinkedList<Integer> list = new LinkedList<>(set);
		Collections.sort(list);

		for (int n : list)
			sb.append(n + " ");
		System.out.println(sb.toString());

	}

}
