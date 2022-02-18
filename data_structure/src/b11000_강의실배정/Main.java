package b11000_강의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		int N=Integer.parseInt(br.readLine());
		
		
		PriorityQueue<int[] > pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0])
					return o1[0]-o2[0];
				else return o1[1]-o2[1];
			}
		});
		
		PriorityQueue<int[] > using = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
	
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			
			pq.add(new int[] {s,e});
			
			
		}
		
		while(!pq.isEmpty()) {
			
			if(using.isEmpty()) {
				using.add(pq.poll());
				continue;
			}
			int []lec=pq.poll();
			
			if(using.peek()[1]<=lec[0]) {
				using.poll();
				using.add(lec);
			}else {
				using.add(lec);
			}
				
			
		}
		
		System.out.println(using.size());
		
		
	}

}
