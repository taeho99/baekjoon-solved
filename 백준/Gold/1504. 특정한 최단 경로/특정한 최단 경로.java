import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int n, e;
    static ArrayList<ArrayList<Node>> adj;
    static int[] dist;
    static boolean[] visited;
    static final int INF = (int)2e8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        dist = new int[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj.get(start).add(new Node(end, weight));
            adj.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = 0;
        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, n);

        int ans2 = 0;
        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, n);

        if(ans1 >= INF && ans2 >= INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(ans1, ans2));
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if(!visited[poll.end]) {
                visited[poll.end] = true;
                for (Node node : adj.get(poll.end)) {
                    if(!visited[node.end] && dist[node.end] > dist[poll.end] + node.weight) {
                        dist[node.end] = dist[poll.end] + node.weight;
                        queue.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
