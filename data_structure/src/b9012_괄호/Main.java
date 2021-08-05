package b9012_괄호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		
		Stack<Character> st = new Stack<>();
		
		for (int t = 0; t < T; t++) {
			char[] inp = br.readLine().toCharArray();
			boolean possible = true;
			for (char c : inp) {
				if (st.empty()) {
					st.add(c);
				} else if (c == '(') {
					st.add(c);
				} else if (c == ')' && st.peek() == '(') {
					st.pop();
				} else {
					possible = false;
					break;
				}
			}

			if (st.empty() && possible)
				bw.write("YES\n");
			else
				bw.write("NO\n");
			st.clear();
		}
		bw.close();
	}
}