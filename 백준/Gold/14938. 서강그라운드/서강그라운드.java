import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int vertexSize, range, edgeSize;
    static int[] item;
    static ArrayList<Node>[] graph;

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexSize = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        edgeSize = Integer.parseInt(st.nextToken());

        item = new int[vertexSize + 1];
        st = new StringTokenizer(br.readLine());
        for(int idx=1; idx<=vertexSize; idx++) {
            item[idx] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[vertexSize + 1];
        for(int idx=1; idx<=vertexSize; idx++) {
            graph[idx] = new ArrayList<>();
        }

        while(edgeSize-- > 0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
            graph[end].add(new Node(start, weight));
        }

        int ans = 0;
        for(int start=1; start<=vertexSize; start++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] best = new int[vertexSize + 1];
            Arrays.fill(best, Integer.MAX_VALUE);

            pq.add(new Node(start, 0));
            best[start] = 0;

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

            int itemSum = 0;
            for(int idx=1; idx<=vertexSize; idx++) {
                if(best[idx] <= range) itemSum += item[idx];
            }
            ans = Math.max(itemSum, ans);
        }
        System.out.print(ans);
    }
}