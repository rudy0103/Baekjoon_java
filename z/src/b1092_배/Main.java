package b1092_배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

import sun.security.krb5.internal.Ticket;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> crains = new ArrayList<>();

		for (int i = 0; i < N; i++)
			crains.add(Integer.parseInt(st.nextToken()));

		int M = Integer.parseInt(br.readLine());

		LinkedList<Integer> arr = new LinkedList();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++)
			arr.add(Integer.parseInt(st.nextToken()));

		Collections.sort(crains);
		Collections.sort(arr);

		if (arr.get(M - 1) > crains.get(N - 1)) {
			System.out.println(-1);
		} else {

			int[] index = new int[M];

			Arrays.fill(index, -1);
			
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(crains.get(j)>=arr.get(i)) {
						index[i]=j;
						break;
					}
				}
			}
			
			
			int totalCnt=0;
			int time=0;
			boolean[] visited=new boolean[N];
			
			while(totalCnt<M) {
				Arrays.fill(visited, false);
				int cnt=0;
				
				
				totalCnt+=cnt;
				time++;
			}
			
			System.out.println(time);

	
		}
	}
}
