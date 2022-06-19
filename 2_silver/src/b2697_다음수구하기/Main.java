package b2697_다음수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			
			String num=br.readLine();
			
			char[] arr = new char[num.length()];
			
			for(int i=0;i<arr.length;i++) arr[i]=num.charAt(i);
			
			if(nextPermutation(arr)) {
				sb.append(String.valueOf(arr)+"\n");
			}else sb.append("BIGGEST\n");
			
			
		}
		
		System.out.println(sb.toString());
		
	}

	private static boolean nextPermutation(char[] arr) {
		
		int origin = arr.length-2;
		
		while(origin>=0&&arr[origin]>=arr[origin+1] ) {
			origin--;
		}
		
		if(origin==-1) return false;
		
		
		int target=arr.length-1;
		
		while(arr[origin]>=arr[target]) {
			target--;
		}
		
	
		swap(arr, origin, target);
		
		int x=origin+1;
		int y=arr.length-1;
		while(y>x) {
			swap(arr, x++, y--);
		}
		return true;
		
	}
	
	private static void swap(char[] arr, int x, int y) {
		char tmp=arr[x];
		arr[x]=arr[y];
		arr[y]=tmp;
	}

}
