package b1835_카드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=N;i>=1;i--) {
			list.addFirst(i);
			for(int j=1;j<=i;j++) {
				list.addFirst(list.pollLast());
			}
		}
		
		for(int i=0;i<N;i++) sb.append(list.get(i)+" ");
		
		System.out.println(sb.toString());
	}

}
