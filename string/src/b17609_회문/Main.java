package b17609_회문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static int isCorrect(String s) {
		int len=s.length();
		for(int i=0;i<s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(len-1-i)) return i;
		}
		return -1;
	}
	
	static void isPalindrome(String s) {
		int len=s.length();
		int res=isCorrect(s);
		if(res==-1) { //회문일 때
			sb.append("0\n");
		}else {
			if(isCorrect(s.substring(res+1,len-res))==-1){ //왼쪽을 제거하고 다시 검사
				sb.append("1\n"); //유사회문
			}else if(isCorrect(s.substring(res,len-res-1))==-1) {//오른쪽 제거하고 다시 검사
				sb.append("1\n"); //유사회문
			}else {
				sb.append("2\n"); //둘다 아니면 평문
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			String inp=br.readLine();
			isPalindrome(inp);
		}
		System.out.println(sb.toString());
	}
}
