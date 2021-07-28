package b10250_ACM호텔;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			sc.nextLine();
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			int room = 0;

			if (N % H != 0) {
				room += N % H * 100;
				room += N/H+1;
			} else {
				room += H * 100;
				room += N/H;
			}
			System.out.println(room);

		}

	}

}
