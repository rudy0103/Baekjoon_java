package b20437_문자열게임2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main2 {
	static int min, max;
	static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		LinkedList<Integer>[] list = new LinkedList[26];
		for (int i = 0; i < 26; i++)
			list[i] = new LinkedList<Integer>();

		for (int tc = 1; tc <= T; tc++) {
			String inpStr = br.readLine();
			min = Integer.MAX_VALUE;
			max = 0;
			int K = Integer.parseInt(br.readLine());
			if (K == 1) {
				sb.append("1 1\n");
				continue;
			}
			for (int i = 0; i < 26; i++)
				list[i].clear();

			boolean flag = false;
			for (int i = 0; i < inpStr.length(); i++) {
				list[inpStr.charAt(i) - 'a'].add(i);
				if (list[inpStr.charAt(i) - 'a'].size() >= K)
					flag = true;
			}

			if (flag == false) {
				sb.append("-1\n");
				continue;
			}
			for (int i = 0; i < 26; i++) {
				if (list[i].size() < K)
					continue;
				findMinMax(inpStr, i, list, K);
			}
			sb.append(min + " " + max + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void findMinMax(String inpStr, int i, LinkedList<Integer>[] list, int K) {
		int len = 0;

		for (int j = 0; j + K - 1 < list[i].size(); j++) {
			len = list[i].get(j + K - 1) - list[i].get(j) + 1;
			if (len < min)
				min = len;
			if (len > max)
				max = len;
		}
	}

}
