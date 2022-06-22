package b11899_괄호끼어넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp=br.readLine();
		
		
		Stack<Character> st = new Stack<>();
		
		for(int i=0;i<inp.length();i++) {
			char ch=inp.charAt(i);
			
			if(st.isEmpty()) {
				st.add(ch);
				continue;
			}
			
			if(ch=='(') st.add(ch);
			else if(ch==')') {
				if(st.peek()=='(') st.pop();
				else st.add(ch);
			}
		}
		
		System.out.println(st.size());
	}

}
