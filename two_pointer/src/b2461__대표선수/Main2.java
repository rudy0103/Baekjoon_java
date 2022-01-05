package b2461__대표선수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main2 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] players = new int[N * M][2];
		int[] team = new int[N];

		int k = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int power = Integer.parseInt(st.nextToken());
				players[k][0]=power;
				players[k++][1]=i;
			}
		}

		Arrays.sort(players, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}

		});

		int pos = getFirstPos(players, team, N, M);

		int len = N * M;
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < len - N; i++) {
			int[] min = players[i];
			int[] max = players[pos];

			result = Math.min(result, max[0] - min[0]);
			team[min[1]]--;

			while (pos < len-1 && team[min[1]] == 0) {
				team[players[++pos][1]]++;
			}
			if(team[min[1]]==0) break;
		}
		System.out.println(result);
	}

	private static int getFirstPos(int[][] players, int[] team, int n, int m) {

		int cnt = 1;
		int pos = 1;
		int[] min = players[0];
		team[min[1]]++;
		int len = n * m;
		while (pos < len) {
			int[] next = players[pos];
			if (team[next[1]] == 0) {
				cnt++;
			}
			team[next[1]]++;
			if (cnt == n) {
				break;
			}
			pos++;
		}
		return pos;
	}

}
