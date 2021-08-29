package b4153_직각삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int [] arr=new int[3];
		do {
			st= new StringTokenizer(br.readLine());
			arr[0]=Integer.parseInt(st.nextToken());
			arr[1]=Integer.parseInt(st.nextToken());
			arr[2]=Integer.parseInt(st.nextToken());
			
			if(arr[0]+arr[1]+arr[2]==0) break;

			Arrays.sort(arr);
			if(arr[2]*arr[2]==arr[0]*arr[0]+arr[1]*arr[1]) {
				sb.append("right\n");
			}else sb.append("wrong\n");
		}while(true);
		
		System.out.println(sb.toString());
	}
}
