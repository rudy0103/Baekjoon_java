package b9663_N_Queen;

import java.util.Scanner;

public class Main {
	static int N, res;
	static int[] queens;
	
	static public boolean isPossible(int col){
		
		for(int i=0;i<col;i++) {
			if(queens[col]==queens[i]) return false;
		}
		
		for(int i=0;i<col;i++) {
			if(Math.abs(col-i)==Math.abs(queens[col]-queens[i])) return false;
		}
		
		return true;
	}

	public static void backtracking(int cnt) {

		if (cnt == N) {
			res++;
			return;
		}

		for (int i = 0; i < N ; i++) {
			queens[cnt]=i;
			if (isPossible(cnt)) {
				backtracking(cnt + 1);
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queens = new int[N];
		backtracking(0);
		System.out.println(res);
	}
}