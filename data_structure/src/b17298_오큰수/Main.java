package b17298_오큰수;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<int[]> s = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int [] res =new int[n];
		String [] inp=br.readLine().split(" ");
		for(int i =0;i<inp.length;i++) {
			int tmp=Integer.parseInt(inp[i]);
			if(s.isEmpty()) {
				s.push(new int[] {i,tmp});
			}else if(s.peek()[1]>tmp) {
				s.push(new int[] {i,tmp});
			}else {
				while(!s.isEmpty()&&tmp>s.peek()[1]) {
					res[s.pop()[0]]=tmp;
				}
				s.push(new int[] {i,tmp});
			}
		}
		while (!s.isEmpty()) {
			res[s.pop()[0]]=-1;
		}
		for(int a:res) {
			bw.write(a+" ");
		}
		bw.close();
	}
}
