package b16562_친구비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static void make(int[] friends) {
		for(int i=1;i<friends.length;i++) friends[i]=i;
	}
	
	public static int find(int x, int [] friends) {
		if(x==friends[x]) return x;
		return friends[x]=find(friends[x], friends);
	}
	
	public static void union(int a,int b,int [] friends, int[] cost) {
		int A=find(a, friends);
		int B=find(b, friends);
		if(A==B) return;
		if(cost[A]<cost[B]) {
			friends[B]=A;
		}else {
			friends[A]=B;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String [] inp=br.readLine().split(" ");
		int N=Integer.parseInt(inp[0]);
		int M=Integer.parseInt(inp[1]);
		int K=Integer.parseInt(inp[2]);
		
		int [] friends=new int[N+1];
		int [] cost=new int[N+1];
		
		st=new StringTokenizer(br.readLine()," ");
		
		for(int i=1;i<=N;i++) cost[i]=Integer.parseInt(st.nextToken());
		
		make(friends);
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), friends, cost);
		}
		
		int [] numOfFriends=new int[N+1];
		for(int i=1;i<=N;i++) numOfFriends[find(i, friends)]++;
		
		
		int totalCost=0;
		for(int i=1;i<=N;i++) {
			if(numOfFriends[i]!=0) {
				totalCost+=cost[i];
			}
		}
		
		if(totalCost<=K) System.out.println(totalCost);
		else System.out.println("Oh no");
	}

}
