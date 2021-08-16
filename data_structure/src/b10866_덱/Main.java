package b10866_덱;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			String[] inp = br.readLine().split(" ");
			if (inp[0].equals("push_front")) {
				dq.addFirst(Integer.parseInt((inp[1])));
			} else if (inp[0].equals("push_back")) {
				dq.addLast(Integer.parseInt((inp[1])));
			} else if (inp[0].equals("pop_front")) {
				if (dq.isEmpty())
					sb.append("-1\n");
				else
					sb.append(dq.pollFirst() + "\n");
			} else if (inp[0].equals("pop_back")) {
				if (dq.isEmpty())
					sb.append("-1\n");
				else
					sb.append(dq.pollLast() + "\n");
			} else if (inp[0].equals("size")) {
				sb.append(dq.size() + "\n");
			} else if (inp[0].equals("empty")) {
				if(dq.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			}else if(inp[0].equals("front")) {
				if(dq.isEmpty()) sb.append("-1\n");
				else sb.append(dq.peekFirst()+"\n");
			}else if(inp[0].equals("back")) {
				if(dq.isEmpty()) sb.append("-1\n");
				else sb.append(dq.peekLast()+"\n");
			}
		}
		System.out.println(sb.toString());

	}

}