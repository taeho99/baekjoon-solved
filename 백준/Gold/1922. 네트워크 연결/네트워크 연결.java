import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  BOJ.1922 네트워크연결
 *
 *  1. 정점의 개수와 간선의 개수를 입력받는다.
 *  2. 간선 리스트를 입력받는다.
 *  3. 간선 리스트를 비용 기준으로 오름차순 정렬한다.
 *  4. 모든 정점을 최소 단위 서로소 집합으로 만든다.
 *  5. 간선의 비용이 적은 순부터 간선 리스트를 탐색한다.
 *      5-1. 간선에 연결된 두 정점이 아직 연결되지 않았으면 연결하고
 *          5-1-1. 최소비용에 추가한다.
 *          5-1-2. 총 연결된 간선의 개수가 vertexCnt-1개면 종료한다.
 *  6. 최소 비용을 출력한다.
 */
public class Main {
    static int vertexCnt, edgeCnt;
    static int[] parents;
    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 정점의 개수와 간선의 개수를 입력받는다.
        vertexCnt = Integer.parseInt(br.readLine());
        edgeCnt = Integer.parseInt(br.readLine());

        // 2. 간선 리스트를 입력받는다.
        parents = new int[vertexCnt + 1];
        edges = new Edge[edgeCnt];
        while(edgeCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[edgeCnt] = new Edge(from, to, cost);
        }

        // 3. 간선 리스트를 비용 기준으로 오름차순 정렬한다.
        Arrays.sort(edges);

        // 4. 모든 정점을 최소 단위 서로소 집합으로 만든다.
        makeSet();

        int minimumCost = 0, selectEdgeCnt = 0;
        // 5. 간선의 비용이 적은 순부터 간선 리스트를 탐색한다.
        for (Edge edge : edges) {
            // 5-1. 간선에 연결된 두 정점이 아직 연결되지 않았으면 연결하고
            if(union(edge.from, edge.to)) {
                // 5-1-1. 최소비용에 추가한다.
                minimumCost += edge.cost;
                // 5-1-2. 총 연결된 간선의 개수가 vertexCnt-1개면 종료한다.
                if(++selectEdgeCnt == vertexCnt-1) break;
            }
        }

        // 6. 최소 비용을 출력한다.
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
