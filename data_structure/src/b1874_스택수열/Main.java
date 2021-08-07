package b1874_스택수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		List<String> l = new ArrayList<>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		boolean possible = true;
		int i = 1, j = 0;
		while (i <= n) {
			while (i <= arr[j]) {
				s.push(i);
				l.add("+");
				i++;
			}
			if (s.peek() == arr[j]) {
				s.pop();
				l.add("-");
				j++;
			}
			if (!s.empty() && s.peek() > arr[j]) {
				possible = false;
				break;
			}
		}
		while (!s.isEmpty()) {
			s.pop();
			l.add("-");
		}

		if (possible) {
			for (String c : l)
				bw.write(c + "\n");
		} else
			bw.write("NO");
		bw.close();
	}
}
