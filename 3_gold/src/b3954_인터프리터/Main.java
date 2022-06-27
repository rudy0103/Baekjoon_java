package b3954_인터프리터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Tmp {
		int idx;
		char ch;

		public Tmp(int idx, char ch) {
			super();
			this.idx = idx;
			this.ch = ch;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Tmp> stack = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int iLen = Integer.parseInt(st.nextToken());

			int[] arr = new int[m];
			char[] command = br.readLine().toCharArray();
			char[] inp = br.readLine().toCharArray();

			stack.clear();
			map.clear();
			
			for (int i = 0; i < command.length; i++) {
				if (command[i] == '[') {
					stack.add(new Tmp(i, command[i]));
				} else if (command[i] == ']') {
					int idx = stack.pop().idx;
					map.put(idx, i);
					map.put(i, idx);
				}
			}
			sb.append(start(map, arr, command, inp) + "\n");
		}

		System.out.println(sb.toString());
	}

	private static String start(HashMap<Integer, Integer> map, int[] arr, char[] command, char[] inp) {

		int pointer = 0;
		int cIdx = 0;
		int inpIdx = 0;
		int times = 0;
		int endIdx = 0;
		boolean flag = false;

		while (true) {

			char ch = command[cIdx];
			if (flag) {
				endIdx = Math.max(endIdx, cIdx);
			}
			switch (ch) {
			case '-':
				arr[pointer]--;
				if (arr[pointer] == -1)
					arr[pointer] = 255;

				break;
			case '+':
				arr[pointer]++;
				if (arr[pointer] > 255)
					arr[pointer] = 0;
				break;
			case '<':
				pointer--;
				if (pointer < 0)
					pointer = arr.length - 1;
				break;
			case '>':
				pointer++;
				if (pointer >= arr.length)
					pointer = 0;
				break;
			case '[':
				if (arr[pointer] == 0) {
					cIdx = map.get(cIdx);
				}
				break;
			case ']':
				if (arr[pointer] != 0) {
					cIdx = map.get(cIdx);
				}
				break;
			case '.':
				break;
			case ',':
				if (inpIdx < inp.length) {
					arr[pointer] = inp[inpIdx++];
				} else
					arr[pointer] = 255;
				break;
			}

			cIdx++;

			if (++times > 50000000) {
				flag = true;
			}
			if (times >= 100000000 || cIdx >= command.length) {
				break;
			}
		}

		if (flag) {
			String str = "Loops ";
			str += map.get(endIdx);
			str += " ";
			str += endIdx;
			return str;
		} else
			return "Terminates";
	}
}
