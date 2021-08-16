package b1021_회전하는큐;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


class Main {
        
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	LinkedList<Integer> dq = new LinkedList<Integer>();
    	
    	int N=Integer.parseInt(st.nextToken());
    	int M=Integer.parseInt(st.nextToken());
    	int cnt=0;
    	
    	for(int i=1;i<=N;i++) {
    		dq.add(i);
    	}
    	
    	st=new StringTokenizer(br.readLine());
    	
    	while(st.hasMoreTokens()) {
    		int tmp=Integer.parseInt(st.nextToken());
    		
    		if(tmp==dq.peekFirst()) {
    			dq.pollFirst();
    		}else if(dq.indexOf(tmp)<=dq.size()/2) {
    			while(dq.peekFirst()!=tmp) {
    				dq.addLast(dq.pollFirst());
    				cnt++;
    			}
    			dq.pollFirst();
    		}else {
    			while(dq.peekFirst()!=tmp) {
    				dq.addFirst(dq.pollLast());
    				cnt++;
    			}
    			dq.pollFirst();
    		}
    	}
    	System.out.println(cnt);
    }
    
}