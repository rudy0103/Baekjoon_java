package b8989_시계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class Time{
		String h;
		String m;
		int sum;
		double angle;
		
		public Time(String h, String m, double angle){
			this.h=h;
			this.m=m;
			this.sum=Integer.parseInt(h)*60+Integer.parseInt(m);
			this.angle=angle;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		while(T-->0) {
			ArrayList<Time> times=new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<5;i++) {
				StringTokenizer st2=new StringTokenizer(st.nextToken(),":");
				String h=st2.nextToken();
				String m=st2.nextToken();
				times.add(new Time(h,m,getAngle(h,m)));
			}
			
			Collections.sort(times,new Comparator<Time>() {

				@Override
				public int compare(Time o1, Time o2) {
					if(o1.angle==o2.angle) {
						return o1.sum-o2.sum;
					}
					return Double.compare(o1.angle, o2.angle);
				}
			});

			sb.append(times.get(2).h+":"+times.get(2).m+"\n");
		}
		System.out.println(sb.toString());
	}

	private static double getAngle(String hour, String minute) {
		int h=Integer.parseInt(hour);
		int m=Integer.parseInt(minute);
		h%=12;
		double a1=30.0*h+m/2.0;
		double a2=6.0*m;

		return Math.min(Math.abs(a1-a2), 360.0-Math.abs(a1-a2));
	}

}
