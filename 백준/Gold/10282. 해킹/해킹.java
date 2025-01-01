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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int vertexSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            ArrayList<Node>[] graph = new ArrayList[vertexSize + 1];
            int[] best = new int[vertexSize + 1];

            for(int idx=1; idx<=vertexSize; idx++) {
                graph[idx] = new ArrayList<>();
            }
            Arrays.fill(best, Integer.MAX_VALUE);

            while(edgeSize-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[v].add(new Node(u, w));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.add(new Node(start, 0));
            best[start] = 0;

            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(best[now.num] < now.weight) continue;

                for (Node next : graph[now.num]) {
                    if(best[next.num] > next.weight + best[now.num]) {
                        best[next.num] = next.weight + best[now.num];
                        pq.add(new Node(next.num, best[next.num]));
                    }
                }
            }

            int count = 0;
            int maxTime = 0;
            for(int idx=1; idx<=vertexSize; idx++) {
                if(best[idx] != Integer.MAX_VALUE) {
                    count++;
                    maxTime = Math.max(best[idx], maxTime);
                }
            }

            sb.append(count).append(' ').append(maxTime).append('\n');
        }
        System.out.print(sb);
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