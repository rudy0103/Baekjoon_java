package b10871_X보다작은수;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (n < X)
				System.out.print(n + " ");
		}
	}
}
