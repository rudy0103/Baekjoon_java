package b10809_알파벳찾기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		int [] arr=new int[26];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=-1;
		}

		for(int i=0;i<S.length();i++) {
			if(arr[(int)(S.charAt(i))-'a']==-1) {
				arr[(int)(S.charAt(i))-'a']=i;
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
