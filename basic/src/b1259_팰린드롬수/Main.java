package b1259_팰린드롬수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static boolean is_true(String s) {
		
		for(int i=0;i<s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String inp=br.readLine();
		
		while(!inp.equals("0")) {
			if(is_true(inp)) {
				sb.append("yes\n");
			}else {
				sb.append("no\n");
			}
			inp=br.readLine();
		}
		System.out.println(sb.toString());
	}
}
