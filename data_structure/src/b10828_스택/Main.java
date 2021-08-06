package b10828_스택;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Stack{
	int size;
	int [] arr;
	
	public Stack(int n) {
		arr=new int[n];
		size=0;
	}
	
	public void push(int x) {
		arr[size++]=x;
	}
	
	public int pop() {
		if(size<=0) return -1;
		return arr[--size];
	}
	
	public int size() {
		return size;
	}
	
	public int empty() {
		if(size==0) return 1;
		return 0;
	}
	
	public int top() {
		if(size==0) return -1;
		else return arr[size-1];
	}
	
	
}


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N=Integer.parseInt(br.readLine());
		Stack s = new Stack(N);
		
		for(int i=0;i<N;i++) {
			String [] inp=br.readLine().split(" ");
			if(inp[0].equals("push")) {
				s.push(Integer.parseInt(inp[1]));
			}else if(inp[0].equals("pop")) {
				bw.write(s.pop()+"\n");
			}else if(inp[0].equals("empty")) {
				bw.write(s.empty()+"\n");
			}else if(inp[0].equals("size")) {
				bw.write(s.size()+"\n");
			}else if(inp[0].equals("top")) {
				bw.write(s.top()+"\n");
			}
		}
		bw.close();
	}
}
