package b11279_최대힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int tmp=Integer.parseInt(br.readLine());
			if(pq.isEmpty()&&tmp==0) sb.append("0\n");
			else if(!pq.isEmpty()&tmp==0) sb.append(pq.poll()).append("\n");
			else pq.add(tmp);
		}
		System.out.println(sb.toString());
	}
}
