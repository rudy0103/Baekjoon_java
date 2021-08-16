package b2164_카드2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
        
    public static void main(String[] args) throws Exception{
    	Scanner sc = new Scanner(System.in);
    	int n=sc.nextInt();
    	Deque<Integer> dq=new LinkedList<Integer>();
    	for(int i=1;i<=n;i++) {
    		dq.add(i);
    	}
    	
    	while(dq.size()>1) {
    		dq.pollFirst();
    		dq.add(dq.pollFirst());
    	}
    	System.out.println(dq.poll());
    }
}