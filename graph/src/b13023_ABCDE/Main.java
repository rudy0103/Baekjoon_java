package b13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Node{
	int v;
	Node link;
	public Node(int v, Node link) {
		super();
		this.v = v;
		this.link = link;
	}
	
}

public class Main {
	
	static boolean flag;
	
	public static void dfs(int v,int depth,Node[] graph,boolean[] visited) {
		if(depth==4) {
			flag=true;
			return;
		}
		
		for(Node curr=graph[v];curr!=null;curr=curr.link) {
			if(visited[curr.v]==false) {
				visited[curr.v]=true;
				dfs(curr.v, depth+1, graph, visited);
				visited[curr.v]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		StringTokenizer st = null;
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		Node[] graph=new Node[N];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			graph[from]=new Node(to,graph[from]);
			graph[to]=new Node(from,graph[to]);
		}
		boolean [] visited=new boolean[N];
		for(int i=0;i<N;i++) {
			visited[i]=true;
			dfs(i,0,graph,visited);
			visited[i]=false;
			if(flag) break;
		}
		if(flag) System.out.println(1);
		else System.out.println(0);
		
	}
}
