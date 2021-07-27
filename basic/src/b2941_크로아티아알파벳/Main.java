package b2941_크로아티아알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] list = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String word = br.readLine();
		
		for(int i=0; i<list.length;i++) {
			word=word.replace(list[i], "0");
		}
		System.out.println(word.length());
			
	}

}
