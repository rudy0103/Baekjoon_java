package b1157_단어공부;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word=sc.next();
		int [] arr = new int[26];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i)>='A' && word.charAt(i)<='Z') {
				arr[word.charAt(i)-'A']++;
			}else {
				arr[word.charAt(i)-'a']++;
			}	
		}
		
		for(int i=0;i<26;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		int cnt=0;
		char pos='A';
		for(int i=0;i<26;i++) {
			if(arr[i]==max) {
				cnt++;
				if (cnt>2) break;
				pos+=i;
			}
		}
		if(cnt>1) System.out.println("?");
		else System.out.println(pos);
	}
}
