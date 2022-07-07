package b2002_추월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		HashMap<String,Integer> hmap=new HashMap<>();
		
		for(int i=0;i<N;i++) {
			hmap.put(br.readLine(), i);
		}
		
		boolean[] passed=new boolean[N];
		
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			String car=br.readLine();
			if(isTrue(hmap, car,passed)==false) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}

	private static boolean isTrue(HashMap<String, Integer> hmap, String car, boolean[] passed) {
		
		int idx=hmap.get(car);
		passed[idx--]=true;
		
		
		while(idx>=0) {
			if(passed[idx--]==false) return false;
		}
		
		
		
		return true;
	}


}
