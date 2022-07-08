package b20311_화학실험;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[N+1];
		boolean flag=false;
		
		st=new StringTokenizer(br.readLine());
		
		PriorityQueue<int[]> maxQ = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]!=o2[1]) return o2[1]-o1[1];
				return 0;
			}
		});
		
		int cut=-1;
		if(N%2==1) cut=N/2+1;
		else cut=N/2;
		for(int i=1;i<=K;i++) {
			int cnt=Integer.parseInt(st.nextToken());
			if(cnt>cut) {
				flag=true;
				break;
			}
			maxQ.add(new int[] {i,cnt});
		}
		
		int idx=1;
		
		if(flag) maxQ.clear();
		
		while(!maxQ.isEmpty()) {
			int [] now=maxQ.poll();
			if(now[0]!=arr[idx-1]) {
				arr[idx++]=now[0];
				now[1]--;
				if(now[1]>0) {
					maxQ.add(now);
				}
			}else {
				if(maxQ.isEmpty()) {
					flag=true;
					break;
				}else {
					int[] second=maxQ.poll();
					arr[idx++]=second[0];
					second[1]--;
					if(second[1]>0) maxQ.add(second);
					maxQ.add(now);
				}
			}
		}
		
		
		if(flag==false) {
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<=N;i++) {
				sb.append(arr[i]).append(" ");
			}
			System.out.println(sb.toString());
			
		}else {
			System.out.println("-1");
		}
		
	}

}
