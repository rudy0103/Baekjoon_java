package b11652_카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class Main {

	static class Num{
		Long k;
		Integer v;
		public Num(Long k, Integer v) {
			super();
			this.k = k;
			this.v = v;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		HashMap<Long, Integer> hmap=new HashMap<>();
		
		for(int i=0;i<N;i++) {
			Long a = Long.parseLong(br.readLine());
			if(hmap.containsKey(a)) {
				int tmp=hmap.get(a);
				hmap.put(a,++tmp);
			}else hmap.put(a,1);
		}
		
		long res=Long.MAX_VALUE;
		int max=0;
		
		for(java.util.Map.Entry<Long, Integer> e : hmap.entrySet()) {
			if(e.getValue()>max) {
				max=e.getValue();
				res=e.getKey();
			}else if(e.getValue()==max) {
				res=Math.min(res,e.getKey());
			}
		}
		System.out.println(res);
		
	
		
	}
	

}
