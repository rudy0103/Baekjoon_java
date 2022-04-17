package b23288_주사위굴리기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

//주사위가 이동 방향으로 한 칸 굴러간다. 만약, 이동 방향에 칸이 없다면, 이동 방향을 반대로 한 다음 한 칸 굴러간다.
//주사위가 도착한 칸 (x, y)에 대한 점수를 획득한다.
//주사위의 아랫면에 있는 정수 A와 주사위가 있는 칸 (x, y)에 있는 정수 B를 비교해 이동 방향을 결정한다.
//A > B인 경우 이동 방향을 90도 시계 방향으로 회전시킨다.
//A < B인 경우 이동 방향을 90도 반시계 방향으로 회전시킨다.
//A = B인 경우 이동 방향에 변화는 없다.

public class Main {

	static int[] dr = { 0, 1, 0, -1 };// 동남서북
	static int[] dc = { 1, 0, -1, 0 };

	static class Dice {
		int r;
		int c;
		int d;
		int top;
		int east;
		int north;

		public Dice(int r, int c, int d, int top, int east, int north) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.top = top;
			this.east = east;
			this.north = north;
		}

		public int getOpposite(int n) {
			if (n == 1)
				return 6;
			if (n == 2)
				return 5;
			if (n == 3)
				return 4;
			if (n == 4)
				return 3;
			if (n == 5)
				return 2;
			if (n == 6)
				return 1;
			return -1;
		}

		public void move() {
			// 동남서북
			// 동쪽으로 이동할 때 top은 동쪽이 되고 동쪽은 bottom 동쪽의 opposite가 top
			if (this.d == 0) {
				int top = this.getOpposite(this.east);
				int east = this.top;
				this.top = top;
				this.east = east;
			} else if (this.d == 1) {
				// 남쪽으로 이동할 때, north는 top의 opp, top은 north
				int north = this.getOpposite(this.top);
				int top = this.north;
				this.north = north;
				this.top = top;
			} else if (this.d == 2) {
				// 서쪽으로 이동할 때 동쪽은 top의 opp,top은 east
				int top = east;
				int east = this.getOpposite(this.top);
				this.top = top;
				this.east = east;
			} else {
				// 북쪽으로 이동할 때 north는 top top은 north의 opp;
				int north = top;
				int top = this.getOpposite(this.north);
				this.north = north;
				this.top = top;
			}
			
			this.r=this.r+dr[d];
			this.c=this.c+dc[d];

		}

		public void turnClock() {
			
			if(this.d==3) this.d=0;
			else ++this.d;
			
		}

		public void turnCountClock() {
			if(this.d==0) this.d=3;
			else --this.d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] mul = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		initMul(map, mul);

		int res = getRes(map, mul, K);
		System.out.println(res);
	}

	private static int getRes(int[][] map, int[][] mul, int k) {

		int res = 0;

		Dice dice = new Dice(0, 0, 0, 1, 3, 2);

		for (int i = 0; i < k; i++) {
			res += getScore(map, mul, dice);
		}

		return res;
	}

	private static int getScore(int[][] map, int[][] mul, Dice dice) {

		int r = dice.r;
		int c = dice.c;
		int d = dice.d;

		int nr = r + dr[d];
		int nc = c + dc[d];

		if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
			dice.d = oppositeDir(dice.d);
			d = dice.d;
			nr = r + dr[d];
			nc = c + dc[d];
		}
		next(map, mul, dice);

		return map[nr][nc] * mul[nr][nc];
	}

	private static int oppositeDir(int d) {
		// 동남서북
		if (d == 0)
			return 2;
		if (d == 1)
			return 3;
		if (d == 2)
			return 0;
		if (d == 3)
			return 1;

		return 0;
	}

	private static void next(int[][] map, int[][] mul, Dice dice) {

		int r = dice.r;
		int c = dice.c;
		int d = dice.d;

		int nr = r + dr[d];
		int nc = c + dc[d];

		int num = map[nr][nc];
		dice.move();
		int bottom = dice.getOpposite(dice.top);

		if(num==bottom) return;
		else if(num<bottom) {//시계 방향 90도
			dice.turnClock();
		}else {
			dice.turnCountClock();
		}
		
	}

	private static void initMul(int[][] map, int[][] mul) {

		int R = mul.length;
		int C = mul[0].length;

		boolean[][] visited = new boolean[R][C];

		ArrayDeque<int[]> dq = new ArrayDeque<>();
		Stack<int[]> st = new Stack<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[i][j])
					continue;
				dq.add(new int[] { i, j });
				st.add(new int[] { i, j });
				visited[i][j] = true;

				while (!dq.isEmpty()) {

					int[] curr = dq.poll();

					for (int d = 0; d < 4; d++) {
						int nr = curr[0] + dr[d];
						int nc = curr[1] + dc[d];

						if (nr >= R || nr < 0 || nc >= C || nc < 0 || visited[nr][nc] || map[nr][nc] != map[i][j])
							continue;
						visited[nr][nc] = true;

						dq.add(new int[] { nr, nc });
						st.add(new int[] { nr, nc });

					}
				}

				int cnt = st.size();
				while (!st.isEmpty()) {
					int[] curr = st.pop();
					mul[curr[0]][curr[1]] = cnt;
				}
			}
		}

	}

	private static void print(int[][] map) {

		System.out.println("@@@@@@@@@@@@@");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
