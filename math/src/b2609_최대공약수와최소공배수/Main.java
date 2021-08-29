package b2609_최대공약수와최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inp=br.readLine().split(" ");
		
		int a=Integer.parseInt(inp[0]);
		int b=Integer.parseInt(inp[1]);
		
		int small=a<b?a:b;
		int big=a>b?a:b;
		int GCD=-1;
		int LCM=-1;
		
		for(int i=1;i<=small;i++) {
			if(a%i==0&&b%i==0) GCD=i;
		}
		
		for(int i=1;i<=small;i++) {
			LCM=big*i;
			if(LCM%a==0&&LCM%b==0) {
				break;
			}
		}
		System.out.println(GCD);
		System.out.println(LCM);
	}
}
