package b1094_막대기;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X=sc.nextInt();
		
		int sum=64;
		
		PriorityQueue<Integer> remains=new PriorityQueue<>();
		
		remains.add(64);
		int res=-1;
		while(true) {
			if(X==sum) {
				res=remains.size();
				break;
			}else if(sum>X) {
				int tmp=remains.poll();
				if(sum-tmp/2>=X) {
					remains.add(tmp/2);
					sum-=tmp/2;
				}
				else {
					remains.add(tmp/2);
					remains.add(tmp/2);
				}
			}else {
				int tmp=remains.poll();
				remains.add(tmp/2);
				remains.add(tmp/2);
			}
		}
		System.out.println(res);
	}
}
