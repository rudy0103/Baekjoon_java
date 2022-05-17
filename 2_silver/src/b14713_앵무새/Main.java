package b14713_앵무새;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, int[]> map = new HashMap<>();

		int[] arr = new int[N];
		int totalCnt=0;
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx=0;
			
			while(st.hasMoreTokens()) {
				map.put(st.nextToken(),new int[] {i,idx++});
				totalCnt++;
			}
		}
		boolean flag=true;
		int cnt=0;
		st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			String tmp=st.nextToken();
			
			if(map.containsKey(tmp)==false) {
				flag=false;
				break;
			}else {
				int[] curr=map.get(tmp);
				if(arr[curr[0]]==curr[1]) {
					arr[curr[0]]++;
					cnt++;
				}else {
					flag=false;
					break;
				}
				
			}
		}
		
		if(cnt!=totalCnt) flag=false;
		
		if(flag) System.out.println("Possible");
		else System.out.println("Impossible");

	}

}
