package b2577_숫자의개수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A=sc.nextInt();
		int B=sc.nextInt();
		int C=sc.nextInt();
		int []arr=new int[10];
		int N=A*B*C;
		String s= Integer.toString(N);
		
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)-48]++;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
