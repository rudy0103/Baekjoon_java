package b1525_퍼즐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Puzzle {
		char[] value;
		int idx;
		int cnt;
		int dir;

		public Puzzle(char[] value, int idx, int cnt, int dir) {
			super();
			this.value = value;
			this.idx = idx;
			this.cnt = cnt;
			this.dir = dir;
		}

		public char[] getNewArr(int idx, int nr, int nc) {
			char tmp = this.value[idx];
			char[] newArr = Arrays.copyOf(this.value, 9);
			newArr[idx] = this.value[nr * 3 + nc];
			newArr[nr * 3 + nc] = tmp;

			return newArr;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] origin = new char[9];
		int startIdx = -1;
		HashSet<String> set = new HashSet<>();
		StringTokenizer st = null;
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0)
				st = new StringTokenizer(br.readLine());
			origin[i] = st.nextToken().charAt(0);
			if (origin[i] == '0') {
				startIdx = i;
				origin[i]='9';
			}
		}

		PriorityQueue<Puzzle> pq = new PriorityQueue<>(new Comparator<Puzzle>() {
			@Override
			public int compare(Puzzle o1, Puzzle o2) {
				return o1.cnt - o2.cnt;
			}
		});

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };
		pq.add(new Puzzle(origin, startIdx, 0, -1));
		set.add(String.valueOf(pq.peek().value));

		int min = Integer.MAX_VALUE;
		String ans = "123456789";
		while (!pq.isEmpty()) {
			Puzzle now = pq.poll();
			if (String.valueOf(now.value).equals(ans)) {
				min = now.cnt;
				break;
			}

			for (int d = 0; d < 4; d++) {
				if (d == now.dir)
					continue;
				int nr = now.idx / 3 + dr[d];
				int nc = now.idx % 3 + dc[d];

				if (nr < 0 || nr >= 3 || nc < 0 || nc >= 3)
					continue;

				char[] newArr = now.getNewArr(now.idx, nr, nc);
				String newValue = String.valueOf(newArr);
				if (!set.contains(newValue)) {
					set.add(newValue);
					pq.add(new Puzzle(newArr, nr * 3 + nc, now.cnt + 1, getDir(d)));
				}
			}

		}
		if (min != Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println("-1");
	}

	private static int getDir(int d) {
		if (d == 0)
			return 1;
		if (d == 1)
			return 0;
		if (d == 2)
			return 3;
		if (d == 3)
			return 2;
		return 0;
	}

}
