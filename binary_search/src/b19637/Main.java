package b19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Power {
		String type;
		int p;
		int idx;

		public Power(String type, int p, int idx) {
			super();
			this.type = type;
			this.p = p;

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Power> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			Integer power = Integer.parseInt(st.nextToken());
			arr.add(new Power(type, power, i));
		}

		Collections.sort(arr, new Comparator<Power>() {
			@Override
			public int compare(Power o1, Power o2) {
				if (o1.p == o2.p)
					return o1.idx - o2.idx;
				else
					return o1.p - o2.p;
			}
		});

		int idx = 0;

		for (int i = 0; i < M; i++) {
			int cp = Integer.parseInt(br.readLine());
			idx = getIndex(arr, cp);
			sb.append(arr.get(idx).type).append("\n");

		}
		System.out.println(sb.toString());

	}

	private static int getIndex(ArrayList<Power> arr, int cp) {
		int left = 0;
		int right = arr.size() - 1;

		int idx = -1;
		while (left <= right) {

			int mid = (left + right) / 2;

			if (cp <= arr.get(mid).p) {
				idx = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		return idx;
	}



}
