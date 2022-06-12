package b1105_팔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String L=st.nextToken();
		String R=st.nextToken();
		
		int lCnt=0;
		int rCnt=0;
		for(int i=0;i<L.length();i++) {	
			if(L.charAt(i)=='8') lCnt++;
		}
		
		for(int i=0;i<R.length();i++) {	
			if(R.charAt(i)=='8') rCnt++;
		}
		
		min=Math.min(lCnt, rCnt);
		if(min==0) {
			min=0;
		}
		else if(L.length()!=R.length()) min=0;
		else {
			int cnt=0;
			for(int i=0;i<L.length();i++) {
				if(L.charAt(i)!=R.charAt(i)) {
					break;
				}else {
					if(L.charAt(i)=='8') cnt++;
				}
			}
			min=Math.min(min, cnt);
			
		}
		System.out.println(min);
	}
}
