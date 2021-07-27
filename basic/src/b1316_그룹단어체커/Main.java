package b1316_그룹단어체커;

import java.util.Scanner;

public class Main {
	
	public static boolean is_group(String word) {
		int [] arr =new int[26];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=-1;
		}
		
		for(int i=0;i<word.length();i++) {
			if(arr[word.charAt(i)-'a']==-1) {
				arr[word.charAt(i)-'a']=i;
			}else {
				if(arr[word.charAt(i)-'a']!=i-1) {
					return false;
				}else {
					arr[word.charAt(i)-'a']=i;
				}
			}
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		sc.nextLine();
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			String word=sc.nextLine();
			if(is_group(word)) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
