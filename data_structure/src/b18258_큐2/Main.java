package b18258_큐2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> dq = new LinkedList<>();
		int n=Integer.parseInt(br.readLine());
		
		while(n-->0) {
			String [] inp=br.readLine().split(" ");
			if(inp[0].equals("push")) {
				dq.add(Integer.parseInt(inp[1]));
			}else if(inp[0].equals("front")) {
				if(dq.isEmpty()) bw.write("-1\n");
				else bw.write(dq.peekFirst().toString()+"\n");
			}else if(inp[0].equals("back")) {
				if(dq.isEmpty()) bw.write("-1\n");
				else bw.write(dq.peekLast().toString()+"\n");
			}else if(inp[0].equals("empty")) {
				if(dq.isEmpty()) bw.write("1\n");
				else bw.write("0\n");
			}else if(inp[0].equals("pop")) {
				if(dq.isEmpty()) bw.write("-1\n");
				else bw.write(dq.pollFirst().toString()+"\n");
			}else {
				bw.write(dq.size()+"\n");
			}
			
		}
		bw.close();
	}
	
}
