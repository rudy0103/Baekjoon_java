package b14002_가장긴증가하는부분수열4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		
		PriorityQueue<int []> q=new PriorityQueue<>(new Comparator<int []>() {
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1]==o2[1]) return Integer.compare(o2[0], o1[0]);
				return Integer.compare(o2[1], o1[1]);
			}
		});
		
		int size=0;
		for (int i = 0; i < n; i++) {
			int idx=Arrays.binarySearch(dp, 0,size,arr[i]);
			
			if(idx>=0) {
				q.add(new int[] {arr[i],idx});
				continue;
			}
			
			idx=Math.abs(idx)-1;
			dp[idx]=arr[i];
			q.add(new int[] {arr[i],idx});
			
			if(idx==size)
				size++;
		}
		
		int num=dp[size-1];
		
		while (!q.isEmpty()) {
			int tmp[]=q.poll();
			if(tmp[0]>=num) continue;
			dp[tmp[1]]=Math.max(dp[tmp[1]], tmp[0]);
			num=dp[tmp[1]];
		}
		
		sb.append(size+"\n");
		for(int i=0;i<size;i++) sb.append(dp[i]).append(" ");
		
		System.out.println(sb.toString());
	}
}
