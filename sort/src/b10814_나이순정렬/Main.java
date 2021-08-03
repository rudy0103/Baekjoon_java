package b10814_나이순정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Member{
	int idx,age;
	String name;
	
	public Member(int idx, int age, String name) {
		super();
		this.idx = idx;
		this.age = age;
		this.name = name;
	}
	
	
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		List<Member> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String [] s=br.readLine().split(" ");
			int age=Integer.parseInt(s[0]);
			String name=s[1];
			list.add(new Member(i,age,name));
		}
		list.sort(new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				if(o1.age!=o2.age) return o1.age-o2.age;
				else return o1.idx-o2.idx;
			}
		});
		for(Member p:list) {
			bw.write(p.age+" "+p.name+"\n");
		}
		bw.flush();
		bw.close();
	}
}