package b15662_톱니바퀴2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Gear{
		int n;
		boolean[] arr;
		int dir;
		public Gear(int n, boolean[] arr) {
			super();
			this.n = n;
			this.arr = arr;
		}
		
		public void turn() {
			if(dir==1) {//시계
				boolean tmp=this.arr[7];
				for(int i=7;i>0;i--) arr[i]=arr[i-1];
				arr[0]=tmp;
			}else {
				boolean tmp=this.arr[0];
				for(int i=0;i<7;i++) arr[i]=arr[i+1];
				arr[7]=tmp;
			}
		}
	}

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		Gear[] gears=new Gear[T];
		
		for(int t=0;t<T;t++) {
			String inp=br.readLine();
			boolean[] arr=new boolean[8];
			for(int i=0;i<8;i++) if(inp.charAt(i)=='1') arr[i]=true;
			
			gears[t]=new Gear(t,arr);
		}
		
		int K=Integer.parseInt(br.readLine());
		
		boolean [] turned=new boolean[T];
		ArrayDeque<Gear> dq=new ArrayDeque<>();
		for(int i=0;i<K;i++) {
			Arrays.fill(turned, false);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx=Integer.parseInt(st.nextToken())-1;
			int dir=Integer.parseInt(st.nextToken());
			gears[idx].dir=dir;
			dq.add(gears[idx]);
			
			while(!dq.isEmpty()) {
				Gear g = dq.poll();
				turned[g.n]=true;
				
				if(g.n-1>=0&&!turned[g.n-1]&&g.arr[6]!=gears[g.n-1].arr[2]) {
					turned[g.n-1]=true;
					gears[g.n-1].dir=g.dir*-1;
					dq.add(gears[g.n-1]);
				}
				
				if(g.n+1<T&&!turned[g.n+1]&&g.arr[2]!=gears[g.n+1].arr[6]) {
					turned[g.n+1]=true;
					gears[g.n+1].dir=g.dir*-1;
					dq.add(gears[g.n+1]);
				}
				g.turn();
			}
		}
		
		int cnt=0;
		for(int i=0;i<T;i++) {
			if(gears[i].arr[0]) cnt++;
		}
		System.out.println(cnt++);
		
	}

}
