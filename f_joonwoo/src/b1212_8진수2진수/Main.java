package b1212_8진수2진수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str= br.readLine();
		StringBuilder sb = new StringBuilder();
		
		
		if(str.equals("0")) {
			sb.append("0");
		}else {
			int first=str.charAt(0)-'0';
			
			if(first>=4) {
				sb.append('1');
				first-=4;
			}
			if(first>=2) {
				sb.append('1');
				first-=2;
			}else {
				if(sb.length()>0)
					sb.append('0');
			}
			if(first>=1) {
				sb.append('1');
				first--;
			}else {
				if(sb.length()>0)
					sb.append('0');
			}
			
			for(int i=1;i<str.length();i++) {
				int num=str.charAt(i)-'0';
				if(num==7) {
					sb.append("111");
				}else if(num==6) {
					sb.append("110");
				}else if(num==5) {
					sb.append("101");
				}else if(num==4) {
					sb.append("100");
				}else if(num==3) {
					sb.append("011");
				}else if(num==2) {
					sb.append("010");
				}else if(num==1) {
					sb.append("001");
				}else if(num==0) {
					sb.append("000");
				}
			}
		}
		
		System.out.println(sb.toString());

	}

}
