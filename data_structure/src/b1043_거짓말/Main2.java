package b1043_거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

	static int tmp;

	public static void make(int[] arr) {
		for (int i = 1; i < arr.length; i++)
			arr[i] = i;
	}

	public static int find(int x, int[] arr) {
		if (x == arr[x])
			return x;
		else
			return arr[x] = find(arr[x], arr);
	}

	public static void union(int a, int b, int[] arr) {
		int A = find(a, arr);
		int B = find(b, arr);

		if (A == tmp)
			arr[B] = A;
		else
			arr[A] = B;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = M;
		st = new StringTokenizer(br.readLine(), " ");

		int k = Integer.parseInt(st.nextToken());
		if (k == 0) {
			System.out.println(M);
		} else {
			int[] arr = new int[N + 1];
			make(arr);
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();

			tmp = Integer.parseInt(st.nextToken());
			for (int i = 0; i < k - 1; i++)
				arr[Integer.parseInt(st.nextToken())] = tmp;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int l = Integer.parseInt(st.nextToken());
				ArrayList<Integer> li = new ArrayList<>();
				for (int j = 0; j < l; j++) {
					li.add(Integer.parseInt(st.nextToken()));
				}
				list.add(li);
			}

			for (int i = 0; i < M; i++) {
				int size = list.get(i).size();
				if (size == 0 || size == 1)
					continue;
				for (int j = 0; j < size - 1; j++) {
					union(list.get(i).get(j), list.get(i).get(j + 1), arr);
				}
			}
			for(int i=0;i<=N;i++) find(i, arr);
			for (int i = 0; i < M; i++) {
				for (int n : list.get(i)) {
					if (arr[n] == tmp) {
						cnt--;
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
