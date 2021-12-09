package b14425_문자열집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static public class TrieNode {

		Map<Character, TrieNode> childNodes = new HashMap<>();
		boolean isLastChar;

		Map<Character, TrieNode> getChildNodes() {
			return this.childNodes;
		}

		boolean isLastChar() {
			return this.isLastChar;
		}

		void setIsLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}
	}

	static public class Trie {
		TrieNode rootNode;

		Trie() {
			rootNode = new TrieNode();
		}

		void insert(String word) {
			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}
			thisNode.setIsLastChar(true);
		}

		boolean contains(String word) {
			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);

				if (node == null)
					return false;

				thisNode = node;
			}

			return thisNode.isLastChar();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int cnt=0;
		Trie trie = new Trie();
		for(int i=0;i<N;i++) trie.insert(br.readLine());
		
		for(int i=0;i<M;i++) {
			if(trie.contains(br.readLine())) cnt++;
		}
		System.out.println(cnt);
	}
}
