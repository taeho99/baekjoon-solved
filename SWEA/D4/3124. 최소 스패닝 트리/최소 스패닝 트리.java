import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  SWEA.3124 최소스패닝트리_크루스칼
 *
 *  1. 정점의 개수와 간선의 개수를 입력받는다.
 *  2. 간선들의 정보를 입력받는다.
 *  3. 크루스칼 알고리즘을 위해 간선들을 비용 기준 오름차순으로 정렬한다.
 *  4. 각 정점을 최소 단위 서로소 집합으로 만든다.
 *  5. 간선의 비용이 적은 순부터 간선의 두 정점(start,end)가 아직 연결되지 않았으면 연결한다.
 *      5-1. 연결이 가능하면 현재 간선의 비용을 비용의 총합에 더한다.
 *      5-2. 선택된 간선이 V-1개면 종료한다. (MST는 간선이 V-1개)
 *  6. 최소 비용을 반올림하여 출력한다.
 */
public class Solution {
    static int vertexCnt, edgeCnt, selectEdgeCnt;
    static long minimumCost;
    static int[] parents;
    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 정점의 개수와 간선의 개수를 입력받는다.
            st = new StringTokenizer(br.readLine());
            vertexCnt = Integer.parseInt(st.nextToken()); // 0, 1, ... , (vertexCnt-1)
            edgeCnt = Integer.parseInt(st.nextToken());

            // 2. 간선들의 정보를 입력받는다.
            edges = new Edge[edgeCnt];
            for(int idx=0; idx<edgeCnt; idx++) {
                st = new StringTokenizer(br.readLine());
                edges[idx] = new Edge(Integer.parseInt(st.nextToken())-1,
                        Integer.parseInt(st.nextToken())-1,
                        Integer.parseInt(st.nextToken()));
            }

            // 3. 크루스칼 알고리즘을 위해 간선들을 비용 기준 오름차순으로 정렬한다.
            Arrays.sort(edges);
            // 4. 각 정점을 최소 단위 서로소 집합으로 만든다.
            makeSet();

            selectEdgeCnt = 0;
            minimumCost = 0;
            for (Edge edge : edges) {
                // 5. 간선의 비용이 적은 순부터 간선의 두 정점(start,end)가 아직 연결되지 않았으면 연결한다.
                if(union(edge.start, edge.end)) {
                    // 5-1. 연결이 가능하면 현재 간선의 비용을 비용의 총합에 더한다.
                    minimumCost += edge.weight;
                    // 5-2. 선택된 간선이 V-1개면 종료한다. (MST는 간선이 V-1개)
                    if(++selectEdgeCnt == vertexCnt-1) break;
                }
            }

            // 6. 최소 비용을 반올림하여 출력한다.
            sb.append(minimumCost).append('\n');
        }
        System.out.print(sb);
    }

    private static int findSet(int x) {
        if(x == parents[x]) return x;
        return parents[x] = findSet(parents[x]);
    }

    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    private static void makeSet() {
        parents = new int[vertexCnt];
        for(int idx=0; idx<vertexCnt; idx++) {
            parents[idx] = idx;
        }
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