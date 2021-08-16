package b1966_프린터큐;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
        
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc=0;tc<T;tc++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
    		Queue<int[]> queue= new LinkedList<>();
    		int N=Integer.parseInt(st.nextToken());
    		int idx=Integer.parseInt(st.nextToken());
    		st= new StringTokenizer(br.readLine());
    		int i=0;
    		while (st.hasMoreElements()) {
				int tmp=Integer.parseInt(st.nextToken());
				pq.add(tmp);
				queue.add(new int[]{i++,tmp});
				
			}
    		
    		int cnt=0;
    		while(!queue.isEmpty()) {
    			if(queue.peek()[1]==pq.peek()) {
    				pq.poll();
    				cnt++;
    				if(queue.poll()[0]==idx) {
    					System.out.println(cnt);
    					break;   				
    				}
    			}else {
    				queue.add(queue.poll());
    			}
    		}
    		
    	}
    }
}