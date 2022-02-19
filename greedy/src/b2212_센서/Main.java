package b2212_센서;

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
		int N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		
		
		
		int [] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		
		for(int i=0;i<N-1;i++) {
			pq.add(arr[i+1]-arr[i]);
		}
		
		for(int i=0;i<K-1;i++) {
			pq.poll();
		}
		
		int res=0;
		while(!pq.isEmpty()) {
			res+=pq.poll();
		}
		System.out.println(res);
		
		
		
		
	}

}
