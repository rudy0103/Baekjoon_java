package b1181_단어정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		List<String> list = new ArrayList<>(set);
		
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				if(o1.length()!=o2.length()) return o1.length()-o2.length();
				else return o1.compareTo(o2);
			}
		});
		for(String s:list) {
			bw.write(s+"\n");
		}
		bw.flush();
		bw.close();
	}
}