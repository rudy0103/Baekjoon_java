import java.util.Scanner;

public class Main {

	public static int[] selected;
	public static boolean[] visited;
	public static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		if (M == 1) {//
			selected = new int[N];
			visited = new boolean[7];
			run1(0);
		} else if (M == 2) {

			selected = new int[N];
			visited = new boolean[7];
			run2(0, 1);
		} else {
			selected = new int[N];
			visited = new boolean[7];
			run3(0);

		}

	}

	private static void run1(int d) {
		if (d == N) {
			for (int i = 0; i < N; i++)
				System.out.print(selected[i] + " ");
			System.out.println();
			return;
		}

		for (int i = 1; i <= 6; i++) {
			selected[d] = i;
			run1(d + 1);
		}

	}

	private static void run2(int d, int s) {
		if (d == N) {
			for (int i = 0; i < N; i++)
				System.out.print(selected[i] + " ");
			System.out.println();
			return;
		}

		for (int i = s; i <= 6; i++) {
			selected[d] = i;
			run2(d + 1, i);

		}
	}

	private static void run3(int d) {
		if (d == N) {
			for (int i = 0; i < N; i++)
				System.out.print(selected[i] + " ");
			System.out.println();
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			selected[d] = i;
			run3(d + 1);
			visited[i] = false;

		}
	}

}
