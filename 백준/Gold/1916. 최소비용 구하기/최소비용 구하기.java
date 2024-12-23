import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int vertexSize = Integer.parseInt(br.readLine());
        int edgeSize = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[vertexSize + 1];
        for(int idx=1; idx<=vertexSize; idx++) {
            graph[idx] = new ArrayList<>();
        }

        while(edgeSize-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        int[] best = new int[vertexSize + 1];
        Arrays.fill(best, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        best[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.weight > best[cur.end]) continue;

            for (Node node : graph[cur.end]) {
                if(best[node.end] > cur.weight + node.weight) {
                    best[node.end] = cur.weight + node.weight;
                    pq.add(new Node(node.end, best[node.end]));
                }
            }
        }

        System.out.println(best[end]);
    }
}