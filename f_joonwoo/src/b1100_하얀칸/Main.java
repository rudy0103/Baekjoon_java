package b1100_하얀칸;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		for(int i=0;i<8;i++) {
			char[] chars=br.readLine().toCharArray();
			
			for(int j=0;j<8;j++) {
				if(chars[j]=='F') {
					if(i%2==0&&j%2==0) cnt++;
					else if(i%2==1&&j%2==1) cnt++;
				}
			}
			
		}
		
		System.out.println(cnt);
	}

}
