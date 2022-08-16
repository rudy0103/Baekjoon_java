package b2644_촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	


	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		int m=Integer.parseInt(br.readLine());

		int[] parent=new int[n+1];
		boolean[] check=new boolean[n+1];
		
		for(int i=1;i<=n;i++) parent[i]=i;
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());//pa
			int y=Integer.parseInt(st.nextToken());//ch
			parent[y]=x;
		}
		int root=getCommonRoot(parent, a, b);
		if(root!=0) {
			int chonA=getChon(parent,a,root,0);
			int chonB=getChon(parent,b,root,0);
			System.out.println(chonA+chonB);
		}else System.out.println("-1");
		
	
		
		
	}

	private static int getCommonRoot(int[] parent, int a, int b) {
		
		boolean[] check=new boolean[parent.length];
		
		checkRoot(check,parent,a);
	
		int root=b;
		
		while(check[root]==false) {
			root=parent[root];
			if(root==parent[root]) break;
		}
		
		if(check[root]) return root;
		return 0;

	}


	private static void checkRoot(boolean[] check, int[] parent, int a) {
		check[a]=true;
		if(parent[a]==a) return;
		else checkRoot(check, parent, parent[a]);
	}

	private static int getChon(int[] parent, int a,int root, int chon) {
		
		if(a==root) return chon;
		return getChon(parent, parent[a],root, chon+1);
	}

}
