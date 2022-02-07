package b17822_원판돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int N, M, T;

	static class Node {
		int val;
		boolean removed;
		public Node(int val, boolean removed) {
			super();
			this.val = val;
			this.removed = removed;
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		ArrayList<LinkedList<Node>> circle = new ArrayList<>();

		for (int i = 0; i <= N; i++)
			circle.add(new LinkedList<>());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				circle.get(i).add(new Node(Integer.parseInt(st.nextToken()), false));
			}
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());// x의 배수인 원판만 돌림
			int d = Integer.parseInt(st.nextToken());// 방향 0은 시계방향 1은 반시계 방향
			int k = Integer.parseInt(st.nextToken());// 횟수

			turnCircle(x, d, k, circle);
		}

		int totSum = 0;
		for (LinkedList<Node> list : circle) {
			while (!list.isEmpty()) {
				Node node=list.poll();
				if(node.removed) continue;
				else totSum+=node.val;
			}
		}
		System.out.println(totSum);
	}

	private static void turnCircle(int x, int d, int k, ArrayList<LinkedList<Node>> circle) {
		for (int i = 1; i <= N; i++) {
			if (i % x == 0) { // 원판이 x의 배수 일 때
				LinkedList<Node> now = circle.get(i);
				if (d == 0) {// 시계 방향
					for (int j = 0; j < k; j++) {
						now.addFirst(now.pollLast());
					}
				} else {// 반시계 방향
					for (int j = 0; j < k; j++) {
						now.addLast(now.pollFirst());
					}

				}
			}
		}

		// 원판을 돌린 후 인접한 곳이 있는지 찾는다.

		findSameNumber(circle);

	}

	private static void findSameNumber(ArrayList<LinkedList<Node>> circle) {

		boolean visited[][] = new boolean[N + 1][M];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			LinkedList<Node> now = circle.get(i);
			for (int j = 0; j < M; j++) {
				if (now.get(j).removed)
					continue;

				for (int d = 0; d < 4; d++) {

					int nr = i + dr[d];
					if (nr == 0 || nr == N + 1)
						continue;

					int nc = j + dc[d];
					if (nc == -1)
						nc = M - 1;
					if (nc == M)
						nc = 0;

					Node adjNode=circle.get(nr).get(nc);
					if(adjNode.removed) continue;
					
					if (now.get(j).val == circle.get(nr).get(nc).val) {
						visited[i][j] = true;
						cnt++;
						break;
					}

				}

			}
		}

		if (cnt == 0) {
			plusAndMinus(circle);
		} else {
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						circle.get(i).get(j).removed=true;
					}
				}
			}
		}
	}

	private static void plusAndMinus(ArrayList<LinkedList<Node>> circle) {

		double sum = 0;
		double cnt = 0;
		double avg = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (circle.get(i).get(j).removed==false) {
					cnt++;
					sum += circle.get(i).get(j).val;
				}
			}
		}

		avg = sum / cnt;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (circle.get(i).get(j).removed)
					continue;
				else {
					int num = circle.get(i).get(j).val;
					if (num > avg) {
						circle.get(i).get(j).val=--num;
					} else if (num < avg) {
						circle.get(i).get(j).val=++num;
					}
				}
			}
		}

	}

}
