package b11650_좌표정렬하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Point{
	int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String [] s=br.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			list.add(new Point(x,y));
		}
		list.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x!=o2.x) return o1.x-o2.x;
				else return o1.y-o2.y;
			}
		});
		for(Point p:list) {
			bw.write(p.x+" "+p.y+"\n");
		}
		bw.flush();
		bw.close();

	}

}
