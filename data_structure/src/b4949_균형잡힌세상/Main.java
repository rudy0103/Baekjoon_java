package b4949_균형잡힌세상;

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

		String inp = br.readLine();
		while (!inp.equals(".")) {
			Stack<Character> s = new Stack<>();
			boolean isTrue=true;
			for (int i = 0; i < inp.length(); i++) {
				if (( inp.charAt(i) == '(' || inp.charAt(i) == '[')) {
					s.push(inp.charAt(i));
				} else if (inp.charAt(i) == ')') {
					if (!s.isEmpty() && s.peek() == '(') {
						s.pop();
					}else {
						isTrue=false;
						break;
					}
				}else if (inp.charAt(i) == ']') {

					if (!s.isEmpty() && s.peek() == '[') {
						s.pop();
					}else {
						isTrue=false;
						break;
					}
				}
			}
			if(s.isEmpty()&&isTrue==true) bw.write("yes\n");
			else bw.write("no\n");
			inp=br.readLine();
		}
		bw.close();
	}
}
