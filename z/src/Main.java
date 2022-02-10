import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[]=new int[N];
	
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		int sum=Integer.parseInt(br.readLine());
		
		getPair(arr,N,sum);
		
		System.out.println(cnt);
				
	}

	private static void getPair(int[] arr, int size, int sum) {
		
		Arrays.sort(arr);
		for(int pos=0;pos<size-1;pos++) {
			
			func(pos,size-1,sum,arr);
		}
	
	}

	private static void func(int pos, int r, int sum,int[] arr) {
		
		
		int left=pos+1;
		int right=r;
		
		int mid=(left+right)/2;
		
		while(left<=right) {
			
			int e=arr[mid];
			
			if(e+arr[pos]==sum) {
				
				cnt++;
				break;
				
			}else if(e+arr[pos]<sum) {
				
				left=mid+1;
				mid=(left+right)/2;
				
			}else {
				
				right=mid-1;
				mid=(left+right)/2;
				
			}
			
		}
		
		
		
	}
	
	



}