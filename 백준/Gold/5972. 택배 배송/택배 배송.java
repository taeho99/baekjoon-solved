import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[vertexSize + 1];
        int[] best = new int[vertexSize + 1];
        Arrays.fill(best, Integer.MAX_VALUE);

        for(int idx=1; idx<=vertexSize; idx++) {
            graph[idx] = new ArrayList<>();
        }

        while(edgeSize-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        best[1] = 0;
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(best[now.num] < now.weight) continue;

            for (Node next : graph[now.num]) {
                if(best[next.num] > best[now.num] + next.weight) {
                    best[next.num] = best[now.num] + next.weight;
                    pq.add(new Node(next.num, best[next.num]));
                }
            }
        }

        System.out.println(best[vertexSize]);
    }

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
}