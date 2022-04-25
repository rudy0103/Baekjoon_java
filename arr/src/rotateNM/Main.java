package rotateNM;

import java.util.Random;

public class Main {
	static int N = 5;
	static int M = 4;

	public static void main(String[] args) {

		int[][] map = new int[N][M];

		Random rand = new Random();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = rand.nextInt(10);
			}
		}
		System.out.println("@@@@@origin");
		printMap(map);
		System.out.println("@@@@@@@@@@@@rotate90");
		printMap(rotate90(map));// 시계 방향
		System.out.println("@@@@@@@@@@@@rotate180  ");
		printMap(rotate180(map));
		System.out.println("@@@@@@@@@@rotate270");
		printMap(rotate270(map));

	}

	private static int[][] rotate90(int[][] map) {
		int N=map[0].length;
		int M=map.length;
		int[][] newMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[M - j - 1][i];
			}
		}
		return newMap;
	}

	private static int[][] rotate180(int[][] map) { //열은 같음
		int[][] newMap = new int[N][M]; //행렬의 크기 변함 X

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[N - i - 1][j]; //열이 같아 행만 바꾸면 됨
			}
		}
		return newMap;
	}

	private static int[][] rotate270(int[][] map) {
		int N=map[0].length;
		int M=map.length;
		int[][] newMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[j][N - i - 1];
			}
		}
		return newMap;
	}

	private static void printMap(int[][] map) {
		int nn=map.length;
		int mm=map[0].length;
		for (int i = 0; i < nn; i++) {
			for (int j = 0; j < mm; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}