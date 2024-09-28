import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // create Edge Array
        Edge[] edges = new Edge[E];
        for(int idx=0; idx<E; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[idx] = new Edge(start, end, weight);
        }

        // makeSet()
        parents = new int[V+1];
        Arrays.fill(parents, -1);

        // 가중치 오름차순으로 정렬
        Arrays.sort(edges);

        int selectEdgeCnt = 0, sumWeight = 0;
        for (Edge edge : edges) {
            if(union(edge.start, edge.end)) {
                sumWeight += edge.weight;
                if(++selectEdgeCnt == V-1) break;
            }
        }
        System.out.println(sumWeight);
    }

    static int findSet(int a) {
        if(parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;

        parents[aRoot] += parents[bRoot];
        parents[bRoot] = aRoot;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }
}