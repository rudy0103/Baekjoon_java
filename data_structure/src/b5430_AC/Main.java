package b5430_AC;
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
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int T=Integer.parseInt(br.readLine());
    	Deque<Integer> dq=new LinkedList<Integer>();
    	while(T-->0) {
    		dq.clear();
    		boolean reversed=false;
    		boolean error=false;
    		String command=br.readLine();
    		int n=Integer.parseInt(br.readLine());
    		StringBuilder sb = new StringBuilder(br.readLine());
    		String inp=sb.substring(1,sb.length()-1);
    		StringTokenizer st = new StringTokenizer(inp,",");
    		while(st.hasMoreTokens()) dq.add(Integer.parseInt(st.nextToken()));
    		
    		sb= new StringBuilder();

    		for(int i=0;i<command.length();i++) {
    			if(command.charAt(i)=='R') {
    				if(reversed) reversed=false;
    				else reversed=true;
    			}else {
    				if(dq.isEmpty()) {
    					error=true;
    					break;
    				}
    				if(!reversed) dq.pollFirst();
    				else dq.pollLast();
    			}
    		}
    		
    		if(error) sb.append("error\n");
    		else {
    			sb.append("[");
    			while (dq.size()>1) {
					if(reversed) sb.append(dq.pollLast()).append(",");
					else sb.append(dq.pollFirst()).append(",");
				}
    			if(dq.size()==0) sb.append("]\n");
    			else sb.append(dq.poll()).append("]\n");
    		}
    		bw.write(sb.toString());
    	}
    	bw.close();
    }
}