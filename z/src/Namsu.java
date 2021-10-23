import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Namsu {
	int result, N, M, map[][], delta[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	int numOfRainbow;

	public int shark(int arg1, int arg2, int[][] map2) {
		N = arg1;
		M = arg2;
		result = 0;
		map = map2;
		boolean debug = false;

		while (true) {
			PriorityQueue<int[]> block = new PriorityQueue<>();
			boolean[][] visited = new boolean[N][N];
			int rainbow = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {// 일반블록이면서 현재선택된 그룹이 아니면
						PriorityQueue<int[]> temp = bfs(i, j);// 그룹찾기
						if (debug) {
							System.out.println(i + ", " + j + " : " + temp.peek()[0] + ", " + temp.peek()[1]);
						}
						if (block.size() < temp.size()) {// 크기가 큰게 우선
							block = temp;
							rainbow = numOfRainbow;
							visited = check(block, new boolean[N][N]);
						} else if (block.size() == temp.size()) {// 크기가 같으면
							if (rainbow < numOfRainbow) {// 무지개블록이 많은게 우선
								block = temp;
								rainbow = numOfRainbow;
								visited = check(block, new boolean[N][N]);
							} else if (rainbow == numOfRainbow) {// 무지개불록 개수도 같으면
								if (block.peek()[0] > temp.peek()[0]) {// 기준블록이 아래쪽에 있는게 우선
									block = temp;
									visited = check(block, new boolean[N][N]);
								} else if (block.peek()[0] == i) {// 기준블록 행이 같으면
									if (block.peek()[1] > temp.peek()[1]) {
										block = temp;// 기준블록이 오른쪽에 있는게 우선
										visited = check(block, new boolean[N][N]);
									}
								}
							}
						}
					}
				}
			}
			if (block.size() < 2)
				break;
			result += block.size() * block.size();
			while (!block.isEmpty()) {
				int[] cur = block.poll();
				if (debug) {
					System.out.print(Arrays.toString(cur) + ", ");
				}
				map[cur[0]][cur[1]] = -2;
			}
			if (debug) {
				System.out.println();
				System.out.println("after eleminate----------------------------------------");
				printMap();
			}
			fall();
//	         gravity();
			if (debug) {
				System.out.println("after fall----------------------------------------");
				printMap();
			}
			map = rotation();
//	         turn90();
			if (debug) {
				System.out.println("after lotation----------------------------------------");
				printMap();
			}
			fall();
//	         gravity();
			if (debug) {
				System.out.println("after fall----------------------------------------");
				printMap();
				System.out.println(result);
			}
		}
		return (result);
	}

	private boolean[][] check(Queue<int[]> block, boolean[][] visited) {
		for (int k = 0; k < block.size(); k++) {
			int[] cur = block.poll();
			visited[cur[0]][cur[1]] = true;
			block.offer(cur);
		}
		return visited;
	}

	PriorityQueue<int[]> bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		PriorityQueue<int[]> block = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (map[o1[0]][o1[1]] > 0 && map[o2[0]][o2[1]] > 0 && o1[0] == o2[0])
					return o1[1] - o2[1];
				else if (map[o1[0]][o1[1]] > 0 && map[o2[0]][o2[1]] > 0 && o1[0] != o2[0])
					return o1[0] - o2[0];
				return 0;
			}
		});
//	      Queue<int[]> block = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		numOfRainbow = 0;

		visited[r][c] = true;
		queue.offer(new int[] { r, c });
		block.offer(new int[] { r, c });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + delta[i][0];
				int nc = cur[1] + delta[i][1];
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && (map[nr][nc] == 0 || map[nr][nc] == map[r][c])
						&& !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
					block.offer(new int[] { nr, nc });
					if (map[nr][nc] == 0) {
						numOfRainbow++;
					}
				}
			}
		}
		return block;
	}

	int[][] rotation() {
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res[i][j] = map[j][N - 1 - i];
			}
		}
		return res;
	}

	void fall() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int floor;
		for (int i = 0; i < N; i++) {
			floor = N - 1;
			for (int j = 0; j < N; j++) {
				if (map[N - 1 - j][i] >= 0) {// 일반블록이면
					queue.offer(map[N - 1 - j][i]);
					map[N - 1 - j][i] = -2;
				} else if (map[N - 1 - j][i] == -1) {// 검은 블록을 만나면
					// 큐에 담긴 블록 아래로 내리기
					while (!queue.isEmpty()) {
						map[floor][i] = queue.poll();
						floor--;
					}
					floor = N - 1 - j - 1;
				}
			}
			while (!queue.isEmpty()) {
				map[floor][i] = queue.poll();
				floor--;
			}
		}
	}

	void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1) {
					sb.append("#" + " ");
				} else if (map[i][j] == -2) {
					sb.append("." + " ");
				} else {
					sb.append(map[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}