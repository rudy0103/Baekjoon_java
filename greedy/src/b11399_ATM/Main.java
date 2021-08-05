package b11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String [] inp=br.readLine().split(" ");
		int [] arr=new int[n];
		for(int i=0;i<inp.length;i++)
			arr[i]=Integer.parseInt(inp[i]);
		
		Arrays.sort(arr);
		
		int tot=0;
		int tmp=0;
		for(int i=0;i<arr.length;i++) {
			tmp+=arr[i];
			tot+=tmp;
		}
		System.out.println(tot);
	}
}
