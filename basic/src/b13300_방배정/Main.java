package b13300_방배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int K = Integer.parseInt(inp[1]);

		int[][] student = new int[2][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			student[gender][grade - 1]++;
		}
		int room = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				room+=(student[i][j]/K);
				if(student[i][j]%K!=0) room++;
			}
		}
		System.out.println(room);
	}

}
