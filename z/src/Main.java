import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
	int to;
	int w;
	Edge link;

	public Edge(int to, int w, Edge link) {
		super();
		this.to = to;
		this.w = w;
		this.link = link;
	}
}

public class Main {
	
	public static void dijkstra(int start, Edge[] graph, int [] weight) {
		weight[start] = 0;
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		pq.add(new int[] {start,weight[start]});
		
		while(!pq.isEmpty()) {
			int [] tmp=pq.poll();
			
			for(Edge e=graph[tmp[0]];e!=null;e=e.link) {
				int next=e.to;
				int newWeight=e.w+tmp[1];
				if(weight[next]>newWeight) {
					weight[next]=newWeight;
					pq.add(new int[] {next,newWeight});
				}
			}
		}
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		String[] inp = br.readLine().split(" ");
		int V = Integer.parseInt(inp[0]);
		int E = Integer.parseInt(inp[1]);
		int start = Integer.parseInt(br.readLine());

		int[] weight = new int[V + 1];
		Edge[] graph = new Edge[V + 1];

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[from] = new Edge(to, w, graph[from]);
		}

		Arrays.fill(weight, Integer.MAX_VALUE);
		dijkstra(start,graph, weight);

		for (int i = 1; i <= V; i++) {
			if (weight[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(weight[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}