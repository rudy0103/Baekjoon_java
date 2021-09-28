package b19583_싸이버개강총회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		HashMap<String, Integer> hMap = new HashMap<>();
		HashSet<String> hSet = new HashSet<>();
		String[] times = br.readLine().split(" ");

		String str = null;

		while ((str = br.readLine()) != null) {
			st = new StringTokenizer(str, " ");

			String time = st.nextToken();
			String name = st.nextToken();

			if (time.compareTo(times[0]) <= 0)// 개총 시작 전 입장
				hMap.put(name, 1);

			if (time.compareTo(times[1]) >= 0 && time.compareTo(times[2]) <= 0) { // 퇴장
				if (hMap.containsKey(name))
					hSet.add(name);
			}
		}
		System.out.println(hSet.size());
	}
}
