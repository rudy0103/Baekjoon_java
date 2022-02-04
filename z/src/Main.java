import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	static long cnt=0;
	static int[] newArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inp=br.readLine();
		
		HashSet<Character> set = new HashSet<>();
		set.add('a');
		set.add('i');
		set.add('u');
		set.add('e');
		set.add('o');
		
		set.add('A');
		set.add('I');
		set.add('U');
		set.add('E');
		set.add('O');
		while(!inp.equals("#")) {
			int cnt=0;
			for(int i=0;i<inp.length();i++) {
				if(set.contains(inp.charAt(i))) {
					cnt++;
				}
			}
			System.out.println(cnt);
			inp=br.readLine();
		}
		
		
	}



}