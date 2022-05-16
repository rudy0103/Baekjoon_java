package b3986_좋은단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int cnt=0;
		
		Stack<Character> st = new Stack<>();
		for(int i=0;i<N;i++) {
			String inp=br.readLine();
			if(inp.length()%2!=0) continue;
			int l=inp.length();
			
			for(int j=0;j<l;j++) {
				if(st.isEmpty()) st.add(inp.charAt(j));
				else if(st.peek()!=inp.charAt(j)) {
					st.add(inp.charAt(j));
				}else {
					st.pop();
				}
			}
			
			if(st.isEmpty()) cnt++;
			else st.clear();
		}
		
		
		System.out.println(cnt);

	}

}
