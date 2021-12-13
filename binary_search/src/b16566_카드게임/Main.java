package b16566_카드게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int [] arr= new int[M];
		boolean [] isUsed = new boolean[M];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++) arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<K;i++) {
			int cheolsu=Integer.parseInt(st.nextToken());
			int tmp=Arrays.binarySearch(arr, cheolsu);
			if(tmp>=0) {
				while(isUsed[++tmp]==true);
				sb.append(arr[tmp]).append("\n");
				isUsed[tmp]=true;
			}else {
				tmp=-tmp-1;
				while(isUsed[tmp]==true) {
					tmp++;
				};
				sb.append(arr[tmp]).append("\n");
				isUsed[tmp]=true;
			}
		}
		
		System.out.println(sb.toString());
		
		
	}

}
