package b2258_정육점;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		
		ArrayList<int[]> meat=new ArrayList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int w=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			meat.add(new int[] {w,c});
		}
		
		Collections.sort(meat,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1]!=o2[1])
					return o1[1]-o2[1];
				else return o2[0]-o1[0];
			}
		});
		
		int prices[]=new int[N+1];
		int weight[]=new int[N+1];
		for(int i=0;i<N;i++) {
			if(i==0) {
				weight[i]=meat.get(i)[0];
				prices[i]=meat.get(i)[1];
				continue;
			}
			weight[i]=weight[i-1]+meat.get(i)[0];
			if(meat.get(i)[1]!=meat.get(i-1)[1]) {
				prices[i]=meat.get(i)[1];
			}else {
				prices[i]=prices[i-1]+meat.get(i)[1];
			}
		}
		
		

		long price=Long.MAX_VALUE;	
		for(int i=0;i<N;i++) {
			if(weight[i]>=M) {
				price=Math.min(price, prices[i]);
			}
		}
	

		if(price==Long.MAX_VALUE)
			System.out.println("-1");
		else System.out.println(price);
	}
}
