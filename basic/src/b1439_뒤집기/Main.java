package b1439_뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str= br.readLine().toCharArray();
		
		
		int zeroCnt=0;
		int oneCnt=0;
		
		char before=str[0];
		
		if(before=='0') zeroCnt++;
		else oneCnt++;
		
		for(int i=1;i<str.length;i++) {
			
			if(before!=str[i]) {
				if(str[i]=='0') zeroCnt++;
				else oneCnt++;
				before=str[i];
			}
			
		}
		
		
		
		
		
		System.out.println(Math.min(zeroCnt, oneCnt));
		
		
	}

}
