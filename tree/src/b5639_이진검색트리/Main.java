package b5639_이진검색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static class Node {

		int v;
		Node left;
		Node right;

		public Node(int v, Node left, Node right) {
			super();
			this.v = v;
			this.left = left;
			this.right = right;
		}
		
		void add(int n) {
			if(n<this.v) {	
				if(left==null) {
					this.left=new Node(n,null,null);
				}else {
					left.add(n);
				}
			}else {
				if(right==null) {
					this.right=new Node(n,null,null);
				}else {
					right.add(n);
				}
			}
		}
		
		
		void postOrder() {
			if(left!=null)
				left.postOrder();
			if(right!=null)
				right.postOrder();
			this.print();
		}
		
		void print() {
			sb.append(this.v).append("\n");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inp = "";

		Node root=new Node(0, null, null);

		while ((inp = br.readLine()) != null) {

			int num = Integer.parseInt(inp);
			if(root.v==0) root.v=num;
			else {
				
				root.add(num);
				
				
			}
		}
		root.postOrder();
		System.out.println(sb.toString());
	}
}
