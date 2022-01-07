package b10025_게으른백곰;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ice = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			list.add(new int[] { x, ice });
		}

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int pos1 = 0;
		int pos2 = 0;
		long res = 0;
		long sum = 0;
		if (N == 1) {
			System.out.println(list.get(0)[1]);
			return;
		}
		int bearIdx=list.get(pos2)[0]-K;
		
		
		while(pos2<N) {
			sum+=list.get(pos2)[1];
			bearIdx=list.get(pos2++)[0]-K;
			
			while(pos1<N&&Math.abs(list.get(pos1)[0]-bearIdx)>K){
				sum-=list.get(pos1++)[1];
			}
			
			res=Math.max(res, sum);
		}
		
		
		System.out.println(res);
	}
}
