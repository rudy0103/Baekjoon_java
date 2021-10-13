package b16235_나무재테크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] farm, energy;

	static class Tree {
		int r;
		int c;
		int age;
		boolean died = false;

		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}

		public void growUp() {
			if (farm[this.r][this.c] >= age) {
				farm[r][c] -= age;
				age++;
			} else {
				died = true;
			}
		}

		public void goEnergy() {
			farm[r][c] += age / 2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 좌상부터 시계방향
		int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

		int N = Integer.parseInt(st.nextToken()); // N by N
		int M = Integer.parseInt(st.nextToken()); // 나무 정보 1<=M<=N2
		int K = Integer.parseInt(st.nextToken()); // K년 후 몇개의 나무가 살아 있냐? 1<=K<=1000

		farm = new int[N][N];
		energy = new int[N][N]; // 겨울에 추가되는 양분

		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				energy[i][j] = Integer.parseInt(st.nextToken());
				farm[i][j] = 5;
			}
		}
		// 나이가 작은 나무 부터 양분 먹을 수 있게
		PriorityQueue<Tree> pq = new PriorityQueue<>(new Comparator<Tree>() {
			@Override
			public int compare(Tree o1, Tree o2) {
				return Integer.compare(o1.age, o2.age);
			}
		});

		ArrayDeque<Tree> aliveTree = new ArrayDeque<>();
		ArrayDeque<Tree> deadTree = new ArrayDeque<>();

		for (int i = 0; i < M; i++) { // M개의 나무를 심음
			st = new StringTokenizer(br.readLine(), " ");
			Tree tree = new Tree(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1,
					Integer.parseInt(st.nextToken()));
			pq.add(tree);
		}

		while (K-- > 0) {
			// 봄 자라기
			while (!pq.isEmpty()) {
				Tree tree = pq.poll();
				tree.growUp();

				if (tree.died)
					deadTree.add(tree);
				else
					aliveTree.add(tree);
			}
			// 여름 양분으로
			while (!deadTree.isEmpty()) {
				deadTree.poll().goEnergy();
			}

			// 가을 번식
			while (!aliveTree.isEmpty()) {
				Tree tree = aliveTree.poll();
				pq.add(tree);

				if (tree.age % 5 == 0) {
					for (int d = 0; d < 8; d++) {
						int rr = tree.r + dr[d];
						int cc = tree.c + dc[d];
						if (rr >= 0 && rr < N && cc >= 0 && cc < N) {
							pq.add(new Tree(rr, cc, 1));
						}
					}
				}
			}

			// 겨울 양분 뿌리기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					farm[i][j] +=energy[i][j];
				}
			}
		}
		System.out.println(pq.size());

	}

}
