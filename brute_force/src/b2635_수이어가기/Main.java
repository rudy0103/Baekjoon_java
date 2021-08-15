package b2635_수이어가기;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


class Main {
        
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	List<Integer> list = new ArrayList<Integer>();
    	int n = Integer.parseInt(br.readLine());
    	int max=Integer.MIN_VALUE;
    	int second=-1;
    	list.add(n);
    	
    	for(int i=n; i>=1;i--) {
    		list.add(i);
    		
    		while(true) {
    			int tmp=list.get(list.size()-2)-list.get(list.size()-1);
    			if(tmp<0) break;
    			else list.add(tmp);
    		}
    		
    		if(list.size()>max) {
    			max=list.size();
    			second=list.get(1);
    		}
    		
    		list.clear();
    		list.add(n);
    	}
    	
    	list.add(second);
		while(true) {
			int tmp=list.get(list.size()-2)-list.get(list.size()-1);
			if(tmp<0) break;
			else list.add(tmp);
		}
    	
    	bw.write(list.size()+"\n");
    	for(int a:list)
    		bw.write(a+" ");
    	bw.close();
    	
    }
}