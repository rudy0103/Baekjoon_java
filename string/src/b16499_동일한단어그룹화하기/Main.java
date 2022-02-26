package b16499_동일한단어그룹화하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		HashSet<String> hSet=new HashSet<>();
		
		for(int i=0;i<N;i++) {
			char [] tmp=br.readLine().toCharArray();
			Arrays.sort(tmp);
			hSet.add(String.valueOf(tmp));
		}
		
		System.out.println(hSet.size());
		
		
	}

}
