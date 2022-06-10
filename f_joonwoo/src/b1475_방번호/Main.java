package b1475_방번호;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number=sc.next();
		
		int []arr=new int[10];
		int sixAndNine=0;
		
		for(int i=0;i<number.length();i++) {
			arr[number.charAt(i)-'0']++;
		}
		sixAndNine=arr[6]+arr[9];
		
		if(sixAndNine%2==0)
			arr[6]=sixAndNine/2;
		else arr[6]=sixAndNine/2+1;
		arr[9]=0;
		int cnt=0;
		for(int i=0;i<10;i++) {
			cnt=Math.max(cnt, arr[i]);
		}
		System.out.println(cnt);
	}

}
