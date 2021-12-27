package b5052_전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());


		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String [] phone_book=new String[N];
			
			boolean answer = true;
			HashSet<String> hSet = new HashSet<>();
			for(int i=0;i<N;i++) {
				phone_book[i]=br.readLine();
			}
			
			for(int i=0;i<phone_book.length;i++){
	            for(int j=0;j<phone_book[i].length()-1;j++){
	                hSet.add(phone_book[i].substring(0,j+1));
	            }
	        }
	        
	        for(int i=0;i<phone_book.length;i++){
	            if(hSet.contains(phone_book[i])){
	            	answer=false;
	                break;
	            }
	        }


			if (answer)
				sb.append("YES\n");
			else
				sb.append("NO\n");
			
		}
		System.out.println(sb.toString());
	}
}
