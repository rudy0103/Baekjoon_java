package b14891_톱니바퀴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Magnet {
	int id;
	LinkedList<Integer> dq;

	public Magnet(int id, LinkedList<Integer> dq) {
		super();
		this.id = id;
		this.dq = dq;
	}

	public void move(int dir) {
		if (dir == 1) { // 시계 방향
			dq.addFirst(dq.pollLast());
		} else {
			dq.addLast(dq.pollFirst());
		}
	}

}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		ArrayList<Magnet> list = new ArrayList<>();
		list.add(new Magnet(0, new LinkedList<Integer>()));

		for (int i = 1; i <= 4; i++) {
			LinkedList<Integer> dq = new LinkedList<Integer>();
			String inp=br.readLine();
			for (int j = 0; j < 8; j++)
				dq.add(inp.charAt(j)-'0');
			list.add(new Magnet(i, dq));
		}

		list.add(new Magnet(5, new LinkedList<Integer>()));

		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {// K번 돌리기
			st = new StringTokenizer(br.readLine(), " ");
			int id = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			boolean[][] state = new boolean[6][2];
			checkState(list, state);
			boolean[] turned = new boolean[6];
			q.add(new int[] { id, dir });
			turned[id] = true;

			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				list.get(tmp[0]).move(tmp[1]);
				if (state[tmp[0]][0] == true && tmp[0] != 1 && turned[tmp[0] - 1] == false) {
					turned[tmp[0] - 1] = true;
					q.add(new int[] { tmp[0] - 1, tmp[1] * -1 });
				}

				if (state[tmp[0]][1] == true && tmp[0] != 4 && turned[tmp[0] + 1] == false) {
					turned[tmp[0] + 1] = true;
					q.add(new int[] { tmp[0] + 1, tmp[1] * -1 });
				}
			}

		}
		// 점수 구하기
		int score = 0;

		for (int i = 1; i <= 4; i++) {
			if (list.get(i).dq.peekFirst() == 1)
				score += Math.pow(2, i - 1);
		}

		System.out.println(score);

	}

	private static void checkState(ArrayList<Magnet> list, boolean[][] state) {
		for (int i = 1; i <= 4; i++) {
			Magnet tmp = list.get(i);
			Magnet left = list.get(i - 1);
			Magnet right = list.get(i + 1);

			if (left.id != 0 && tmp.dq.get(6) != left.dq.get(2)) {
				state[i][0] = true;
			}
			if (right.id != 5 && tmp.dq.get(2) != right.dq.get(6)) {
				state[i][1] = true;
			}
		}
	}

}