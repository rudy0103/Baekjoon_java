package b10868_최솟값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static int [] segmentTree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		segmentTree=new int[4*N];
		
		for(int i=0; i<N;i++) arr[i]=Integer.parseInt(br.readLine());
		
		makeSegmentTree(arr,1,0,N-1);
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int left=Integer.parseInt(st.nextToken())-1;
			int right=Integer.parseInt(st.nextToken())-1;
			
			
			int min=getMin(arr,left,right,1,0,N-1);
			
			sb.append(min).append("\n");
		}
		
		
		System.out.println(sb.toString());
	}

	private static int getMin(int[] arr, int left, int right,int node, int nodeLeft, int nodeRight) {
		
		
		if(right<nodeLeft || left>nodeRight) return Integer.MAX_VALUE;
		
		if(left<=nodeLeft&&right>=nodeRight) return segmentTree[node];
		
		int mid=(nodeLeft+nodeRight)/2;
		
		int leftVal=getMin(arr, left, right,node*2, nodeLeft, mid);
		int rightVal=getMin(arr, left, right,node*2+1, mid+1, nodeRight);
		
		
		return Math.min(leftVal, rightVal);
	}

	private static int makeSegmentTree(int[] arr, int node, int left, int right) {
		
		if(left==right)  {
			return segmentTree[node]=arr[left];
		}
		
		
		int mid=(left+right)/2;
		
		int leftVal=makeSegmentTree(arr, node*2, left, mid);
		int rightVal=makeSegmentTree(arr, node*2+1, mid+1, right);
		
		return segmentTree[node]=Math.min(leftVal, rightVal);
		
	}

}
