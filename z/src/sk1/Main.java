package sk1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {

		String[] goods = { "abcdeabcd", "cdabe", "abce", "bcdeab" };
		solution(goods);

		System.out.println(Arrays.toString(solution(goods)));

	}

	public static String[] solution(String[] goods) {

		int len = goods.length;
		String[] answer = new String[len];

		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (int i = 0; i < len; i++) {
			pq.clear();
			StringBuilder sb = new StringBuilder();
			HashSet<String> set = new HashSet<>();
			boolean findLen = false;

			for (int l = 1; l <= goods[i].length(); l++) {
				if (findLen)
					break;

				for (int k = 0; k < goods[i].length(); k++) {
					if (k + l - 1 < goods[i].length()) {
						String subString = goods[i].substring(k, k + l);
						int cnt = 0;
						for (int g = 0; g < len; g++) {
							if (g == i)
								continue;
							if (goods[g].contains(subString)) {
								cnt++;
								break;
							}
						}
						if (cnt > 0)
							continue;
						else {
							if (!set.contains(subString)) {
								pq.add(subString);
								set.add(subString);
							}
						}

					} else
						continue;

				}
				if (!pq.isEmpty()) {
					findLen = true;
					while (!pq.isEmpty())
						sb.append(pq.poll()).append(" ");
					sb.setLength(sb.length() - 1);
					answer[i] = sb.toString();
				}
			}
		}
		for (int i = 0; i < len; i++) {
			if (answer[i] == null)
				answer[i] = "None";
		}

		return answer;
	}
}
