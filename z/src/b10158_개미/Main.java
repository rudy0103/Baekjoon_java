package b10158_개미;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int originT = sc.nextInt();

		int dx = 1;
		int dy = 1;
		int tmp = -1;
		boolean flag=true;
		int tmpX=-1;
		int tmpY=-1;
		int tmpDx=1;
		int tmpDy=1;
		int a = Math.abs(w - x) < Math.abs(h - y) ? Math.abs(w - x) : Math.abs(h - y);
		
		if(Math.abs(w - x) < Math.abs(h - y)) {
			tmpX=w;
			tmpY=y+a;
			tmpDx=-1;
		}else {
			tmpX=x+a;
			tmpY=h;
			tmpDy=-1;
		}
		
		int t= originT;
		while (t > 0) {
			if (dx == 1 && dy == 1)
				tmp = Math.abs(w - x) < Math.abs(h - y) ? Math.abs(w - x) : Math.abs(h - y);
			else if (dx == -1 && dy == 1) {
				tmp = Math.abs(0 - x) < Math.abs(h - y) ? Math.abs(0 - x) : Math.abs(h - y);
			}else if(dx==1 &&dy==-1) {
				tmp = Math.abs(w - x) < Math.abs(0 - y) ? Math.abs(w - x) : Math.abs(0 - y);
			}else {
				tmp = Math.abs(0 - x) < Math.abs(0 - y) ? Math.abs(0 - x) : Math.abs(0 - y);
			}
			if (t - tmp >= 0) {
				t -= tmp;
				if (x + tmp * dx == w) {
					x = w;
					dx *= -1;
					
				} else if (x + tmp * dx == 0) {
					x = 0;
					dx *= -1;
				} else {
					x += tmp * dx;
				}

				if (y + tmp * dy == h) {
					y = h;
					dy *= -1;
				} else if (y + tmp * dy == 0) {
					y = 0;
					dy *= -1;
				} else {
					y += tmp * dy;
				}
				
				if(flag&&x==tmpX&&y==tmpY&&dx==tmpDx&&dy==tmpDy&&originT-t!=a) {
					t=t%(originT-t-a);
					flag=false;
				}
			} else {
				x += dx;
				y += dy;
				t--;
			}
		}
		System.out.println(x + " " + y);
	}
}