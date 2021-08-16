package b11866_요세푸스문제0;

import java.util.LinkedList;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		
		sb.append("<");
		int idx=0;
		while(list.size()>1) {
			
			idx=(idx+(k-1))%list.size();
			sb.append(list.get(idx)+", ");
			list.remove(idx);
		}
		sb.append(list.get(0)+">");
		System.out.println(sb);
	}
}