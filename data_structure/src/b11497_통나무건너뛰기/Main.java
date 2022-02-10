package b11497_통나무건너뛰기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int[] newArr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(arr);
			
			newArr[0] = arr[0];

			Stack<Integer> rightStack = new Stack<>();
			
			int pos=1;
			
			for (int i = 1; i < N; i++) {
				if(i%2==1) {
					newArr[pos++]=arr[i];
				}else rightStack.add(arr[i]);
			}
			
			while(pos<N) {
				newArr[pos++]=rightStack.pop();
			}
			
			int L=0;
			
			for(int i=1;i<N;i++) {
				L=Math.max(L,Math.abs(newArr[i]-newArr[i-1]));
			}
			L=Math.max(L,Math.abs(newArr[0]-newArr[N-1]));
			sb.append(L).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
