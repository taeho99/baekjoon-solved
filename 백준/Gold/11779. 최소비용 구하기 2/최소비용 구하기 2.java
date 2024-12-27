import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int vertexSize, edgeSize, start, end;
    static ArrayList<Node>[] graph;
    static ArrayList<Integer> result;
    static int[] best, path;

    static class Node implements Comparable<Node> {
        int num, weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        vertexSize = Integer.parseInt(br.readLine());
        edgeSize = Integer.parseInt(br.readLine());

        graph = new ArrayList[vertexSize + 1];
        for(int idx=1; idx<=vertexSize; idx++) {
            graph[idx] = new ArrayList<>();
        }

        best = new int[vertexSize + 1];
        for(int idx=1; idx<=vertexSize; idx++) {
            best[idx] = Integer.MAX_VALUE;
        }

        while(edgeSize-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        result = new ArrayList<>();
        path = new int[vertexSize + 1];

        best[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node via = pq.poll();

            if(via.weight > best[via.num]) continue;
            for (Node adj : graph[via.num]) {
                if(best[adj.num] > via.weight + adj.weight) {
                    best[adj.num] = via.weight + adj.weight;
                    pq.add(new Node(adj.num, best[adj.num]));
                    path[adj.num] = via.num;
                }
            }
        }

        int node = end;
        while(node != 0) {
            result.add(node);
            node = path[node];
        }

        sb.append(best[end]).append('\n');
        sb.append(result.size()).append('\n');
        for(int idx=result.size() - 1; idx>=0; idx--) {
            sb.append(result.get(idx)).append(' ');
        }
        System.out.print(sb);
    }
}