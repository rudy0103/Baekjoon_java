package b1092_배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MainB {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;


		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] crains = new int[N];

		for (int i = 0; i < N; i++)
			crains[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(crains);

		int M = Integer.parseInt(br.readLine());

		int [] freight=new int[M];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			freight[i]= Integer.parseInt(st.nextToken());

		}
		
		Arrays.sort(freight);
		
		if(freight[M-1]>crains[N-1]) {
			System.out.println(-1);
		}else {
			
			int [] index=new int[M];
		
			
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(crains[j]>=freight[i]) {
						index[i]=j;
						break;
					}
				}
			}
			int [] cnt=new int[N];
			
			PriorityQueue<Integer> pq  = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if(cnt[o1]!=cnt[o2])
						return cnt[o1]-cnt[o2];
					else return o2-o1;
				}
			});
			
			boolean[] visited=new boolean[N];
			
			int j=M-1;
			
			while(j>=0) {
				int idx=index[j];
				for(int i=idx;i<N;i++) {
					if(!visited[i]) {
						visited[i]=true;
						pq.add(i);
					}
				}
				
				int putIdx=pq.poll();
				cnt[putIdx]++;
				pq.add(putIdx);
				j--;
				
			}
			
			int timer=0;
			for(int i=0;i<N;i++) {
				timer=Math.max(timer,cnt[i]);
			}
			System.out.println(timer);
			
		}
		
	}
}
