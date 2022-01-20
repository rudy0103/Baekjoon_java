import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  

    public static void main(String[] args) throws IOException{
     
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String N=br.readLine();
    	
    	while(!N.equals("0")) {
    		int len=0;
    		
    		len+=N.length()+1;
    		
    		for(int i=0;i<N.length();i++) {
    			
    			if(N.charAt(i)=='0') {
    				len+=4;
    			}else if(N.charAt(i)=='1') {
    				len+=2;
    			}else len+=3;
    		}
    		
    		System.out.println(len);
    		N=br.readLine();
    	}
        
    }

}