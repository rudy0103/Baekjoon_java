package b6198_옥상정원꾸미기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<int[]> stack = new Stack<>();
		int[] height = new int[N + 1];
		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			while (!stack.isEmpty() && stack.peek()[0] <= height[i]) {
				int[] tmp = stack.pop();
				int idx = tmp[1];
				arr[idx] = i - idx - 1;
			}
			stack.add(new int[] { height[i], i });
		}

		while (!stack.isEmpty()) {
			int[] tmp = stack.pop();
			int idx = tmp[1];
			arr[idx] = N - idx;
		}

		long res = 0L;

		for (int n : arr) {
			res += n;
		}

		System.out.println(res);

	}

}
