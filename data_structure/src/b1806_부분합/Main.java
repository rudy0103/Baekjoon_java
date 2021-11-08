package b1806_부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int S = Integer.parseInt(inp[1]);

		ArrayDeque<Integer> dq = new ArrayDeque<>();

		int sum = 0;
		int len = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
			dq.add(num);
			if (sum >= S) {
				while (sum - dq.peek() >= S) {
					sum -= dq.poll();
				}
				if (sum >= S) {
					if (len > dq.size())
						len = dq.size();
					flag = true;
				}
			}
		}
		if (flag == false)
			System.out.println(0);
		else
			System.out.println(len);
	}

}
