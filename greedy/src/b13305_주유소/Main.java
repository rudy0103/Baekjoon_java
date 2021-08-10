package b13305_주유소;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		long [] distance=new long[n-1];
		long [] cost=new long[n];
		
		String [] inp=br.readLine().split(" ");
		for(int i=0;i<inp.length;i++) distance[i]=Long.parseLong(inp[i]);
		
		inp=br.readLine().split(" ");
		for(int i=0;i<inp.length;i++) cost[i]=Long.parseLong(inp[i]);
		
		
		long tot=0;
		long low_cost=Long.MAX_VALUE;
		
		for(int i=0;i<n-1;i++) {
			if(cost[i]<low_cost)
				low_cost=cost[i];
			tot+=distance[i]*low_cost;
		}
		bw.write(tot+"");
		bw.close();
	}
}
