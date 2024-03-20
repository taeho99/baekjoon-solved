import java.util.*;

class Solution {

    class Node {
        int x, y, num;
        Node left, right;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    private Node makeBT(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];

        for(int i=0; i<nodeinfo.length; i++) {
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.y == o2.y)
                return Integer.compare(o1.x, o2.x);
            return Integer.compare(o2.y, o1.y);
        });

        Node root = nodes[0]; //루트노드

        for(int i=1; i<nodes.length; i++) {
            Node parent = root;
            while(true) {
                if (nodes[i].x < parent.x) { //왼쪽으로
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else { //오른쪽으로
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }

        return nodes[0];
    }

    private void preOrder(Node curr, ArrayList<Integer> answer) {
        if(curr == null) return;
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }

    private void postOrder(Node curr, ArrayList<Integer> answer) {
        if(curr == null) return;
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }

    public int[][] solution(int[][] nodeinfo) {
        Node root = makeBT(nodeinfo);
        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList);
        return new int[][] {
                preOrderList.stream().mapToInt(Integer::intValue).toArray(),
                postOrderList.stream().mapToInt(Integer::intValue).toArray()
        };
    }
}