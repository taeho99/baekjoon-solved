import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int vertexCnt, edgeCnt;
    static int[] parents;
    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        vertexCnt = Integer.parseInt(br.readLine());
        edgeCnt = Integer.parseInt(br.readLine());

        parents = new int[vertexCnt + 1];
        edges = new Edge[edgeCnt];
        while(edgeCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[edgeCnt] = new Edge(from, to, cost);
        }

        Arrays.sort(edges);

        makeSet();
        int minimumCost = 0, selectEdgeCnt = 0;
        for (Edge edge : edges) {
            if(union(edge.from, edge.to)) {
                minimumCost += edge.cost;
                if(++selectEdgeCnt == vertexCnt-1) break;
            }
        }
        System.out.println(minimumCost);
    }

    static void makeSet() {
        for(int idx = 1; idx<= vertexCnt; idx++) {
            parents[idx] = idx;
        }
    }

    static int findSet(int a) {
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.cost, e.cost);
        }
    }
}