package b7662_이중우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		
		PriorityQueue<int []> minQ = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		PriorityQueue<int []> maxQ = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[0], o1[0]);
			}
		});
		
		for(int tc = 0; tc<T; tc++) {
			int K=Integer.parseInt(br.readLine());
			int idx=0;
			boolean [] visited=new boolean[K];
			while(K-->0) {
				st=new StringTokenizer(br.readLine()," ");
				if(st.nextToken().equals("I")) {
					int tmp=Integer.parseInt(st.nextToken());
					maxQ.add(new int[] {tmp,idx});
					minQ.add(new int[] {tmp,idx});
					visited[idx++]=true;
				}else {
					if(st.nextToken().equals("1")) {
						while (!maxQ.isEmpty()&&visited[maxQ.peek()[1]]==false) {
							maxQ.poll();
						}
						if(!maxQ.isEmpty()) {
							visited[maxQ.peek()[1]]=false;
							maxQ.poll();
						}
					}else {
						while (!minQ.isEmpty()&&visited[minQ.peek()[1]]==false) {
							minQ.poll();
						}
						if(!minQ.isEmpty()) {
							visited[minQ.peek()[1]]=false;
							minQ.poll();
						}
						
					}
				}
			}

			while (!maxQ.isEmpty()&&visited[maxQ.peek()[1]]==false) {
				maxQ.poll();
			}
			while (!minQ.isEmpty()&&visited[minQ.peek()[1]]==false) {
				minQ.poll();
			}
			
			
			if(maxQ.isEmpty()&&minQ.isEmpty()) sb.append("EMPTY\n");
			else {
				int max=Integer.MIN_VALUE;
				int min=Integer.MAX_VALUE;
				
				if(!maxQ.isEmpty()) {
					if(maxQ.peek()[0]>max) max=maxQ.peek()[0];
					if(maxQ.peek()[0]<min) min=maxQ.peek()[0];
				}
				if(!minQ.isEmpty()) {
					if(minQ.peek()[0]>max) max=minQ.peek()[0];
					if(minQ.peek()[0]<min) min=minQ.peek()[0];
				}
				sb.append(max+" "+ min+"\n");
			}
			maxQ.clear();
			minQ.clear();
		}
		System.out.println(sb.toString());
	}
}
