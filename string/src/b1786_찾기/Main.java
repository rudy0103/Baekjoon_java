package b1786_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String t=br.readLine();
		String p=br.readLine();
		
		int cnt=0;
		List<Integer> list= new ArrayList<>();
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
		
		System.out.println(Arrays.toString(pi));
		int j=0;
		for(int i=0;i<tLen;i++) {
			if(t.charAt(i)==p.charAt(j)) {
				j++;
				if(j==pLen) {
					j=pi[j-1];
					cnt++;
					list.add(i-pLen+2);
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
		sb.append(cnt).append("\n");
		for(int n: list) sb.append(n).append(" ");
		
		System.out.println(sb.toString());
		
	}

}
