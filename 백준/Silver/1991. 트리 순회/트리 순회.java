import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Node head = new Node('A');
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            char me = s.charAt(0);
            char left = s.charAt(2);
            char right = s.charAt(4);
            insertNode(head, me, left, right);
        }
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }

    private static void preOrder(Node head) {
        if(head == null) return;
        System.out.print(head.value);
        preOrder(head.left);
        preOrder(head.right);
    }

    private static void inOrder(Node head) {
        if(head == null) return;
        inOrder(head.left);
        System.out.print(head.value);
        inOrder(head.right);
    }

    private static void postOrder(Node head) {
        if(head == null) return;
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.value);
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
