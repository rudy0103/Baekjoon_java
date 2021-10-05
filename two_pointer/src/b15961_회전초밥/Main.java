package b15961_회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] list=new int[N];
		int [] arr=new int[d+1];
		
		int max=0;
		int cnt = 1;
		arr[c]=123456789;
		
		for (int i = 0; i < N; i++) {
			list[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<k;i++) {
			if(arr[list[i]]==0) {
				cnt++;
				if(cnt>max) max=cnt;
			}
			arr[list[i]]++;
		}
		
		for(int i=0;i<N;i++) {
			int tmp=list[i];
			int tmp2=list[(i+k)%N];
			arr[tmp]--;
			if(arr[tmp]==0) cnt--;
			if(arr[tmp2]==0) {
				cnt++;
				if(cnt>max) max=cnt;
			}
			arr[tmp2]++;
		}

		System.out.println(max);
	}

}
