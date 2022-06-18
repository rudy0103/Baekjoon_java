package b1254_팰린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		
		int len=inp.length();
		
		int max=1;
		
		for(int i=len-1;i>=0;i--) {
			if(isTrue(inp,i)) {
				max=len-i;
			}
		}
		
		System.out.println(max+(len-max)*2);

		
		

	}

	private static boolean isTrue(String inp, int left) {
		
		
		int right=inp.length()-1;
		
		while(left<=right) {
			if(inp.charAt(left++)!=inp.charAt(right--)) {
				return false;
			}
			
		}
		
		return true;
	}



}
