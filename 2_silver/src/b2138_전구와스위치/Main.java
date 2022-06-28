package b2138_전구와스위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int min = 9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] origin = br.readLine().toCharArray();
		char[] ret = br.readLine().toCharArray();

		min = Math.min(min, go(origin, ret, 0));
		origin[0] = (origin[0] == '0') ? '1' : '0';
		origin[1] = (origin[1] == '0') ? '1' : '0';
		min = Math.min(min, go(origin, ret, 1));

		if (min == 9999999)
			System.out.println("-1");
		else
			System.out.println(min);

	}

	private static int go(char[] origin, char[] ret, int g) {
		char[] copy = new char[origin.length];
		
		for (int i = 0; i < copy.length; i++) {
			copy[i] = origin[i];
		}
		
		int cnt = g;

		for (int i = 1; i < copy.length; i++) {
			if (copy[i - 1] != ret[i - 1]) {
				cnt++;
				copy[i] = (copy[i] == '0') ? '1' : '0';
				if (i + 1 < copy.length)
					copy[i + 1] = (copy[i + 1] == '0') ? '1' : '0';
				copy[i - 1] = (copy[i - 1] == '0') ? '1' : '0';
			}
		}

		if (String.valueOf(copy).equals(String.valueOf(ret))) {
			return cnt;
		} else
			return 9999999;

	}

}
