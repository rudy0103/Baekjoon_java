package b11050_이항계수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int factorial(int n) {
		if(n==1||n==0) return 1;
		return n*factorial(n-1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inp=br.readLine().split(" ");
		int N= Integer.parseInt(inp[0]);
		int K= Integer.parseInt(inp[1]);
		
		int res=factorial(N)/(factorial(K)*factorial(N-K));
		System.out.println(res);

	}
}
