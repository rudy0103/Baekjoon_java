package b1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void make(int[] rep) {
		for (int i = 0; i < rep.length; i++)
			rep[i] = i;
	}

	public static int find(int x, int[] rep) {
		if (x == rep[x])
			return x;
		return rep[x] = find(rep[x], rep);
	}

	static public boolean union(int a, int b, int[] rep) {
		int A = find(a, rep);
		int B = find(b, rep);

		if (A == B)
			return false;
		rep[A] = B;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] adj = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++)
				adj[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int [] rep=new int[N];
		make(rep);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(adj[i][j]==1) union(i, j, rep);
			}
		}
		
		boolean flag=true;
		st=new StringTokenizer(br.readLine()," ");
		int tmp=find(Integer.parseInt(st.nextToken())-1, rep);
		while (st.hasMoreElements()) {
			
			if(tmp!=find(Integer.parseInt(st.nextToken())-1, rep)) {
				flag=false;
				break;
			};
			
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
}
