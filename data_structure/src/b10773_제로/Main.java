package b10773_제로;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			int tmp=Integer.parseInt(br.readLine());
			if(tmp==0) s.pop();
			else s.push(tmp);
		}
		int sum=0;
		while(!s.isEmpty()) sum+=s.pop();
		System.out.println(sum);
		
	}
}
