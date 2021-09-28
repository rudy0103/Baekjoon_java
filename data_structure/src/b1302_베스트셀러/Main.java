package b1302_베스트셀러;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> hMap=new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String tmp=br.readLine();
			if(hMap.containsKey(tmp)) {
				int val=hMap.get(tmp);
				hMap.replace(tmp, val+1);
			}else {
				hMap.put(tmp,1);
			}
		}
		
		PriorityQueue<Entry<String, Integer>> pq=new PriorityQueue<>(new Comparator<Entry<String,Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue()==o2.getValue()) return o1.getKey().compareTo(o2.getKey());
				else return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		//kim:123, park:3456 
		for(Entry<String, Integer> e:hMap.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
		
		System.out.println(pq.peek().getKey());
	}
}
