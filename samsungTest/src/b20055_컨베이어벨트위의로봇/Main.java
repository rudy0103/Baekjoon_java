package b20055_컨베이어벨트위의로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int upIndex, N;
	static int downIndex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 내구도가 K개 이상이라면 과정을 종료한다.

		int[] belt = new int[2 * N];
		int[] durability = new int[2 * N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2 * N; i++) {
			durability[i] = Integer.parseInt(st.nextToken());
		}

		int step = 1;
		int cnt = 0;
		upIndex = 0;
		downIndex = N - 1;

		while (true) {
			upIndex = getBefore(upIndex);
			downIndex = getBefore(downIndex);
			if (belt[downIndex] == 1) {
				belt[downIndex] = 0; // 내리는 위치면 로봇을 내림
			}

			int pos = downIndex;
			for (int i = 0; i < N; i++) {// 내리는곳에서 가까운 로봇부터 이동
				int before = getBefore(pos);
				if (durability[pos] > 0 && belt[pos] == 0 && belt[before] == 1) {
					belt[before] = 0;
					belt[pos] = 1;
					durability[pos]--;
					if (durability[pos] == 0)
						cnt++;
				}
				pos = before;
			}

			if (belt[downIndex] == 1) {
				belt[downIndex] = 0; // 내리는 위치면 로봇을 내림
			}

			if (durability[upIndex] > 0) { // 올리는곳 내구도 0보다 크면
				durability[upIndex]--;
				if (durability[upIndex] == 0)
					cnt++;
				belt[upIndex] = 1;
			}

			if (cnt >= K)
				break;
			else
				step++;

		}
		System.out.println(step);
	}

	private static int getBefore(int n) {
		n--;
		if (n < 0)
			return 2 * N - 1;
		else
			return n;
	}

}
