package b1253_좋다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashMap<Integer, Integer> hmap = new HashMap<>();
		HashMap<Integer, LinkedList<Integer>> idxMap = new HashMap<>();
		int cnt = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (hmap.containsKey(arr[i])) {
				int val = hmap.get(arr[i]);
				hmap.put(arr[i], val + 1);
				idxMap.get(arr[i]).add(i);
			} else {
				hmap.put(arr[i], 1);
				idxMap.put(arr[i], new LinkedList<>());
				idxMap.get(arr[i]).add(i);
			}
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int num = arr[i] + arr[j];
				if(arr[i]==0&&arr[j]==0) {
					if (idxMap.get(num).size() <= 2)
						continue;
				}
				if (num == arr[i]) {
					if (idxMap.get(num).size() == 1)
						continue;
				} else if (num == arr[j]) {
					if (idxMap.get(num).size() == 1)
						continue;
				}
				if (hmap.containsKey(num)) {
					int val = hmap.get(num);
					cnt += val;
					hmap.remove(num);
				}
			}
		}

		System.out.println(cnt);

	}

}
