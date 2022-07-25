package b2217_로프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}

		long max = 0;

		while (!pq.isEmpty()) {
			max = Math.max(max, pq.size() * pq.poll());
		}

		System.out.println(max);

	}

}
