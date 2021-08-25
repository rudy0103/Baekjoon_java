import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static double maxV=Double.MIN_VALUE;
	
	public static void getVolume(double X,double Y) {
		
		double small=X>Y?Y:X;
		
		for(double h=0.0001;h<small/2;h+=0.0001) {
			double V=(X*Y-2*h*X-2*h*Y+4*h*h)*h;
			if(V>maxV) maxV=V;
			else break;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st =null;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			double X=Double.parseDouble(st.nextToken());
			double Y=Double.parseDouble(st.nextToken());
			maxV=Double.MIN_VALUE;
			getVolume(X, Y);
			maxV=(Math.round(maxV*1000000))/1000000.0;
			sb.append("#").append(tc).append(" ").append(String.format("%.6f", maxV)).append("\n");
		}
		System.out.println(sb.toString());
	}
}