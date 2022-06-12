package b1339_단어수학;

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
		
		String [] words=new String[N];
		for(int i=0;i<N;i++) words[i]=br.readLine();
		
		HashMap<Character,Integer> hmap=new HashMap();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<words[i].length();j++) {
				if(hmap.containsKey(words[i].charAt(j))) {
					int v=hmap.get(words[i].charAt(j));
					v+=(int)Math.pow(10, words[i].length()-j-1);
					hmap.put(words[i].charAt(j), v);
				}else {
					hmap.put(words[i].charAt(j), (int) Math.pow(10, words[i].length()-j-1));
				}
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
		});
		
		for(Entry<Character, Integer> entry:hmap.entrySet()) {
			pq.add(new int[] {entry.getKey(),entry.getValue()});
		}

		int weight=9;
		int sum=0;
		while(!pq.isEmpty()) {
			int[] tmp=pq.poll();
			sum+=tmp[1]*weight;
			weight--;
		}


		System.out.println(sum);
		
	}

}