package b1504_특정한최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] adjMatrix = new int[N + 1][N + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (adjMatrix[a][b] == 0) {
				adjMatrix[a][b] = c;
			} else
				adjMatrix[a][b] = Math.min(adjMatrix[a][b], c);

			adjMatrix[b][a] = adjMatrix[a][b];
		}
		st = new StringTokenizer(br.readLine());

		int pointA = Integer.parseInt(st.nextToken());
		int pointB = Integer.parseInt(st.nextToken());


		// 1->a->b->4;
		// 1->b->a->4;
		long res=-1;
		long path1 = dijkstra(1, pointA, adjMatrix) + dijkstra(pointA, pointB, adjMatrix) + dijkstra(pointB, N, adjMatrix);
		long path2 = dijkstra(1, pointB, adjMatrix) + dijkstra(pointB, pointA, adjMatrix) + dijkstra(pointA, N, adjMatrix);
		res=Math.min(path1, path2);
		
		if(res>=Integer.MAX_VALUE)
			System.out.println(-1);
		else System.out.println(res);

	}

	private static long dijkstra(int start, int end, int[][] adjMatrix) {

		int N = adjMatrix.length;
		if (start == end)
			return 0;

		boolean[] visited = new boolean[N];
		int[] cost = new int[N];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;


		while (start != -1) {

			visited[start] = true;

			for (int i = 1; i < N; i++) {
				if (visited[i] || adjMatrix[start][i] == 0)
					continue;
				cost[i] = Math.min(cost[i], cost[start] + adjMatrix[start][i]);
			}

			start = -1;

			int tmp = Integer.MAX_VALUE;
			for (int i = 1; i < N; i++) {
				if (visited[i])
					continue;
				if (cost[i] < tmp) {
					tmp = cost[i];
					start = i;
				}
			}

		}

		return (long)cost[end];
	}

}
