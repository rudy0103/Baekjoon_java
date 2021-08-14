package b17135_캐슬디펜스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m, d, maxKill;
	static int[][] origin; // 맵의 초기상태를 저장하는 배열
	static int[] archer = new int[3]; // 궁수의 위치를 저장하는 배열

	static boolean isFinished(int[][] map, int turn) {
		for (int i = turn; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) // 적이 있으면 끝난게 아님 -> false 리턴
					return false;
			}
		}
		return true;
	}

	static int doTurn(int[][] map, int turn) {
		Queue<int[]> target = new LinkedList<>(); // 턴마다 궁수가 쏘게되는 적을 넣음
		int kill = 0;
		for (int a = 0; a < archer.length; a++) {
			int er = 99; // 적의 행 위치를 저장하는 곳
			int ec = 99; // 적의 열 위치를 저장하는 곳
			int dist = d; // 최대사거리로 초기값을 정함
			for (int r = n - 1; r >= turn; r--) {
				for (int c = 0; c < m; c++) {
					if (map[r][c] == 1) {
						int ed = Math.abs(n - r) + Math.abs(archer[a] - c);// 적과의 거리를 구함
						if (ed < dist) { // 궁수마다 가장 가까운 적을 구하고 적의 위치를 저장
							dist = ed;
							er = r;
							ec = c;
						} else if (dist == ed && c <= ec) { // 거리가 같은 적이 여러명일 경우 왼쪽놈 우선
							er = r;
							ec = c;
						}
					}
				}
			}
			if (er != 99)
				target.add(new int[] { er, ec }); // 거리가 갱신->쏠 적을 구했다는 의미
		}

		while (!target.isEmpty()) { // 궁수 3명의 타겟이 들어 있음 (적은 3명이하)
			int[] t = target.poll();
			if (map[t[0]][t[1]] == 1) { // 아직 살아있는 적이면 kill++
				kill++;
				map[t[0]][t[1]] = 0; // 죽였다고 바꿈(동시에 같은 적을 공격하여 킬을 올리는걸 방지)
			}
		}

		for (int r = n - 1; r > turn; r--) { // 궁수의 공격이 끝나면 적들이 1칸 전진
			for (int c = 0; c < m; c++) {
				map[r][c] = map[r - 1][c];
			}
		}
		if (turn == 0)
			for (int c = 0; c < m; c++) // 전진이 끝났으니 맨 위는 다 0으로 초기화
				map[0][c] = 0;

		return kill; // 이번턴에 죽인 적의 수를 리턴
	}

	static void playGame() {
		int[][] map = new int[n][m];
		int kill = 0;
		int turn = 0;
		for (int i = 0; i < n; i++) { // 맵의 초기상태를 복사해야함, 매 배치마다 새롭게 해야하기 때문
			System.arraycopy(origin[i], 0, map[i], 0, m);
		}

		while (!isFinished(map, turn)) { // 적이 남아 있을 경우 턴을 계속 진행
			kill += doTurn(map, turn);
			turn++;
		}

		maxKill = kill > maxKill ? kill : maxKill; // 게임이 끝나기 전에 maxKill 갱신
	}

	static void makeCombination(int cnt, int start) {
		if (cnt == 3) {
			playGame();// 궁수의 배치마다 playGame
		} else {
			for (int i = start; i < m; i++) {
				archer[cnt] = i;
				makeCombination(cnt + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] inp = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		d = Integer.parseInt(inp[2]);
		origin = new int[n][m];
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				origin[i][j] = Integer.parseInt(inp[j]);
			}
		}

		makeCombination(0, 0);
		bw.write(maxKill + "");
		bw.close();
	}
}
