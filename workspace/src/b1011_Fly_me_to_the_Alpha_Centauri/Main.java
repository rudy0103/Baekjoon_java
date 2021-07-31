package b1011_Fly_me_to_the_Alpha_Centauri;

import java.util.Scanner;

public class Main {

	public static int max;
	public static int min;
	public static int mid;

	public static void func(int goal, int n, int step, int cnt) {
		if (cnt > max || step <= 0 || goal < n) {
		} else {
			if (goal == n) {
				if ((step == 1) && min > cnt + 1) {
					min = cnt + 1;
				}
			} else {
				if (n + step - 1 < mid) {
					func(goal, n + step, step + 1, cnt + 1);
					func(goal, n + step, step, cnt + 1);
				} else {
					func(goal, n + step, step, cnt + 1);
					func(goal, n + step, step - 1, cnt + 1);
				}
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 1; i++) {
			min = Integer.MAX_VALUE;
			int x = sc.nextInt();
			int y = sc.nextInt();
			int distance = y - 1 - x;
			mid = x + distance / 2 + 1;
			int k = 1;
			while (k * (k + 1) / 2 <= distance / 2.0) {
				k++;
			}
			max = (k) * 2;
			func(y - 1, x, 1, 0);
			System.out.println(min);
		}
	}
}