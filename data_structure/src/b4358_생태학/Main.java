package b4358_생태학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Main {

	static class Tree {
		String name;
		double r;

		public Tree(String name, double r) {
			super();
			this.name = name;
			this.r = r;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String tree = null;

		HashMap<String, Integer> map = new HashMap<>();
		int totalCnt = 0;
		while ((tree = br.readLine()) != null) {
			totalCnt++;
			if (map.containsKey(tree)) {
				int tmpKey = map.get(tree);
				map.put(tree, ++tmpKey);
			} else {
				map.put(tree, 1);
			}
		}
		PriorityQueue<Tree> list = new PriorityQueue<>(new Comparator<Tree>() {
			@Override
			public int compare(Tree o1, Tree o2) {
				return o1.name.compareTo(o2.name);
			}
		});

		for (Entry<String, Integer> e : map.entrySet()) {
			double rate=(double)e.getValue()/totalCnt;
			rate*=1000000;
			rate=Math.round(rate);
			rate/=10000;
			list.add(new Tree(e.getKey(),rate));
		}
		while (!list.isEmpty()) {
			Tree t= list.poll();
			sb.append(t.name).append(" ").append(String.format("%.4f", t.r)).append("\n");
		}
		System.out.println(sb.toString());

	}

}
