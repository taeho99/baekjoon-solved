import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Node head = new Node('A');
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			char[] s = br.readLine().toCharArray();
			insertNode(head, s[0], s[2], s[4]);
		}
		preOrder(head);
		sb.append('\n');
		inOrder(head);
		sb.append('\n');
		postOrder(head);
		System.out.print(sb);
	}

	private static void preOrder(Node head) {
		if(head == null) return;
		sb.append(head.value);
		if(head.left != null) preOrder(head.left);
		if(head.right != null) preOrder(head.right);
	}

	private static void inOrder(Node head) {
		if(head == null) return;
		if(head.left != null) inOrder(head.left);
		sb.append(head.value);
		if(head.right != null) inOrder(head.right);
	}

	private static void postOrder(Node head) {
		if(head == null) return;
		if(head.left != null) postOrder(head.left);
		if(head.right != null) postOrder(head.right);
		sb.append(head.value);
	}

	private static void insertNode(Node node, char me, char left, char right) {
		if(node.value == me) {
			if(left != '.')
				node.left = new Node(left);
			if(right != '.')
				node.right = new Node(right);
		} else {
			if(node.left != null)
				insertNode(node.left, me, left, right);
			if(node.right != null)
				insertNode(node.right, me, left, right);
		}
	}

	static class Node {
		char value;
		Node left;
		Node right;

		public Node(char value) {
			this.value = value;
		}
	}
}
