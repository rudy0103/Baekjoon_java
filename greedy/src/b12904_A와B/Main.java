package b12904_A와B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S=br.readLine();
		String T=br.readLine();
		
		StringBuilder t=new StringBuilder();
		t.append(T);
		
		int len=S.length()-1;
		int l=T.length()-1;
		
		while(l>len) {
			
			if(t.charAt(l)=='A') {
				t.setLength(t.length()-1);
			}else {
				t.setLength(t.length()-1);
				t.reverse();
				
			}
			l--;	
		}
		
		if(t.toString().equals(S)) System.out.println(1);
		else System.out.println(0);
	}
}
