package b2357_최솟값과최댓값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int[][] tree=new int[4*N][2];
		
		buildRec(tree,arr,1,0,N-1);
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int left=Integer.parseInt(st.nextToken())-1;
			int right=Integer.parseInt(st.nextToken())-1;
			
			int[] res=query(tree,left,right,1,0,N-1);
			sb.append(res[1]).append(" ").append(res[0]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int[] query(int[][] tree, int left, int right, int node, int nodeLeft, int nodeRight) {
		
		if(right<nodeLeft|| left>nodeRight)
			return new int[] {Integer.MIN_VALUE,Integer.MAX_VALUE};
		
		if(left<=nodeLeft&&nodeRight<=right)
			return new int[] {tree[node][0],tree[node][1]};
		
		int mid =nodeLeft + (nodeRight-nodeLeft)/2;
		
		int[] leftVal=query(tree, left, right, node*2, nodeLeft, mid);
		int[] rigtVal=query(tree, left, right, node*2+1, mid+1, nodeRight);
		
		int[] res=new int[2];
		res[0]=Math.max(leftVal[0], rigtVal[0]);
		res[1]=Math.min(leftVal[1], rigtVal[1]);
		
		return res;
		
	}

	private static int[] buildRec(int[][]tree,int[] arr, int node, int nodeLeft, int nodeRight) {
		if(nodeLeft==nodeRight) {
			tree[node][0]=arr[nodeLeft];
			tree[node][1]=arr[nodeLeft];
			return tree[node];
		}
		
		int mid=nodeLeft+(nodeRight-nodeLeft)/2;
		int[] leftVal=buildRec(tree, arr, node*2, nodeLeft, mid);
		int[] rightVal=buildRec(tree, arr, node*2+1, mid+1, nodeRight);
		

		
		tree[node][0]=Math.max(leftVal[0], rightVal[0]);
		tree[node][1]=Math.min(leftVal[1], rightVal[1]);
		
		return tree[node];
	}

}
