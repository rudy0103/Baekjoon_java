package b2493_탑;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		int [] arr=new int[n+1];
		int [] res=new int[n+1];
		Stack<int []> S = new Stack<>();
		Deque<int []> Q = new LinkedList<>();
		arr[0]=0;
		
		String [] inp =br.readLine().split(" ");
		
		for(int i=1;i<=inp.length;i++) {
			arr[i]=Integer.parseInt(inp[i-1]);
			Q.add(new int[] {i,arr[i]});
		}
		
		while(!Q.isEmpty()) {
			int[] tmp=Q.poll();
			
			if(S.isEmpty()) {
				S.add(tmp);
				res[tmp[0]]=0;
			}else {
				
				while(!S.isEmpty()&&S.peek()[1]<tmp[1]) {
					S.pop();
				}
				if(S.isEmpty())
					S.add(tmp);
				else {
					res[tmp[0]]=S.peek()[0];
					S.add(tmp);
				}
			}
		}
		for(int i=1;i<res.length;i++) {
			bw.write(res[i]+" ");
		}
		bw.write("\n");
		bw.close();
	}
}
