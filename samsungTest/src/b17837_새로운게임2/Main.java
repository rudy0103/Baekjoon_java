package b17837_새로운게임2; //1시간 30분 , 문제 잘 읽었으면 1시간 10분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*턴 한 번은 1번 말부터 K번 말까지 순서대로 이동시키는 것이다. 한 말이 이동할 때 위에 올려져 있는 말도 함께 이동한다. 말의 이동 방향에 있는 칸에 따라서 말의 이동이 다르며 아래와 같다. 턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료된다.

A번 말이 이동하려는 칸이
흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.
예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.
빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
A, B, C가 이동하고, 이동하려는 칸에 말이 없는 경우에는 C, B, A가 된다.
A, D, F, G가 이동하고, 이동하려는 칸에 말이 E, C, B로 있는 경우에는 E, C, B, G, F, D, A가 된다.
파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다. 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 가만히 있는다.
체스판을 벗어나는 경우에는 파란색과 같은 경우이다.
 * 
 * */

public class Main {

	static boolean finished = false;
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	static int[][] map;
	static int N, K;
	static ArrayList<Integer>[][] loc;
	static ArrayList<Horse> list = new ArrayList<>();

	static class Horse {
		int n;
		int r;
		int c;
		int d;// 우좌상하 1,2,3,4

		public Horse(int r, int c, int d, int n) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.n = n;
		}

		public void moveRC(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public void move() {
			int r = this.r;
			int c = this.c;
			int nr = this.r + dr[this.d];
			int nc = this.c + dc[this.d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 2) {
				changeDir();
				nr = this.r + dr[this.d];
				nc = this.c + dc[this.d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 2) {
					return;
				} else {
					this.move();
				}
			} else if (map[nr][nc] == 0) {/// 하얀색인 경우
				int idx = -1;
				for (int i = 0; i < loc[r][c].size(); i++) {
					if (loc[r][c].get(i) == this.n) {
						idx = i;
						break;
					}
				}

				for (int i = idx; i < loc[r][c].size(); i++) {
					loc[nr][nc].add(loc[r][c].get(i));
				}
				for (int i = loc[r][c].size() - 1; i >= idx; i--) {
					list.get(loc[r][c].get(i)).moveRC(nr, nc);
					if (loc[nr][nc].size() >= 4) //4개 이상.. 문제를 잘 읽자
						finished =true;
					loc[r][c].remove(i);
				}

			} else if (map[nr][nc] == 1) {// 빨간색인 경우

				int idx = -1;
				for (int i = 0; i < loc[r][c].size(); i++) {
					if (loc[r][c].get(i) == this.n) {
						idx = i;
						break;
					}
				}

				for (int i = loc[r][c].size() - 1; i >= idx; i--) {
					loc[nr][nc].add(loc[r][c].get(i));
					list.get(loc[r][c].get(i)).moveRC(nr, nc);
					if (loc[nr][nc].size() >= 4) //4개 이상.. 문제를 잘 읽자
						finished =true;
					loc[r][c].remove(i);
				}
			}
		}

		public void changeDir() {
			if (this.d == 1)
				this.d = 2;
			else if (this.d == 2)
				this.d = 1;
			else if (this.d == 3)
				this.d = 4;
			else
				this.d = 3;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		// 0 흰색
		// 1 빨간색
		// 2 파랑색
		loc = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				loc[i][j] = new ArrayList<>();
			}
		}
		list.add(new Horse(-1, -1, -1, 0));
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			list.add(new Horse(r, c, d, i + 1));
			loc[r][c].add(i + 1);

		}
		int turn = 1;


		while (turn <= 1000 && !finished) {
			for (int i = 1; i <= K; i++) {// K개의 말을 K번 이동

				list.get(i).move();
			}
			if(!finished)
				turn++;
		}

		if(turn<=1000)
			System.out.println(turn);
		else System.out.println(-1);

	}


	private static void printLoc() {

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print("{");
				for (Integer n : loc[i][j]) {
					System.out.print(n + ",");
				}
				System.out.print("} ");
			}
			System.out.println();
		}

		for(int i=1;i<=K;i++) {
			System.out.print(list.get(i).d+" ");
		}
		System.out.println();
		

	}

}
