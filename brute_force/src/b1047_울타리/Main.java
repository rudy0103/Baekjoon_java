package b1047_울타리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Tree {
		int x;
		int y;
		int len;

		public Tree(int x, int y, int len) {
			super();
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}

	static int N;
	static int min;
	static int [] label;
	static Tree[] trees;
	static int [] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		N=Integer.parseInt(br.readLine());
		
		min=N-1;
		
		trees=new Tree[N];
		label=new int[N];
		selected=new int[5];
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			trees[i]=new Tree(Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken()));
		}
		
		int len=Math.min(4, N);
		
		cutTree(len);
		
		System.out.println(min);

	}

	private static void cutTree(int len) {
		if(len==2) return;
		if(N>4) len++;
		for(int pointCnt=2;pointCnt<len;pointCnt++) {
			
			choicePoint(pointCnt);
		}
		
	}

	private static void choicePoint(int pointCnt) {
		
		getMin(0,0,selected,pointCnt);
		
	}

	private static void getMin(int depth, int start, int[] selected,int L) {
		
		if(depth==L) {
			
			Arrays.fill(label, 0);
			
			for(int i=0;i<L;i++) {
				label[selected[i]]=1;
			}
			
			int[] tmp=getTreesOutOfBounds(selected,label,L);
			
			if(tmp[1]>=tmp[2]) {
				min=Math.min(min, tmp[0]);
			}else {
				PriorityQueue<Tree> pq = new PriorityQueue<>(new Comparator<Tree>() {
					public int compare(Tree o1, Tree o2) {
						return o2.len-o1.len;
					}
				});
				
				for(int i=0;i<N;i++) {
					if(label[i]==0) pq.add(trees[i]);
				}
				
				while(!pq.isEmpty()&&tmp[2]>tmp[1]) {
					tmp[1]+=pq.poll().len;
					tmp[0]++;
				}
				if(tmp[1]>=tmp[2])
					min=Math.min(min, tmp[0]);

			}
			return;
		}
		
		for(int i=start;i<N;i++) {
			
			selected[depth]=i;
			getMin(depth+1, i+1, selected, L);
			
		}
		
	}

	private static int[] getTreesOutOfBounds(int[] selected,int[] label,int len) {
		
		int[] tmp= {0,0,0};
		
		int lowX=Integer.MAX_VALUE;
		int lowY=Integer.MAX_VALUE;
		int highX=0;
		int highY=0;
		
		for(int i=0;i<len;i++) {
			int x=trees[selected[i]].x;
			int y=trees[selected[i]].y;
			
			lowX=Math.min(lowX, x);
			highX=Math.max(highX, x);
			lowY=Math.min(lowY, y);
			highY=Math.max(highY, y);
		}
		
		for(int i=0;i<N;i++) {
			if(label[i]==1) continue;
			if(trees[i].x>highX||trees[i].x<lowX||trees[i].y>highY||trees[i].y<lowY) {
				tmp[0]++;
				tmp[1]+=trees[i].len;
				label[i]=-1;
			}
		}
		tmp[2]+=(highX-lowX)*2;
		tmp[2]+=(highY-lowY)*2;
		
		return tmp;
	}
}
