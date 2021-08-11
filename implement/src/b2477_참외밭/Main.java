package b2477_참외밭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Integer> list = new LinkedList<>();
		int v=Integer.parseInt(br.readLine());
		int area=0;
		int max=0;
		
		for(int i=0;i<6;i++) {
			String [] inp=br.readLine().split(" ");
			int len=Integer.parseInt(inp[1]);
			list.add(len);
			if(max<len) max=len;
		}
		
		while(!(list.get(0)>list.get(2)&&list.get(1)>list.get(5))) {
			list.add(list.pollFirst());
		}
		area=list.get(0)*list.get(5)+list.get(2)*list.get(3);
		
		
		bw.write(area*v+"\n");
		bw.close();
	}
}