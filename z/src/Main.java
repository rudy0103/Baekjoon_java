import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
//		int N=sc.nextInt();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10000000;i++) {
//			list.add(Integer.toString(i));
			list.add(i+"");
		}
		long start = System.currentTimeMillis();
		sb.append(String.join(" ",list));
//		for(String s:list) {
//			sb.append(s).append(" ");
//		}
//		System.out.println(sb.toString());
		long end = System.currentTimeMillis();
		System.out.println("수행시간: " + (end - start) + " ms");
	}
}