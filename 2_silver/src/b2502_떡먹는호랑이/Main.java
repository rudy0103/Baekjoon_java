package b2502_떡먹는호랑이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] mm = new int[D + 1][2];

		mm[1][0] = 1;
		mm[2][1] = 1;
		for (int i = 3; i <= D; i++) {
			mm[i][0] = mm[i - 1][0] + mm[i - 2][0];
			mm[i][1] = mm[i - 1][1] + mm[i - 2][1];
		}

		int tmp = mm[D][0] + mm[D][1];

		int A = K / tmp;

		int ansA = -1;
		int ansB = -1;
		for (int a = 1; a <= A + 1; a++) {
			if (ansA != -1)
				break;
			int B = (K - a * mm[D][0]) / mm[D][1];
			for (int b = B; b <= K; b++) {
				if (a * mm[D][0] + b * mm[D][1] > K)
					break;
				else if (a * mm[D][0] + b * mm[D][1] == K) {
					ansA = a;
					ansB = b;
					break;
				}
			}
		}
		System.out.println(ansA + "\n" + ansB);
	}
}
