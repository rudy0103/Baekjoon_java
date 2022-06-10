package b1526_가장큰금민수;

import java.util.Scanner;

public class Main {
	
	
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		
		dfs(N,0,0);
		
		System.out.println(res);
	}

	private static void dfs(int N, int now, int depth) {
		if(N<now) return;
		res=Math.max(res, now);
		
		dfs(N, now+4*(int)Math.pow(10, depth), depth+1);
		dfs(N, now+7*(int)Math.pow(10, depth), depth+1);
		
	}

}
