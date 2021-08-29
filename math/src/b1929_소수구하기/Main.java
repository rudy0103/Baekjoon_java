package b1929_소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean isPrime(int n) {
		if(n==1) return false;
		for(int i=3;i<=Math.sqrt(n);i+=2) {
			if(n%i==0) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inp=br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int M= Integer.parseInt(inp[0]);
		int N= Integer.parseInt(inp[1]);
		if(M==2||(M==1&&N>=2)) sb.append("2\n");
		for(int i=M;i<=N;i++) {
			if(i%2!=0&&isPrime(i)) sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}
