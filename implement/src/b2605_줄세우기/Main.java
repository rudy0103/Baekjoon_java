package b2605_줄세우기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> s = new Stack<>();
		Deque<Integer> list = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		String[] inp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(inp[i]);
			if (num == 0)
				list.add(i+1);
			else {
				for (int j = 0; j < num; j++) {
					s.add(list.pollLast());
				}
				list.add(i+1);
				while(!s.isEmpty()) list.add(s.pop());
			}
		}
		while(!list.isEmpty()) bw.write(list.pollFirst()+" ");
		bw.close();
	}
}
