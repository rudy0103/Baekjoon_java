import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int arr[]=new int[N+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		
		ArrayDeque<int[]> q= new ArrayDeque<>();

		arr[1]=0;
		q.add(new int[] {1,0});
		
		while(!q.isEmpty()) {
			
			int []now=q.poll();
			
			
			if(now[0]>N) continue;
			
			int next=now[0]*2;
			
			if(next<=N&&arr[next]==Integer.MAX_VALUE) {
				arr[next]=now[1]+1;
				q.add(new int[] {next,now[1]+1});
			}
			
			next=now[0]*3;
			if(next<=N&&arr[next]==Integer.MAX_VALUE) {
				arr[next]=now[1]+1;
				q.add(new int[] {next,now[1]+1});
			}
			
			next=now[0]+1;
			if(next<=N&&arr[next]==Integer.MAX_VALUE) {
				arr[next]=now[1]+1;
				q.add(new int[] {next,now[1]+1});
			}
			
			
		}
		System.out.println(arr[N]);
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(N);
		while(!dq.isEmpty()) {
			int a=dq.poll();
			sb.append(a+" ");
			
			
			if(arr[a-1]==arr[a]-1) {
				dq.add(a-1);
				continue;
			}
			
			if(a%2==0&&arr[a/2]==arr[a]-1) {
				dq.add(a/2);
				continue;
			}
			
			if(a%3==0&&arr[a/3]==arr[a]-1) {
				dq.add(a/3);
				continue;
			}
			
		}
		System.out.println(sb);
		
	}
}
