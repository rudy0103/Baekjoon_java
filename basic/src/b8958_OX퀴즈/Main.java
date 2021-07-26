package b8958_OX퀴즈;


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		String s;
		
		for(int i =0;i<N;i++) {
			int tot=0;
			int cnt=1;
			s=sc.next();
			for(int j=0; j<s.length();j++) {
				if(s.charAt(j)=='O') {
					tot+=cnt++;
				}else
					cnt=1;
			}
			System.out.println(tot);
		}
	}
}
