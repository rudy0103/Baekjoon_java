package b18442_우체국;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int V, P;
	static long L;
	static long min;
	static long[] vil;// 마을 위치
	static int[] selected;
	static long[] res;
	static long[] distance;// 각 마을이 가장 가까운 곳과의 거리
	static StringBuilder sb = new StringBuilder();

	public static void backtracking(int d, int start) {
		if (d == P) {
			// 각 마을가 가장 가까운 경찰서와의 거리를 구하기위해 일단 초기화
			for (int i = 0; i < distance.length; i++)
				distance[i] = Long.MAX_VALUE;

			long dist = 0;
			for (int i = 0; i < V; i++) {// 각마을 마다
				for (int j = 0; j < selected.length; j++) {// 선택된 경찰서와의 거리 중 최소 구하기
					distance[i] = Math.min(distance[i],
							Math.min(Math.abs(vil[selected[j]] - vil[i]), (L) - Math.abs(vil[selected[j]] - vil[i])));
				}
				dist += distance[i];
			}

			if (dist < min) { // 거리의 합이 최소 보다 작으면 res에 저장
				min = dist;
				for (int i = 0; i < selected.length; i++)
					res[i] = vil[selected[i]];
			}

			return;
		}

		for (int i = start; i < V; i++) {
			selected[d] = i;
			backtracking(d + 1, i + 1);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " "); // V,P,L입력 받기
		min = Long.MAX_VALUE;// 최대로 초기화;
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());

		vil = new long[V];// 마을 위치
		selected = new int[P];// 경찰서 설치할 마을;
		res = new long[P];// 경찰서 설치할 최종 마을;
		distance = new long[V];// 각 마을가 가장 가까운 경찰서와의 거리

		st = new StringTokenizer(br.readLine(), " ");// 마을 위치 입력받기
		for (int i = 0; i < V; i++) {
				vil[i] = Long.parseLong(st.nextToken());
		}
		backtracking(0, 0);
		sb.append(min + "\n");
		for (int i = 0; i < P; i++)
			sb.append(res[i] + " ");
		System.out.println(sb.toString());
	}

}
