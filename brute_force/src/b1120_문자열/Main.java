package b1120_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();

		int min = 123;

		int pos = 0;
		int maxPos = B.length - A.length;

		while (pos <= maxPos) {

			int cnt = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] != B[i + pos])
					cnt++;
			}
			min = Math.min(min, cnt);
			pos++;
		}

		System.out.println(min);

	}

}
