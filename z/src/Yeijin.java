
import java.util.LinkedList;
import java.util.Queue;

//상어 중학교
public class Yeijin {
	int[][] map;
	int N;
	int M;
	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };

	public int shark(int arg1, int arg2, int[][] map2) {
		N = arg1; // 한 변의 크기
		M = arg2; // 색상의 개수
		map = map2;
		int score = 0;
		while (true) {
			// 가장 큰 blockGroup 찾기
			int[][] visited = new int[N][N];
			int n = 1;
			BlockGroup maxGroup = new BlockGroup(0, 0, -1, 0, n);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != -1 && map[i][j] != 0 && visited[i][j] == 0 && map[i][j] != -2) {
						BlockGroup result = findBlockGroup(i, j, visited, n);
						// maxGroup 갱신
						if (maxGroup.size < result.size) {
							maxGroup = new BlockGroup(i, j, result.size, result.rb, result.n);
							;
						} else if (maxGroup.size == result.size) {
							if (maxGroup.rb < result.rb) {
								maxGroup = new BlockGroup(i, j, result.size, result.rb, result.n);
								;
							} else if (maxGroup.rb == result.rb) {
								if (maxGroup.x < i) {
									maxGroup = new BlockGroup(i, j, result.size, result.rb, result.n);
									;
								} else if (maxGroup.x == i) {
									if (maxGroup.y < j) {
										maxGroup = new BlockGroup(i, j, result.size, result.rb, result.n);
										;
									}
								}
							}
						}
						n++;
					}
				}
			}
			if (maxGroup.size < 2) {
				break;
			}
			visited = new int[N][N];
			findBlockGroup(maxGroup.x, maxGroup.y, visited, -2);
			// remove block
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == -2) {
						map[i][j] = -2;
					}
				}
			}
			score += maxGroup.size * maxGroup.size;
			gravity();
			turn90();
			gravity();
		}
		return score;
	}

	// bfs
	BlockGroup findBlockGroup(int r, int c, int[][] visited, int n) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c });
		visited[r][c] = n;
		int size = 0;
		int rn = 0;
		while (!q.isEmpty()) {
			int[] temp = q.remove();
			int x = temp[0];
			int y = temp[1];
			size++;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] != n
						&& (map[nx][ny] == 0 || map[nx][ny] == map[r][c])) {
					visited[nx][ny] = n;
					q.add(new int[] { nx, ny });
					if (map[nx][ny] == 0) {
						rn++;
					}
				}
			}

		}
		return new BlockGroup(r, c, size, rn, n); // 기준 블록 x,y,size,RainbowNum
	}

	// gravity
	void gravity() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int floor;
		for (int i = 0; i < N; i++) {
			floor = N - 1;
			for (int j = 0; j < N; j++) {
				if (map[N - 1 - j][i] >= 0) {
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

	void turn90() {
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res[i][j] = map[j][N - 1 - i];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = res[i][j];
			}
		}
	}

	class BlockGroup {
		int x;
		int y;
		int size;
		int rb;
		int n;

		public BlockGroup(int x, int y, int size, int rb, int n) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.rb = rb;
			this.n = n;
		}

	}

}
