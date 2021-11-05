package b1715_카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		long totalCnt = 0L;
		while (pq.size() > 1) {
			int A=pq.poll();
			int B=pq.poll();
			int tmp=A+B;
			totalCnt+=tmp;
			pq.add(tmp);
		}
		System.out.println(totalCnt);

	}

}
