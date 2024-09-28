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
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[V+1];
        for(int idx=0; idx<=V; idx++) {
            graph[idx] = new ArrayList<>();
        }

        for(int idx=0; idx<E; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        // 각 노드에서 destination 까지의 최단 경로 저장
        int[] goDist = new int[V+1];

        for(int start=1; start<=V; start++) {
            int[] dist = new int[V + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
            dist[start] = 0;
            pq.add(new Node(start, 0));

            while(!pq.isEmpty()) {
                Node curNode = pq.poll();

                if(curNode.vertex == destination) {
                    goDist[start] = dist[destination];
                    break;
                }

                if(dist[curNode.vertex] < curNode.weight) continue;

                for (Node adjNode : graph[curNode.vertex]) {
                    if(dist[adjNode.vertex] > curNode.weight + adjNode.weight) {
                        dist[adjNode.vertex] = curNode.weight + adjNode.weight;
                        pq.add(new Node(adjNode.vertex, dist[adjNode.vertex]));
                    }
                }
            }
        }

        // destination -> 모든 정점으로 최단 경로 구하기
        int[] comeDist = new int[V+1];
        Arrays.fill(comeDist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(destination, 0));
        comeDist[destination] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if(curNode.weight > comeDist[curNode.vertex]) continue;

            for (Node adjNode : graph[curNode.vertex]) {
                if(comeDist[adjNode.vertex] > curNode.weight + adjNode.weight) {
                    comeDist[adjNode.vertex] = curNode.weight + adjNode.weight;
                    pq.add(new Node(adjNode.vertex, comeDist[adjNode.vertex]));
                }
            }
        }

        int result = goDist[1] + comeDist[1];
        for(int idx=2; idx<=V; idx++) {
            result = Math.max(result, goDist[idx] + comeDist[idx]);
        }

        System.out.print(result);

    }

    static class Node {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}