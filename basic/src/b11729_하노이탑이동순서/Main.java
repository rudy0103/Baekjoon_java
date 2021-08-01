package b11729_하노이탑이동순서;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static int n,k;
	public static BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void func(int n,char from, char tmp, char to) throws IOException {
		if(n==1) {
			br.write(from+" "+to+"\n");
		}else {
			func(n-1,from,to,tmp);
			br.write(from+" "+to+"\n");
			func(n-1,tmp,from,to);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = 0;
		if(n==1) {
			System.out.println(1);
		}else {
			System.out.println(((int)(Math.pow(2, n)-1)));
		}
		func(n,'1','2','3');
		br.flush();
		br.close();
	}
}
