package b1138_한줄로서기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static int N;
	static int[] selected;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		selected = new int[N + 1];
		isSelected = new boolean[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		dfs(1, arr);

	}

	private static void dfs(int d, int[] arr) {
		
		if(d>N) {
			for(int i=1;i<=N;i++) {
				System.out.print(selected[i]+" ");
			}
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(isSelected[i]) continue;
			if(isPromise(arr,d,i)==false) continue;
			isSelected[i]=true;
			selected[d]=i;
			dfs(d+1, arr);
			isSelected[i]=false;
		}
	}

	private static boolean isPromise(int[] arr,int d,int target) {
		
		if(d==1) {
			if(arr[target]==0) return true;
			else return false;
		}
		
		int cnt=0;
		for(int i=1;i<d;i++) {
			if(selected[i]>target) cnt++;
		}
		if(cnt==arr[target]) return true;
		return false;
	}

}
