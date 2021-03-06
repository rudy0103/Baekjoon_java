package b1927_최소힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
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
