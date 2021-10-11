package b1043_거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = M;
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");

		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < k; i++)
			set.add(Integer.parseInt(st.nextToken()));

		ArrayList<HashSet<Integer>> list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int l = Integer.parseInt(st.nextToken());
			HashSet<Integer> tmpSet = new HashSet<>();
			for (int j = 0; j < l; j++) {
				tmpSet.add(Integer.parseInt(st.nextToken()));
			}
			list.add(tmpSet);
		}

		for (int a = 0; a < M; a++) {
			for (int i = 0; i < M; i++) {
				for (int n : list.get(i)) {
					if (set.contains(n)) {
						for (int nn : list.get(i)) {
							set.add(nn);
						}
						break;
					}
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int n : list.get(i)) {
				if (set.contains(n)) {

					cnt--;
					break;

				}
			}
		}
		System.out.println(cnt);

	}

}
