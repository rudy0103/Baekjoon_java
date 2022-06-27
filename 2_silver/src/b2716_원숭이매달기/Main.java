package b2716_원숭이매달기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> tmpStack=new Stack<>();
		for(int tc=0;tc<T;tc++) {
			Stack<Character> stack=new Stack<>();
			
			char[] inp=br.readLine().toCharArray();
			
			for(int i=0;i<inp.length;i++) {
				if(inp[i]=='[') {
					stack.add('[');
					stack.add('a');
				}else {
					while(!stack.isEmpty()&&stack.peek()!='[') {
						tmpStack.add((char) (stack.pop()+1));
					}
					stack.pop();
					while(!tmpStack.isEmpty()) {
						stack.add(tmpStack.pop());
					}
				}
			}
			int max=0;
			while(!stack.isEmpty()) {
				max=Math.max(max, stack.pop()-'a');
			}
			sb.append((int)Math.pow(2, max)+"\n");
		}
		System.out.println(sb.toString());
	}
}
