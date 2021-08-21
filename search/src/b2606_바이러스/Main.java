package b2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int V=Integer.parseInt(br.readLine());
		boolean[] visited=new boolean[N+1];
		int cnt=0;
		ArrayList<LinkedList<Integer>> list = new ArrayList<>();
		for(int i=0;i<=N;i++) list.add(new LinkedList<Integer>());
		
		for(int i=0;i<V;i++) {
			String [] inp=br.readLine().split(" ");
			list.get(Integer.parseInt(inp[0])).add(Integer.parseInt(inp[1]));
			list.get(Integer.parseInt(inp[1])).add(Integer.parseInt(inp[0]));
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1]=true;
		while(!q.isEmpty()) {
			int e=q.poll();
			cnt++;
			
			for(int n:list.get(e)) {
				if(!visited[n]) {
					visited[n]=true;
					q.add(n);
				}
			}
		}
		System.out.println(cnt-1);
	}
}
