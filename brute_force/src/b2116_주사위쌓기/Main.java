package b2116_주사위쌓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int[][] dice;

	public static int findUpIndex(int down) {
		if (down == 0)
			return 5;
		if (down == 1)
			return 3;
		if (down == 2)
			return 4;
		if (down == 3)
			return 1;
		if (down == 4)
			return 2;
		else
			return 0;
	}

	public static int findMax(int upIndex, int downIndex, int depth) {
		int max = -1;

		for (int i = 0; i < 6; i++) {
			if (i == upIndex || i == downIndex)
				continue;
			if (dice[depth][i] > max)
				max = dice[depth][i];
		}
		return max;
	}

	public static int findDownIndex(int downVal, int depth) {
		for (int i = 0; i < 6; i++)
			if (dice[depth][i] == downVal)
				return i;

		return -1;
	}

	public static void stackDice(int upVal, int depth, int sum) {

		if (depth == dice.length) {
			if (sum > max)
				max = sum;
			return;
		}

		int downIndex = findDownIndex(upVal, depth);
		int upIndex = findUpIndex(downIndex);

		stackDice(dice[depth][upIndex], depth + 1, sum + findMax(upIndex, downIndex, depth));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++)
				dice[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 6; i++) {
			int upIndex = findUpIndex(i);
			stackDice(dice[0][upIndex], 1, findMax(upIndex, i, 0));// 0,1,2,3,4,5 번째 숫자가 들어감
		}
		System.out.println(max);
	}
}
