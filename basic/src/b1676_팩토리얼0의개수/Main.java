package b1676_팩토리얼0의개수;

import java.util.Scanner;

public class Main {

	static int two_cnt = 0;
	static int five_cnt = 0;

	public static void checkZero(int n) {

		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
				two_cnt++;
			} else if (n % 5 == 0) {
				n /= 5;
				five_cnt++;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 0)
			System.out.println(0);
		else {

			two_cnt = 0;
			five_cnt = 0;
			for (int i = 1; i <= n; i++) {
				checkZero(i);
			}
			System.out.println(two_cnt <= five_cnt ? two_cnt : five_cnt);
		}
	}
}
