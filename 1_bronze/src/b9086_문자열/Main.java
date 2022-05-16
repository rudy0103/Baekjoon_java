package b9086_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<T;i++) {
			String inp=br.readLine();
			if(inp.length()>1) {
				sb.append(inp.charAt(0));
				sb.append(inp.charAt(inp.length()-1));
			}else {
				sb.append(inp.charAt(0));
				sb.append(inp.charAt(0));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}

}
