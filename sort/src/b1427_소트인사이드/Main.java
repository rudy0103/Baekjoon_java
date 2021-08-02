package b1427_소트인사이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] inp=br.readLine().toCharArray();
		Arrays.sort(inp);
		StringBuilder sb=new StringBuilder(String.valueOf(inp));
		System.out.println(sb.reverse().toString());
	}
}
