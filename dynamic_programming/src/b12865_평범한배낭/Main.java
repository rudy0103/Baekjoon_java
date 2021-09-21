package b12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String [] inp = br.readLine().split(" ");
		
		int N=Integer.parseInt(inp[0]);
		int K=Integer.parseInt(inp[1]);
		
		ArrayList<int []> list = new ArrayList<>();
		int [] values=new int[K+1];
		
		for(int i=1;i<=K;i++) values[i]=-1;
		
		list.add(new int[] {0,0});
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			int W=Integer.parseInt(st.nextToken());
			int V=Integer.parseInt(st.nextToken());
			list.add(new int[] {W,V}); //배낭에  들어가는 item list
		}
		
		for(int i=1;i<=N;i++) { //각 아이템 별로
			for(int j=K;j>=0;j--) { //테이블의 뒤에서 부터 적용
				if(j-list.get(i)[0]>=0&&values[j-list.get(i)[0]]!=-1) {
					values[j]=Math.max(values[j], values[j-list.get(i)[0]]+list.get(i)[1]);
				}
			}
		}
		
		int max=0;
		for(int i=1;i<=K;i++)// 가장 큰 만족도를 찾기
			if(values[i]>max) max=values[i];
		System.out.println(max);
	}
}
