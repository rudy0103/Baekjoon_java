package b17140_이차원배열과연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;
import java.util.StringTokenizer;



public class Main {
	
	static class Number{
		int cnt;
		int num;
		public Number(int cnt, int num) {
			this.cnt = cnt;
			this.num = num;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r=Integer.parseInt(st.nextToken())-1;
		int c=Integer.parseInt(st.nextToken())-1;
		int k=Integer.parseInt(st.nextToken());
		
		int rSize=3;
		int cSize=3;
		
		
		int[][] arr=new int[3][3];
		
		for(int i=0;i<3;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		int time=0;
		while(time<=100) {
			if(rSize>r&&cSize>c&&arr[r][c]==k) {
				break;
			}else {
				time++;
				arr=getArr(arr);
				rSize=arr.length;
				cSize=arr[0].length;
			}
		}
		if(time>100) System.out.println(-1);
		else System.out.println(time);
		
		
		
	}


	private static int[][] getArr(int[][] arr) {
		
		
		int rSize=arr.length;
		int cSize=arr[0].length;
		
		HashMap<Integer,Integer> map=new HashMap<>();

		if(rSize>=cSize) {
			ArrayList<Number> []list = new ArrayList[rSize];
			int max=cSize;
			for(int r=0;r<rSize;r++) {
				map.clear();
				list[r]=new ArrayList<>();
				for(int c=0;c<cSize;c++) {
					int num=arr[r][c];
					if(num==0) continue;
					if(map.containsKey(num)) {
						int v=map.get(num)+1;
						map.put(num,v);
					}else {
						map.put(num,1);
					}
				}
				
				for(Entry<Integer, Integer> e: map.entrySet()) {
					list[r].add(new Number(e.getValue(),e.getKey()));
				}
				
				Collections.sort(list[r],new Comparator<Number>() {

					@Override
					public int compare(Number o1, Number o2) {
						if(o1.cnt!=o2.cnt) return o1.cnt-o2.cnt;
						else return o1.num-o2.num;
					}
				});
				max=Math.max(max,list[r].size()*2);

			}
			cSize=max;
			if(cSize>100) cSize=100;
			
			
			int[][] newArr=new int[rSize][cSize];
			for(int i=0;i<rSize;i++) {
				int idx=Math.min(cSize,list[i].size()*2);
				for(int j=0;j<idx;j+=2) {
					newArr[i][j]=list[i].get(j/2).num;
					newArr[i][j+1]=list[i].get(j/2).cnt;
				}
			}
			
			return newArr;
			
			
		}else {
			
			ArrayList<Number> []list = new ArrayList[cSize];
			int max=rSize;
			for(int c=0;c<cSize;c++) {
				map.clear();
				list[c]=new ArrayList<>();
				for(int r=0;r<rSize;r++) {
					int num=arr[r][c];
					if(num==0) continue;
					if(map.containsKey(num)) {
						int v=map.get(num)+1;
						map.put(num,v);
					}else {
						map.put(num,1);
					}
				}
				
				for(Entry<Integer, Integer> e: map.entrySet()) {
					list[c].add(new Number(e.getValue(),e.getKey()));
				}
				
				Collections.sort(list[c],new Comparator<Number>() {

					@Override
					public int compare(Number o1, Number o2) {
						if(o1.cnt!=o2.cnt) return o1.cnt-o2.cnt;
						else return o1.num-o2.num;
					}
				});
				max=Math.max(max,list[c].size()*2);

			}
			rSize=max;
			if(rSize>100) rSize=100;
			int[][] newArr=new int[rSize][cSize];
			for(int i=0;i<cSize;i++) {
				int idx=Math.min(rSize,list[i].size()*2);
				for(int j=0;j<idx;j+=2) {
					newArr[j][i]=list[i].get(j/2).num;
					newArr[j+1][i]=list[i].get(j/2).cnt;
				}
			}
			
			return newArr;
			
		}
		
	}

}
