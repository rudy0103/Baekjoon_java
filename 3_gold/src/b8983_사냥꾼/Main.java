package b8983_사냥꾼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int M,N,L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt=0;
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		
		int[] lines=new int[M];
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) lines[i]=Integer.parseInt(st.nextToken());
		
		int[][] animals=new int[N][2];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			animals[i][0]=Integer.parseInt(st.nextToken());
			animals[i][1]=Integer.parseInt(st.nextToken());
		}
		
		//사대 정렬
		
		Arrays.sort(lines);
		
		//동물 정렬
		Arrays.sort(animals,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				else return o1[0]-o2[0];
			}
		});
		
	
		for(int i=0;i<N;i++) {
			int idx=Arrays.binarySearch(lines, animals[i][0]);
			
			if(idx>=0) {
				if(animals[i][1]<=L) {
					cnt++;
				}
			}
			else {
				int tmp=-idx-1;
				if(getDistance(tmp, lines,animals[i])) {
						cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

	private static boolean getDistance(int tmp, int[] lines, int[] animal) {
		
		if(tmp<M) {
			if(Math.abs(lines[tmp]-animal[0])+animal[1]<=L) return true;
		}
		
		if(tmp-1>=0) {
			if(Math.abs(lines[tmp-1]-animal[0])+animal[1]<=L) return true;
		}
		
		return false;
	}

}
