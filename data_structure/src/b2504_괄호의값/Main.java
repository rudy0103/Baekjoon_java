package b2504_괄호의값;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.next();
		Stack<Character> chStack = new Stack<>();

		boolean flag = true;

		for (int i = 0; i < inp.length(); i++) {
			char ch = inp.charAt(i);
			if (ch == '(' || ch == '[')
				chStack.add(ch);
			else if (!chStack.isEmpty()&&ch == ')' && chStack.peek() == '(')
				chStack.pop();
			else if (!chStack.isEmpty()&&ch == ']' && chStack.peek() == '[')
				chStack.pop();
			else {
				flag = false;
			}
		}
		if (flag == false || !chStack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(getValue(inp));
		}
	}

	private static int getValue(String str) {
		int res = 0;
		
		Stack<String> st = new Stack<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			
			if(ch=='('||ch=='[') {
				st.add(ch+"");
			}else if(ch==')') {
				
				if(st.peek().equals("(")) {
					st.pop();
					st.add("2");
				}else {
					int tmp=0;
					
					while(!st.peek().equals("(")) {
						tmp+=Integer.parseInt(st.pop());
					}
					st.pop();
					st.add(Integer.toString(tmp*2));
				}
				
			}else if(ch==']') {
				if(st.peek().equals("[")) {
					st.pop();
					st.add("3");
				}else {
					int tmp=0;
					
					while(!st.peek().equals("[")) {
						tmp+=Integer.parseInt(st.pop());
					}
					st.pop();
					st.add(Integer.toString(tmp*3));
				}
				
			}
			
		}
		while(!st.isEmpty()) res+=Integer.parseInt(st.pop());
		

		return res;
	}

}
