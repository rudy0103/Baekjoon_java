package b18115_카드놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		LinkedList<Integer> list = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i]=st.nextToken();

		int cnt = 0;
		String s = null;
		int idx=arr.length;
		while (idx-->0) {
			s = arr[idx];
			if (s.equals("1")) {
				list.addFirst(++cnt);
			} else if (s.equals("2")) {
				list.add(1, ++cnt);
			} else {
				list.addLast(++cnt);
			}
		}

		for (int n : list)
			sb.append(n + " ");
		System.out.println(sb.toString());

	}
}
