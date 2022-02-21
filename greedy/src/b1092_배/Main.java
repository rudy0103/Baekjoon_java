package b1092_배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int maxWeight = 0;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] crains = new int[N];

		for (int i = 0; i < N; i++)
			crains[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(crains);

		int M = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			int w = Integer.parseInt(st.nextToken());
			maxWeight = Math.max(maxWeight, w);
			pq.add(w);
		}

		if (maxWeight > crains[N - 1]) {
			System.out.println(-1);
		} else {
			ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();

			for (int i = 0; i < N; i++)
				list.add(new PriorityQueue<>(new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o2 - o1;
					}
				}));

			int time = 0;

			while (!pq.isEmpty()) {

				for (int i = 0; i < N; i++) {
					while (!pq.isEmpty() && crains[i] >= pq.peek())
						list.get(i).add(pq.poll());
				}

			}

			
			
			int totalCnt=0;
			
			while(totalCnt<M) {
				int cnt=0;
				
				for(int i=N-1;i>=0;i--) {
					if(!list.get(i).isEmpty()) {
						cnt++;
						list.get(i).poll();
					}else {
						int j=i-1;
						while(j>=0&&list.get(j).isEmpty()) j--;
						
						if(j>=0) {
							list.get(j).poll();
							cnt++;
						}
					}
				}
				
				totalCnt+=cnt;
				time++;
			}
			
			System.out.println(time);
		}

	}
}
