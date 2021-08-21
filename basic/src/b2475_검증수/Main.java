package b2475_검증수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int sum = 0;

		for (String s : inp)
			sum += (Integer.parseInt(s) * Integer.parseInt(s));

		System.out.println(sum % 10);
	}
}
