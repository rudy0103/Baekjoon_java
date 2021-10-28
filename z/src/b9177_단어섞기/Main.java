package b9177_단어섞기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean flag;
	static String s1, s2, s3;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			s1 = st.nextToken();
			s2 = st.nextToken();
			s3 = st.nextToken();

			char[] A, B, C;
			A = new char[s1.length() + 1];
			B = new char[s2.length() + 1];
			C = new char[s3.length() + 1];
			
			for (int i = 1; i <= s1.length(); i++)
				A[i] = s1.charAt(i - 1);
			for (int i = 1; i <= s2.length(); i++)
				B[i] = s2.charAt(i - 1);
			for (int i = 1; i <= s3.length(); i++)
				C[i] = s3.charAt(i - 1);

			boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
			if (s1.charAt(0) == s3.charAt(0))
				dp[0][1] = true;
			if (s2.charAt(0) == s3.charAt(0))
				dp[1][0] = true;

			for (int i = 1; i <A.length; i++) {
				for (int j = 1; j <B.length; j++) {
					
				}
			}

			System.out.println("******************");
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@");

			if (dp[s1.length()][s2.length() ])
				sb.append("Data set " + tc + ": yes\n");
			else
				sb.append("Data set " + tc + ": no\n");

		}
		System.out.println(sb.toString());

	}

}
