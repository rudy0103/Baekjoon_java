package b19236_청소년상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//22:40~12:20
public class Main {

	static int maxSum = 0;
	static int sharkIdx = -1;
	static int[] dr = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };

	static class Fish {
		int num;
		int r;
		int c;
		int d;//0~8 0은 죽은 물고기

		public Fish(int num, int r, int c, int d) {
			this.num = num;
			this.r = r;
			this.c = c;
			this.d = d;
		}

		public void move(int[][] map, ArrayList<Fish> list) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || map[nr][nc] == -1) {
				chageDir();
				move(map, list);
			} else {
				if (map[nr][nc] == 0) {
					map[r][c] = 0;
					map[nr][nc] = this.num;
					this.r = nr;
					this.c = nc;
				} else {
					Fish tmpFish = list.get(map[nr][nc]);
					map[r][c] = tmpFish.num;
					map[nr][nc] = this.num;
					tmpFish.r = this.r;
					tmpFish.c = this.c;
					this.r = nr;
					this.c = nc;
				}

			}

		}

		private void chageDir() {
			if (d == 8)
				d = 1;
			else
				d++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		ArrayList<Fish> list = new ArrayList<>();
		list.add(new Fish(0, -1, -1, -1));//인덱스 맞추기위해 넣음
		int[][] map = new int[4][4];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list.add(new Fish(num, i, j, d));
				map[i][j] = num;
			}
		}

		map[0][0] = -1; //0,0 상어로 시작
		maxSum = list.get(1).num; //처음 먹은 물고기
		sharkIdx = maxSum; // 처음 먹은 물고기인덱스가 상어가 됨

		sort(list);
		getMaxSum(list, map, maxSum);

		System.out.println(maxSum);
	}

	private static void getMaxSum(ArrayList<Fish> list, int[][] map, int sum) {

		maxSum = Math.max(maxSum, sum);//갱신
		
		for (Fish fish : list) { //물고기 이동
			if (fish.num != sharkIdx && fish.d > 0) {
				fish.move(map, list);
			}
		}
		Fish shark = list.get(sharkIdx);//상어 이동준비
		
		int nr = shark.r + dr[shark.d];
		int nc = shark.c + dc[shark.d];

		while (true) {
			if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) {//밖으로 나가면 끝
				return;
			} else {
				if (map[nr][nc] != 0) {// 물고기가 있으면
					ArrayList<Fish> newList = copyList(list);//새로운 리스트 만들기
					int[][] newMap = copyMap(map);// 새로운 맵 만들기
					int fishNum = map[nr][nc];// 먹을 물고기
					
					newMap[nr][nc] = -1;//먹은 물고기 위치
					newMap[shark.r][shark.c] = 0;//상어 원래 자리 0

					Fish dead = newList.get(fishNum);//죽은 물고기
					Fish newShark = newList.get(sharkIdx);//새 리스트에서 새 상어(위치, 방향 조정)

					newShark.d = dead.d;
					newShark.r = nr;
					newShark.c = nc;
					dead.d = 0;//죽은 물고기 방향은 0
					getMaxSum(newList, newMap, sum + dead.num);//새 리스트와, 새 맵을 넣어서 다시 함수 실행
				}
				nr += dr[shark.d];
				nc += dc[shark.d];
			}

		}

	}

	private static ArrayList<Fish> copyList(ArrayList<Fish> list) {

		ArrayList<Fish> newList = new ArrayList<>();

		for (Fish f : list) {
			Fish newFish = new Fish(f.num, f.r, f.c, f.d);
			newList.add(newFish);
		}

		return newList;
	}

	private static int[][] copyMap(int[][] map) {

		int[][] newMap = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				newMap[i][j] = map[i][j];
		}

		return newMap;
	}

	private static void sort(ArrayList<Fish> list) {
		Collections.sort(list, new Comparator<Fish>() {

			@Override
			public int compare(Fish o1, Fish o2) {
				return o1.num - o2.num;
			}
		});

	}

}
