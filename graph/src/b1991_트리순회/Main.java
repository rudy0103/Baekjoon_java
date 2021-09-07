package b1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	char val;
	Node left;
	Node right;
	public Node(char val, Node left, Node right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}
}


public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void preorder(Node node) {
		if(node==null) return;
		
		sb.append(node.val);
		preorder(node.left);
		preorder(node.right);
		
	}
	public static void inorder(Node node) {
		if(node==null) return;
		
		inorder(node.left);
		sb.append(node.val);
		inorder(node.right);
		
	}
	public static void postorder(Node node) {
		if(node==null) return;
		
		postorder(node.left);
		postorder(node.right);
		sb.append(node.val);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N=Integer.parseInt(br.readLine());
		Node [] tree=new Node[N];
		
		for(int i=0;i<N;i++) tree[i]=new Node((char) ('A'+i),null,null);
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			char val=st.nextToken().charAt(0);
			char left=st.nextToken().charAt(0);
			char right=st.nextToken().charAt(0);
			
			if(left!='.') tree[val-'A'].left=tree[left-'A'];
			if(right!='.') tree[val-'A'].right=tree[right-'A'];
		}
		
		preorder(tree[0]);
		sb.append("\n");
		inorder(tree[0]);
		sb.append("\n");
		postorder(tree[0]);
		sb.append("\n");
		System.out.println(sb.toString());
		
		
	}

}
