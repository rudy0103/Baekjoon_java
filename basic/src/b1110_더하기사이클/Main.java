package b1110_더하기사이클;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int next = N;
		int cnt = 0;

		do {

			next = (next%10)*10 +((next/10) +(next%10))%10;

			cnt++;

		} while (next != N);
		
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();

	}

}
