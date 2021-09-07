package b1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<ArrayList<Integer>> tree=new ArrayList<>();
	
	public static void preorder(int n) {
		if (n == -1)
			return;

		sb.append((char)(n+'A'));
		preorder(tree.get(n).get(0));
		preorder(tree.get(n).get(1));

	}

	public static void inorder(int n) {
		if (n == -1)
			return;

		inorder(tree.get(n).get(0));
		sb.append((char)(n+'A'));
		inorder(tree.get(n).get(1));

	}

	public static void postorder(int n) {
		if (n == -1)
			return;

		postorder(tree.get(n).get(0));
		postorder(tree.get(n).get(1));
		sb.append((char)(n+'A'));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) tree.add(new ArrayList<>()); //리스트를 생성해서 넣어주어야함
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int val=st.nextToken().charAt(0)-'A';
			int left=st.nextToken().charAt(0)-'A';
			int right=st.nextToken().charAt(0)-'A';
			
			if(left!='.'-'A')
				tree.get(val).add(left);
			else tree.get(val).add(-1);
			
			if(right!='.'-'A')
				tree.get(val).add(right);
			else tree.get(val).add(-1);
		}
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		sb.append("\n");
		System.out.println(sb.toString());
	}
}
