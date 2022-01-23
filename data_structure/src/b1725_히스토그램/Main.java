package b1725_히스토그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long min = 0;

		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i <= N; i++) {
			int h = -1;
			if (i == N)
				h = 0;
			else
				h = Integer.parseInt(br.readLine());
			if (stack.isEmpty())
				stack.add(new int[] { h, i });
			else if (stack.peek()[0] == h)
				continue;
			else if (stack.peek()[0] < h)
				stack.add(new int[] { h, i });
			else {// 스택의 top 의 h보다 작을때
				int lastIdx = -1;
				while (!stack.isEmpty() && stack.peek()[0] >= h) {
					int[] tmp = stack.pop();
					long area = (long) tmp[0] * (i - tmp[1]);
					if (area > min)
						min = area;
					area = (long) h * (i - tmp[1] + 1);
					if (area > min)
						min = area;
					lastIdx = tmp[1];
				}
				stack.add(new int[] { h, lastIdx });

			}
		}

		sb.append(min).append("\n");

		System.out.println(sb.toString());
	}

}
