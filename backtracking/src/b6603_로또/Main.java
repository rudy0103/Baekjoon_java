package b6603_로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void lotto(int depth,int[] arr,int[] selected,int start) {
		if(depth==6) {
			for(int n:selected)
				sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		
		
		for(int i=start;i<arr.length;i++) {
			selected[depth]=arr[i];
			lotto(depth+1, arr, selected, i+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		do{st=new StringTokenizer(br.readLine());
		int k=Integer.parseInt(st.nextToken());
		if(k==0) break;
		int [] arr = new int [k];
		int [] selected=new int[6];
		for(int i=0;i<k;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		lotto(0,arr,selected, 0);
		sb.append("\n");
		}while(true);
		System.out.println(sb.toString());
	}
}
