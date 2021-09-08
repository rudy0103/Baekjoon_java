package b11403_경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayDeque<Integer> q= new ArrayDeque<>();
	static int[][] res;
	static void searchPath(int start, int[][] adj,boolean []visited) {
		
		Arrays.fill(visited, false);
		
		for(int i=0;i<adj.length;i++) {
			if(adj[start][i]==1) q.add(i);
		}
		
		while (!q.isEmpty()) {
			int next=q.poll();
			visited[next]=true;
			res[start][next]=1;
			for(int i=0;i<adj.length;i++) {
				if (visited[i]) continue;
				if(adj[next][i]==1) q.add(i);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N=Integer.parseInt(br.readLine());
		int [][] adj=new int[N][N];
		res=new int[N][N];
		boolean [] visited=new boolean[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adj[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			searchPath(i,adj,visited);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				sb.append(res[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
