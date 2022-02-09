import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


	
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		int N=10;
		int [] arr = new int[N];
		
		for(int i=0;i<N;i++) arr[i]=i;
		
		
		ArrayList<int[]> list = getPair(arr,10,10);
		
		System.out.println(list.size());
		
		for(int[] e:list) {
			System.out.println(e[0]+" "+e[1]);
		}
		
		
	}

	private static ArrayList<int[]> getPair(int[] arr, int size, int sum) {
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		ArrayList<int[]> list =new ArrayList<>();
		
		for(int pos=0;pos<size-1;pos++) {
			
			func(pos,size-1,sum,arr,list);
			
		}
		
		return list;
	}

	private static void func(int pos, int r, int sum,int[] arr,ArrayList<int[]> list) {
		
		
		int left=pos+1;
		int right=r;
		
		int mid=(left+right)/2;
		
		while(left<=right) {
			
			int e=arr[mid];
			
			if(e+arr[pos]==sum) {
				
				list.add(new int[] {arr[pos],e});
				
				for(int p=mid-1;p>pos;p--) {
					if(arr[p]!=e) break;
					list.add(new int[] {arr[p],e});
				}
				
				for(int p=mid+1;p<mid;p++) {
					if(arr[p]!=e) break;
					list.add(new int[] {arr[p],e});
				}
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