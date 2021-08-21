package b13913_숨바꼭질4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static int time;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int su = Integer.parseInt(inp[0]);
		int bro = Integer.parseInt(inp[1]);
		boolean[] visited = new boolean[100001];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { su, 0 });
		visited[su] = true;
		Stack<int[]> st = new Stack<>();
		Stack<Integer> res = new Stack<>();
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			st.add(tmp);
			if (tmp[0] == bro) {
				time = tmp[1];
				break;
			}
			if (tmp[0] * 2 <= 100000 && !visited[tmp[0] * 2]) {
				visited[tmp[0] * 2] = true;
				q.add(new int[] { tmp[0] * 2, tmp[1] + 1 });
			}
			if (tmp[0] + 1 <= 100000 && !visited[tmp[0] + 1]) {
				visited[tmp[0] + 1] = true;
				q.add(new int[] { tmp[0] + 1, tmp[1] + 1 });
			}
			if (tmp[0] - 1 >= 0 && !visited[tmp[0] - 1]) {
				visited[tmp[0] - 1] = true;
				q.add(new int[] { tmp[0] - 1, tmp[1] + 1 });
			}
		}
		int cnt = time - 1;
		res.add(st.pop()[0]);
		while (!st.isEmpty()) {
			if (st.peek()[1] != cnt)
				st.pop();
			else {
				if (st.peek()[0] == res.peek() - 1) {
					res.add(st.pop()[0]);
					cnt--;
				} else if (st.peek()[0] == res.peek() + 1) {
					res.add(st.pop()[0]);
					cnt--;
				} else if (res.peek() % 2 == 0 && st.peek()[0] == res.peek() / 2) {
					res.add(st.pop()[0]);
					cnt--;
				} else
					st.pop();
			}
		}
		while (!res.isEmpty())
			sb.append(res.pop()).append(" ");
		System.out.println(time);
		System.out.println(sb.toString());
	}
}
