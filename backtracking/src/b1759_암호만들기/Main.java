package b1759_암호만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
	static int L, C;
	static char[] selected;
	static ArrayList<Character> list;
	static StringBuilder sb = new StringBuilder();

	public static boolean isPossible() {
		int cnt = 0;
		boolean possible = false;
		for (char c : selected) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				possible = true;
			}else cnt++;
		}

		return (cnt>=2&&possible);
	}

	public static void makeCombination(int cnt, int start) {
		if (cnt == L) {
			if (isPossible())
				sb.append(String.valueOf(selected)).append("\n");
			return;
		}

		for (int i = start; i < list.size(); i++) {
			selected[cnt] = list.get(i);
			makeCombination(cnt + 1, i + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		list = new ArrayList<>();
		String[] inp = br.readLine().split(" ");
		L = Integer.parseInt(inp[0]);
		C = Integer.parseInt(inp[1]);
		selected=new char[L];
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			list.add(st.nextToken().charAt(0));
		Collections.sort(list);
		makeCombination(0, 0);
		bw.write(sb.toString());
		bw.close();
	}

}