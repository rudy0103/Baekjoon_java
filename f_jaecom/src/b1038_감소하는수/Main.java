package b1038_감소하는수;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Long> list = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		
		for(int i=1;i<=10;i++) {
			int[] selected=new int[i];
			boolean[] visited=new boolean[10];
			
			dfs(0,selected,visited,i);
		}
		
		Collections.sort(list);

		if(N>=list.size()) {
			System.out.println("-1");

		}
		else System.out.println(list.get(N));
		
	}

	private static void dfs(int d, int[] selected, boolean[] visited, int depth) {
		if(d==depth) {
			
			String tmp="";
			for(int i=0;i<selected.length;i++) tmp+=selected[i];
			list.add(Long.parseLong(tmp));
			
			return;
		}
		
		
		for(int i=0;i<=9;i++) {
			if(visited[i]) continue;
			
			if(isPromising(selected,i,d)) {
				
				visited[i]=true;
				selected[d]=i;
				dfs(d+1, selected, visited, depth);
				visited[i]=false;
				
			}
		}
		
		
	}

	private static boolean isPromising(int[] selected, int now, int d) {
		if(d==0) return true;
		if(now>selected[d-1]) return false;
		return true;
	}



}
