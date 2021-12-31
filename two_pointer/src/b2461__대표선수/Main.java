package b2461__대표선수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {

	static class Player {
		int power;
		int team;

		public Player(int power, int team) {
			this.power = power;
			this.team = team;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Player[] players = new Player[N * M];
		int[] team = new int[N];

		int k = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int power = Integer.parseInt(st.nextToken());
				players[k++] = new Player(power, i);
			}
		}

		Arrays.sort(players, new Comparator<Player>() {
			@Override
			public int compare(Player o1, Player o2) {
				return o1.power - o2.power;
			}
		});

		int pos = getFirstPos(players, team, N, M);

		int len = N * M;
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < len - M; i++) {
			Player min = players[i];
			Player max = players[pos];

			result = Math.min(result, max.power - min.power);
			team[min.team]--;

			while (pos < len-1 && team[min.team] == 0) {
				team[players[++pos].team]++;
			}
			if(team[min.team]==0) break;
		}
		System.out.println(result);
	}

	private static int getFirstPos(Player[] players, int[] team, int n, int m) {

		int cnt = 1;
		int pos = 1;
		Player min = players[0];
		team[min.team]++;
		int len = n * m;
		while (pos < len) {
			Player next = players[pos];
			if (team[next.team] == 0) {
				cnt++;
			}
			team[next.team]++;
			if (cnt == n) {
				break;
			}
			pos++;
		}
		return pos;
	}

}
