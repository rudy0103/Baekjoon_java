package b10974_모든순열;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		makePermutation(0, N, new int[N], new boolean[N], sb);
		System.out.println(sb.toString());

	}

	private static void makePermutation(int d, int N, int[] selected, boolean[] visited, StringBuilder sb) {

		if (d == N) {
			for (int i = 0; i < N; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i]=true;
			selected[d]=i+1;
			makePermutation(d+1, N, selected, visited, sb);
			visited[i]=false;
		}

	}

}
