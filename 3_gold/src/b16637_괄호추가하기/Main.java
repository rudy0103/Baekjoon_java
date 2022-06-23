package b16637_괄호추가하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String inp = br.readLine();

		int end = N - 1;

		bruteForce(inp, 0, 0, end);
		System.out.println(max);
	}

	private static void bruteForce(String inp, int value, int index, int end) {

		if (index > end) {
			max = Math.max(max, value);
			return;
		}

		char op = (index == 0) ? '+' : inp.charAt(index - 1);
		if (index < end) {
			int newValue = calc(inp.charAt(index) - '0', inp.charAt(index + 2) - '0', inp.charAt(index + 1));
			bruteForce(inp, calc(value, newValue, op), index + 4, end);
		}

		bruteForce(inp, calc(value, inp.charAt(index)-'0', op), index + 2, end);

	}

	private static int calc(int a, int b, char op) {

		if (op == '+')
			return a + b;
		if (op == '-')
			return a - b;
		if (op == '*')
			return a * b;
		return 0;
	}

}
