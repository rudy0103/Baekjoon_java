package b2231_분해합;

import java.util.Scanner;

public class Main {
	public static int n;

	public static boolean func(int num) {

		int sum = num;
		String s = Integer.toString(num);

		for (int i = 0; i < s.length(); i++) {
			try {
				sum += Integer.parseInt(s.charAt(i) + "");
			} catch (NumberFormatException e) {
				System.out.println("넘버 에러" + num);
			}
		}

		if (sum == n)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = 10;
		int l = 0;
		while (n / k >= 1) {
			l++;
			k *= 10;
		}
		if (n < 20) {
			for (int i = 1; i <= n; i++) {
				if (func(i)) {
					System.out.println(i);
					break;
				}
				if (i == n) {
					System.out.println(0);
					break;
				}
			}

		} else {
			for (int i = n - 9 * (l+1); i <= n; i++) {
				if (func(i)) {
					System.out.println(i);
					break;
				}
				if (i == n) {
					System.out.println(0);
					break;
				}
			}
		}
	}
}
