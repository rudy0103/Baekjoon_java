package b2108_통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		int N=Integer.parseInt(br.readLine());
		int [] arr=new int[N];
		int [] count=new int[8001];
		int sum=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
			count[arr[i]+4000]++;
		}
		Arrays.sort(arr);
		long avg=Math.round((double)sum/N);
		avg=Math.round(avg);
		int median = arr[N/2];
		int mode=0;
		for(int i=0;i<count.length;i++) {
			if(count[i]>mode) {
				mode=count[i];
			}
		}
		for(int i=0;i<count.length;i++) {
			if(count[i]==mode) {
				list.add(i-4000);
			}
		}
		
		if(list.size()==1) {
			mode=list.get(0);
		}
		else mode=list.get(1);
		
		int range=arr[arr.length-1]-arr[0];
		
		//==============================출력======================
		System.out.println(avg);
		System.out.println(median);
		System.out.println(mode);
		System.out.println(range);
	}
}
