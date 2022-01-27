package b14725_개미굴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static class Node {
		boolean flag = false;
		String word;
		HashMap<String, Node> map = new HashMap<>();

		public Node addNode(String word) {
			flag = true;
			if (map.containsKey(word))
				return map.get(word);
			map.put(word, new Node(word));
			return map.get(word);
		}

		public Node(String word) {
			this.word = word;
		}

		public void print(int k) {

			for (int i = 0; i < k; i++) {
				sb.append("--");
			}
			sb.append(this.word);
			sb.append("\n");

			if (flag = true) {
				ArrayList<Node> list = new ArrayList<>(this.map.values());
				Collections.sort(list, new Comparator<Node>() {
					@Override
					public int compare(Node o1, Node o2) {
						return o1.word.compareTo(o2.word);
					}
				});
				for (Node n : list) {
					n.print(k + 1);
				}
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		Node root = new Node("root");

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			Node n = root;
			for (int j = 0; j < K; j++) {
				String word = st.nextToken();
				n = n.addNode(word);
			}
		}

		ArrayList<Node> list = new ArrayList<>(root.map.values());
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.word.compareTo(o2.word);
			}
		});

		for (Node n : list) {
			n.print(0);
		}

		System.out.print(sb.toString());
		
	}

}
