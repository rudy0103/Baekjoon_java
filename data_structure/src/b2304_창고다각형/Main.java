package b2304_창고다각형;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


class Main {
	
	static int getArea(Deque<int[]> q) {
		Stack<int[]> st = new Stack<>();
		int area=0;
		while(!q.isEmpty()) {
			if(st.isEmpty()) st.add(q.poll());
			else {
				if(st.peek()[1]<=q.peek()[1]) {
					area+=st.peek()[1]*(int)Math.abs(q.peek()[0]-st.peek()[0]);
					st.add(q.poll());
				}else {
					q.poll();
				}
			}
		}
		return area;
	}
        
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	ArrayList<int[]> list = new ArrayList<>();
    	Stack<int[]> st=new Stack<>();
    	Deque<int[]> left =new LinkedList<int[]>();
    	Deque<int[]> right =new LinkedList<int[]>();
    	int n=Integer.parseInt(br.readLine());
    	int maxH=-1;
    	int index=-1;
    	
    	for(int i=0;i<n;i++) {
    		String []inp =br.readLine().split(" ");
    		int L=Integer.parseInt(inp[0]);
    		int H=Integer.parseInt(inp[1]);
    		if(H>maxH) {
    			index=L;
    			maxH=H;
    		}
    		list.add(new int[] {L,H});
    	}
    	
    	list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
    	
  
    	
    	for(int i=0;i<list.size();i++) {
    		int[] tmp=list.get(i);
    		if(tmp[0]<index) left.add(tmp);
    		else if(tmp[0]>index) right.addFirst(tmp);
    		else {
    			left.add(tmp);
    			right.addFirst(tmp);
    		}
    	}
    	int area=getArea(left)+getArea(right)+maxH;
    	System.out.println(area);
    }
}