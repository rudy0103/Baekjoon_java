package b20437_문자열게임2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	static int min, max;
	static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[] ch = new int[26];
		for (int tc = 1; tc <= T; tc++) {
			String inpStr = br.readLine();
			min = Integer.MAX_VALUE;
			max = 0;
			int K = Integer.parseInt(br.readLine());
			if (K == 1) {
				sb.append("1 1\n");
				continue;
			}
			Arrays.fill(ch, 0);
			boolean flag = false;
			for (int i = 0; i < inpStr.length(); i++) {
				ch[inpStr.charAt(i) - 'a']++;
				if (ch[inpStr.charAt(i) - 'a'] >= K)
					flag = true;
			}

			if (flag == false) {
				sb.append("-1\n");
				continue;
			}
			for (int i = 0; i < 26; i++) {
				if (ch[i] < K)
					continue;
				list.clear();
				findMinMax(inpStr, i, ch, K);
			}
			sb.append(min + " " + max + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void findMinMax(String inpStr, int i, int[] ch, int K) {
		int len = 0;

		for (int j = 0; j < inpStr.length(); j++) {
			if (inpStr.charAt(j) - 'a' == i)
				list.add(j);
		}
		for (int j = 0; j + K - 1 < list.size(); j++) {
			len = list.get(j + K - 1) - list.get(j) + 1;
			if (len < min)
				min = len;
			if (len > max)
				max = len;
		}

	}
}
