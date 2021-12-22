package b11585_속타는저녁메뉴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String s2 = br.readLine();
		
		char[] t= new char[L*2];
		char[] p = new char[L];
		
		for(int i=0;i<s.length();i+=2) {
			t[i/2]=s.charAt(i);
			t[L+(i/2)]=s.charAt(i);
			p[i/2]=s2.charAt(i);
		}
		
		int cnt = 0;
		// 부분 일치 테이블 배열 만들기
		int[] pi = new int[p.length];
		int tLen = t.length;
		int pLen = p.length;
		for (int i = 1, j = 0; i < pLen; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j])
				pi[i] = ++j;
		}

		for (int i = 0, j = 0; i < tLen; i++) {
			if (t[i] == p[j]) {
				j++;
				if (j == pLen) {
					j = pi[j - 1];
					if (i - pLen + 2 <= pLen)
						cnt++;
				}
			} else {
				while (j - 1 >= 0) {
					j = pi[j - 1];
					if (t[i] == p[j]) {
						j++;
						break;
					}
				}
			}
		}

		if (cnt == L)
			System.out.println("1/1");
		else {
			int[] tmp = f(cnt, L);
			System.out.println(tmp[0]+"/"+tmp[1]);
		}
	}
	// ====출력

	private static int[] f(int a, int b) {
		int[] res = new int[2];
		
		if(b%a==0) {
			res[0]=1;
			res[1]=b/a;
			return res;
		}
		
		for(int i=a/2;i>1;i--) {
			
			if(b%i==0&&a%i==0) {
				res[0]=a/i;
				res[1]=b/i;
				return res;
			}
		}
		return res;
	}
}
