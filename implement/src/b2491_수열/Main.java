package b2491_수열;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n= Integer.parseInt(br.readLine());
		String [] inp=br.readLine().split(" ");
		
		int cnt=1;
		int max=1;
		
		for(int i=1;i<inp.length;i++) {
			if(Integer.parseInt(inp[i])>=Integer.parseInt(inp[i-1])) {
				cnt++;
				if(cnt>max) max=cnt;
			}else {
				cnt=1;
			}
		}
		cnt=1;
		for(int i=1;i<inp.length;i++) {
			if(Integer.parseInt(inp[i])<=Integer.parseInt(inp[i-1])) {
				cnt++;
				if(cnt>max) max=cnt;
			}else {
				cnt=1;
			}
		}
		bw.write(max + "");
		bw.close();
	}
}
