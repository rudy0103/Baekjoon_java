package b14696_딱지놀이;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {
        
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int n=Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	StringBuilder sb =new StringBuilder();
    	for(int i=0;i<n;i++) {
    		PriorityQueue<Integer> A=new PriorityQueue<>(Collections.reverseOrder());
    		PriorityQueue<Integer> B=new PriorityQueue<>(Collections.reverseOrder());
    		st=new StringTokenizer(br.readLine());
    		st.nextToken();
    		
    		while(st.hasMoreTokens()) {
    			A.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		st=new StringTokenizer(br.readLine());
    		st.nextToken();
    		
    		while(st.hasMoreTokens()) {
    			B.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		while(!A.isEmpty()&&!B.isEmpty()) {
    			if(A.peek()==B.peek()) {
    				A.poll();B.poll();
    			}else if(A.peek()>B.peek())
    				B.poll();
    			else
    				A.poll();
    		}
    		
    		if(A.isEmpty()&&B.isEmpty()) sb.append("D\n");
    		else if(A.isEmpty()) sb.append("B\n");
    		else sb.append("A\n");
    	}
    	bw.write(sb.toString());
    	bw.close();
    }
    
}