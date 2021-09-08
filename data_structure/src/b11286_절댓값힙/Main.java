package b11286_절댓값힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> heap=new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return Integer.compare(o1[0], o2[0]);
				else return Integer.compare(o1[1], o2[1]);
			}
		});
		
		
		for(int i=0;i<N;i++) {
			int tmp=Integer.parseInt(br.readLine());
			if(tmp==0) {
				if(heap.isEmpty()) sb.append("0\n");
				else sb.append(heap.poll()[0]).append("\n");
			}else {
				if (tmp<0) heap.add(new int[] {tmp,-tmp});
				else heap.add(new int[] {tmp,tmp});
			}
		}
		System.out.println(sb.toString());
	}

}
