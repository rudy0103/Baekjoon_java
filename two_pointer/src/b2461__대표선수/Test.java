package b2461__대표선수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test {

	static int N,M;
	static int count[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//학급
		M = Integer.parseInt(st.nextToken());//학급별 학생 수
		count = new int[N];
		
		List<int[]> student = new ArrayList<>();  
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				student.add(new int[] {i,Integer.parseInt(st.nextToken())}); //학급,능력치
			}
		}

		student.sort((a,b)-> a[1]-b[1]); // 능력치 순서로 정렬
		
		int lp = 0;
		int rp = 0;

		int diff= Integer.MAX_VALUE;
		
		while (lp < N*M-1 && rp < N*M-1) {

			//모든 학급이 포함되도록 rp값 이동
			while (rp < N*M-1) {
				
				count[student.get(rp++)[0]]++;
				
				if(haveAllClass()) break;
			}
			
			//모든 학급이 포함되도록 lp값 이동
			while (count[student.get(lp)[0]]>1) {
				count[student.get(lp++)[0]]--;
			}

			//모든 학급 포함시 값 갱신
			if(haveAllClass()) {
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;
				
				for (int i = lp; i < rp; i++) {
					min = Math.min(min, student.get(i)[1]);
					max = Math.max(max, student.get(i)[1]);
				}
				diff = Math.min(diff, max-min);
			}
			
			count[student.get(lp++)[0]]--;
			
		}
		System.out.println(diff);
		
	}

	private static boolean haveAllClass() { //모든 학급이 포함되었는지 확인하는 함수
		for (int cnt : count) {
			if(cnt == 0) return false;
		}
		
		return true;
	}
}
