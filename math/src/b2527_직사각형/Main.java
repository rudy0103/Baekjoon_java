package b2527_직사각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 4;

		while (n-- > 0) {
			String [] inp =br.readLine().split(" ");
			int [] xArr=new int[4];
			int [] yArr=new int[4];
			ArrayList<Integer> xList=new ArrayList<>();
			ArrayList<Integer> yList=new ArrayList<>();
			int xp=0,yp=0;
			
			for(int i=0;i<inp.length;i++) {
				if(i%2==0) {
					xArr[xp++]=Integer.parseInt(inp[i]);
					xList.add(xArr[xp-1]);
				}
				else {
					yArr[yp++]=Integer.parseInt(inp[i]);
					yList.add(yArr[yp-1]);
				}
			}
			Collections.sort(xList);
			Collections.sort(yList);
			
			int width=xList.get(3)-xList.get(0);
			int height=yList.get(3)-yList.get(0);
			
			int rect1_width=xArr[1]-xArr[0];
			int rect2_width=xArr[3]-xArr[2];
			
			int rect1_height=yArr[1]-yArr[0];
			int rect2_height=yArr[3]-yArr[2];
			
			if(rect1_width+rect2_width<width||rect1_height+rect2_height<height) { //안만남
				System.out.println("d");
				continue;
			}
			else if(rect1_width+rect2_width==width&&rect1_height+rect2_height==height) { //점
				System.out.println("c");
				continue;
			}
			else if(rect1_width+rect2_width==width||rect1_height+rect2_height==height) { //선분
				System.out.println("b");
				continue;
			}else {
				System.out.println("a");
				continue;
			}
		}
	}
}