package b19598_최소회의실개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n =Integer.parseInt(br.readLine());
		int [][] meeting =new int[n][2];
		String [] inp;
		PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				else return o1[0]-o2[0];
			}
		});
		int [] meetingrooms=new int[100001];
		for(int i=0;i<meetingrooms.length;i++) meetingrooms[i]=-1;
		for(int i=0;i<n;i++) {
			inp=br.readLine().split(" ");
			meeting[i][0]=Integer.parseInt(inp[0]);
			meeting[i][1]=Integer.parseInt(inp[1]);
			q.add(meeting[i]);
		}
		
		while(!q.isEmpty()) {
			int [] meet=q.poll();
			for(int i=0;i<meetingrooms.length;i++) {
				if(meetingrooms[i]<=meet[0]) {
					meetingrooms[i]=meet[1];
					break;
				}
			}
		}
		int cnt=0;
		for(int i=0;i<meetingrooms.length;i++) {
			if(meetingrooms[i]==-1) break;
			cnt++;
		}
		System.out.println(cnt);
	}
}
