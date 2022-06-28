package b13335_트럭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static class Truck {
		int weight;
		int len;

		public Truck(int weight, int len) {
			super();
			this.weight = weight;
			this.len = len;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		ArrayDeque<Truck> trucks = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			trucks.add(new Truck(Integer.parseInt(st.nextToken()), W));
		}
		
		
		int time = 0;
		int cnt = 0;
		int sum = 0;
		
		ArrayDeque<Truck> dq = new ArrayDeque<>();
		
		
		while(true) {
			if(!trucks.isEmpty()&&sum+trucks.peekFirst().weight<=L&&dq.size()<W) {
				Truck t=trucks.pollFirst();
				sum+=t.weight;
				dq.add(t);
			}
			
			int size=dq.size();
			for(int i=0;i<size;i++) {
				Truck t=dq.pollFirst();
				
				if(--t.len==0) {
					sum-=t.weight;
					cnt++;
				}else dq.add(t);
				
			}
			
			time++;
			if(cnt>=N) {
				break;
			}
		}
		
		System.out.println(time+1);
	}
}
