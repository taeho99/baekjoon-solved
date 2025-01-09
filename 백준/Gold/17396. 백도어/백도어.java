import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        boolean[] isVisible = new boolean[vertexSize];
        ArrayList<Node>[] graph = new ArrayList[vertexSize];
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<vertexSize; idx++) {
            isVisible[idx] = Integer.parseInt(st.nextToken()) == 1;
            graph[idx] = new ArrayList<>();
        }

        while(edgeSize-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, t));
            graph[b].add(new Node(a, t));
        }

        long[] best = new long[vertexSize];
        Arrays.fill(best, Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0, 0L));
        best[0] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(best[now.num] < now.weight) continue;

            for (Node next : graph[now.num]) {
                if(next.num != vertexSize-1 && isVisible[next.num]) continue;
                if(best[next.num] > best[now.num] + next.weight) {
                    best[next.num] = best[now.num] + next.weight;
                    pq.add(new Node(next.num, best[next.num]));
                }
            }
        }

        System.out.print(best[vertexSize-1] == Long.MAX_VALUE ? -1 : best[vertexSize-1]);
    }

    static class Node implements Comparable<Node> {
        int num;
        long weight;

        public Node(int num, long weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }
}