package b2992_크면서작은수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr=br.readLine().toCharArray();
		
		if(nextPermutation(arr)) {
			System.out.println(String.valueOf(arr));
		}else System.out.println("0");
		
	}

	private static boolean nextPermutation(char[] arr) {
		
		int origin = arr.length-2;
		
		while(origin>=0&&arr[origin]>=arr[origin+1]) {
			origin--;
		}
		
		if(origin==-1) return false;
		
		int target=arr.length-1;
		
		while(arr[origin]>=arr[target]) {
			target--;
		}
		
		swap(arr,origin,target);
		
		int x=origin+1;
		int y=arr.length-1;
		
		while(x<y) {
			swap(arr, x++, y--);
		}
		
		
		return true;
	}

	private static void swap(char[] arr, int origin, int target) {
		char tmp=arr[origin];
		arr[origin]=arr[target];
		arr[target]=tmp;
	}

}
