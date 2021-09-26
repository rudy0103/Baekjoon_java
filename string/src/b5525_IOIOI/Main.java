package b5525_IOIOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		sb.append("IOI");
		for(int i=1;i<=N-1;i++) {
			sb.append("OI");
		}
		String p=sb.toString();
		String t=br.readLine();
		
		int cnt=0;
		//부분 일치 테이블 배열 만들기
		
		int [] pi=new int[p.length()];
		int tLen=t.length();
		int pLen=p.length();
	    for(int i=1, j=0; i<pLen; i++){
	        while(j > 0 && p.charAt(i) != p.charAt(j)) {
	        	j = pi[j-1];  
	        }
	        if(p.charAt(i) == p.charAt(j)) pi[i] = ++j;
	    }
	    
		for(int i=0,j=0;i<tLen;i++) {
			if(t.charAt(i)==p.charAt(j)) {
				j++;
				if(j==pLen) {
					j=pi[j-1];
					cnt++;
				}
			}else {
				while(j-1>=0) {
					j=pi[j-1];
					if(t.charAt(i)==p.charAt(j)) {
						j++;
						break;
					}
				}
			}
		}
		
		//====출력
		System.out.println(cnt);
		
		
	}

}
