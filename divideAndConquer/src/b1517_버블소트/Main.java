package b1517_버블소트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static long cnt=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int []arr=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		mergeSort(arr,0,N-1);
		
		System.out.println(cnt);
	}

	private static void mergeSort(int[] arr, int left, int right) {
		
		if(left==right) return ;
		
		
		int mid=(left+right)/2;
		
		
		mergeSort(arr, left, mid);
		mergeSort(arr, mid+1, right);
		
		if(arr[mid]<=arr[mid+1]) return;
		
		int leftLen= mid-left+1;
		int rightLen=right-mid;
		
		int leftIdx=left;
		int rightIdx=mid+1;
		
		int []newArr=new int[leftLen+rightLen];
		int idx=0;
		
		while(idx<newArr.length&&leftIdx<=mid&&rightIdx<=right) {
			
			if(arr[leftIdx]<=arr[rightIdx]) {
				newArr[idx++]=arr[leftIdx++];
				leftLen--;
			}else {
				newArr[idx++]=arr[rightIdx++];
				cnt+=leftLen;
			}
		}
		
		if(leftIdx>mid) {
			while(rightIdx<=right) {
				newArr[idx++]=arr[rightIdx++];
			}
		}else {
			while(leftIdx<=mid) {
				newArr[idx++]=arr[leftIdx++];
			}
		}
		
		
		idx=0;
		for(int i=left;i<=right;i++) {
			arr[i]=newArr[idx++];
		}
	}
}
