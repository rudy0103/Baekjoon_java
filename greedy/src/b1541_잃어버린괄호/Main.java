package b1541_잃어버린괄호;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String inp=br.readLine();
		StringTokenizer st;
		int min=0;
		if(inp.indexOf('-')==-1) {
			st=new StringTokenizer(inp,"+",false);
			while(st.hasMoreTokens()) {
				min+=Integer.parseInt(st.nextToken().toString());
			}
		}else {
			String tmp1=inp.substring(0,inp.indexOf('-'));
			st=new StringTokenizer(tmp1,"+",false);
			while(st.hasMoreTokens()) {
				min+=Integer.parseInt(st.nextToken());
			}
			String tmp2=inp.substring(inp.indexOf('-')+1);
			st=new StringTokenizer(tmp2,"+-",false);
			while(st.hasMoreTokens()) {
				min-=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(min);
	}
}
