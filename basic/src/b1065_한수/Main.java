package b1065_한수;

import java.util.Scanner;

public class Main {

	public static boolean isHansu(int n) {
		if (n > 10) {
			String s = Integer.toString(n);
			int d=Integer.parseInt(s.charAt(0)+"")-Integer.parseInt(s.charAt(1)+"");
			for (int i = 1; i < s.length()-1; i++) {
				if(Integer.parseInt(s.charAt(i)+"")-Integer.parseInt(s.charAt(i+1)+"")!=d) {
					return false;	
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			if (isHansu(i))
				cnt++;
		}
		System.out.println(cnt);
	}
}
