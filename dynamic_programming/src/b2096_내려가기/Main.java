package b2096_내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[] max = new int[3];
		int[] min = new int[3];

		int[] next = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				next[j] = Integer.parseInt(st.nextToken());
			}

			int tmpMax0 = Math.max(max[0] + next[0], max[1] + next[0]);

			int tmpMax1 = Math.max(max[0] + next[1], max[1] + next[1]);
			tmpMax1 = Math.max(tmpMax1, max[2] + next[1]);

			int tmpMax2 = Math.max(max[2] + next[2], max[1] + next[2]);

			max[0] = tmpMax0;
			max[1] = tmpMax1;
			max[2] = tmpMax2;

//-----------------------------------------------------------------
			int tmpMin0 = Math.min(min[0] + next[0], min[1] + next[0]);

			int tmpMin1 = Math.min(min[0] + next[1], min[1] + next[1]);
			tmpMin1 = Math.min(tmpMin1, min[2] + next[1]);

			int tmpMin2 = Math.min(min[2] + next[2], min[1] + next[2]);

			min[0] = tmpMin0;
			min[1] = tmpMin1;
			min[2] = tmpMin2;

		}

		int resMax = 0;
		int resMin = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			if (resMax < max[i])
				resMax = max[i];
			if (resMin > min[i])
				resMin = min[i];
		}
		System.out.print(resMax + " " + resMin);

	}

}
