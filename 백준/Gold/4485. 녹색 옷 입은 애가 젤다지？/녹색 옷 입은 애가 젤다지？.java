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

    static ArrayList<ArrayList<Node>> adj;
    static int[] dist;
    static boolean[] visited;
    static final int INF = (int)2e8;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int problem = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n;
        while((n = Integer.parseInt(br.readLine())) != 0) {
            adj = new ArrayList<>();
            dist = new int[n*n];
            visited = new boolean[n*n];
            for(int i=0; i<=n*n; i++) {
                adj.add(new ArrayList<>());
            }

            int[][] map = new int[n][n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(i==n-1 && j==n-1) continue;
                    int start = i*n + j;
                    for(int k=0; k<4; k++) {
                        int endY = i + dy[k];
                        int endX = j + dx[k];
                        if(endY < 0 || endY >= n || endX < 0 || endX >=n) continue;

                        int end = endY*n + endX;
                        adj.get(start).add(new Node(end, map[endY][endX]));
                    }
                }
            }
            sb.append("Problem ").append(problem++).append(": ").append(dijkstra(0, n * n - 1) + map[0][0]).append('\n');
        }
        System.out.print(sb);
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
