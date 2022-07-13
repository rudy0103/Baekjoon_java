package b10775_공항;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());

		boolean[] arr = new boolean[G + 1];
		int[] index = new int[G + 1];

		for (int i = 1; i <= G; i++) {
			arr[i] = true;
			index[i]=i;
		}

		int cnt = 0;

		for (int i = 0; i < P; i++) {
			int gi = Integer.parseInt(br.readLine());
			
			int idx=index[gi];
			while(idx>0&&arr[idx]==false) {
				index[idx]=index[idx-1];
				idx=index[idx-1];
			}
			if(idx==0) break;
			index[gi]=idx;
			arr[idx]=false;
			index[idx]=index[idx-1];
			cnt++;
		}

		System.out.println(cnt);

	}

}
