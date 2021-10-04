package b9252_LCS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmpA = br.readLine();
		String tmpB = br.readLine();
		int N = tmpA.length(), M = tmpB.length();
		char[] A, B;
		A = new char[N + 1];
		B = new char[M + 1];
		for (int i = 1; i <= N; i++)
			A[i] = tmpA.charAt(i - 1);
		for (int i = 1; i <= M; i++)
			B[i] = tmpB.charAt(i - 1);

		int[][] dp = new int[N + 1][M + 1];

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o2[2] != o1[2])
					return o2[2] - o1[2];
				else if (o2[1] != o1[1])
					return o2[1] - o1[1];
				else
					return o2[0] - o1[0];
			}
		});

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (A[i] == B[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					pq.add(new int[] { i, j, dp[i][j] });
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[N][M]);

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		int cnt = dp[N][M];
		int i = 9999, j = 9999;
		char[] ch = new char[cnt];
		if (cnt > 0) {
			while (cnt != 0) {
				while(pq.peek()[2]!=cnt) pq.poll();
				int [] tmp=pq.poll();
				if (tmp[0] < i && tmp[1] < j && tmp[2] == cnt) {
					ch[cnt-1] = A[tmp[0]];
					cnt--;
					i=tmp[0];
					j=tmp[1];
				}
			}
		}
		System.out.println(String.valueOf(ch));
	}

}
