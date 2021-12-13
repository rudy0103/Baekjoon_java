package b16566_카드게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[tmp] = tmp;
		}
		int next = -1;

		for (int i = N; i > 0; i--) {
			if (i == arr[i]) {
				next = i;
			} else {
				arr[i] = next;
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < K; i++) {
			int cheolsu = Integer.parseInt(st.nextToken())+1;
			int res=find(cheolsu, arr);
			sb.append(res).append("\n");
			arr[res]=res+1;

		}

		System.out.println(sb.toString());

	}

	public static int find(int idx,int[] arr) {
		if (idx == arr[idx]) {
			return idx;
		} else {
			return arr[idx] = find(arr[idx],arr);
		}
	}

}
