package b2559_수열;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
        
    public static void main(String[] args) throws IOException  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] inp= br.readLine().split(" ");
    	
    	int N=Integer.parseInt(inp[0]);
    	int K=Integer.parseInt(inp[1]);
    	int max=-1;
    	
    	inp=br.readLine().split(" ");
    	int sum=0;
    	for(int i=0;i<K;i++)
    		sum+=Integer.parseInt(inp[i]);
    	
    	max=sum;
    	for(int i=0;i<N-K;i++) {
    		sum-=Integer.parseInt(inp[i]);
    		sum+=Integer.parseInt(inp[i+K]);
    		max=sum>max?sum:max;
    	}
    			
    	System.out.println(max);
    			
    }
    
}