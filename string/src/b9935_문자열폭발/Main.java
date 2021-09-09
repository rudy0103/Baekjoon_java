package b9935_문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inp = br.readLine().toCharArray();
		char[] boomStr = br.readLine().toCharArray();
		int len = boomStr.length;
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Character> q = new ArrayDeque<>();
		ArrayDeque<Character> q2 = new ArrayDeque<>();
		for (int i = inp.length-1; i >= 0; i--) {
			if(inp[i]!=boomStr[0]) q.add(inp[i]);
			else {
				int pos=1;
				for(int j=0;j<len-1;j++) {
					if(!q.isEmpty()&&boomStr[pos++]==q.peekLast())
					{
						q2.add(q.pollLast());
					}
					else {
						while(!q2.isEmpty()) q.add(q2.pollLast());
						q.add(inp[i]);
						break;
					}
				}
				q2.clear();
			}
		}
		
		while (!q.isEmpty()) {
			sb.append(q.pollLast());
		}

		if(sb.toString().length()!=0) System.out.println(sb.toString());
		else System.out.println("FRULA");
	}
}
