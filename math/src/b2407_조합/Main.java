package b2407_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		BigInteger res = new BigInteger("1");
		for (int i = 0; i < m; i++) {
			BigInteger bigN = new BigInteger(Integer.toString((n - i)));
			res=res.multiply(bigN);
		}

		for (int i = 0; i < m; i++) {
			BigInteger bigM = new BigInteger(Integer.toString((i + 1)));
			res=res.divide(bigM);
		}

		System.out.println(res.toString());
	}
}
