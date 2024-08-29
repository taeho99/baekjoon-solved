import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  SWEA.1251 하나로
 *
 *  1. 섬의 개수와 각 섬의 좌표, 세율을 입력받는다.
 *      1-1. 각 섬의 좌표는 정점 배열에 저장한다.
 *  2. 정점 배열에서 연결 가능한 모든 간선을 구한다. (간선의 개수: v(v-1)/2)
 *      2-1. 두 정점 사이의 거리를 구하고 환경 부담금을 구해 간선의 비용으로 넣는다.
 *  3. 크루스칼 알고리즘을 위해 간선들을 비용 기준 오름차순으로 정렬한다.
 *  4. 각 정점을 최소 단위 서로소 집합으로 만든다.
 *  5. 간선의 비용이 적은 순부터 간선의 두 정점(start,end)가 아직 연결되지 않았으면 연결한다.
 *      5-1. 연결이 가능하면 현재 간선의 비용을 비용의 총합에 더한다.
 *      5-2. 선택된 간선이 V-1개면 종료한다. (MST는 간선이 V-1개)
 *  6. 최소 비용을 반올림하여 출력한다.
 */
public class Solution {
    static int vertexCnt, edgeCnt;
    static int[] parents;
    static double taxRate;
    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1, st2;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 섬의 개수와 각 섬의 좌표, 세율을 입력받는다.
            vertexCnt = Integer.parseInt(br.readLine()); // 0, 1, ... , (vertexCnt-1)
            Vertex[] vertices = new Vertex[vertexCnt];
            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            for(int idx=0; idx<vertexCnt; idx++) {
                // 1-1. 각 섬의 좌표는 정점 배열에 저장한다.
                vertices[idx] = new Vertex(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()));
            }
            taxRate = Double.parseDouble(br.readLine());

            // 2. 정점 배열에서 연결 가능한 모든 간선을 구한다. (간선의 개수: v(v-1)/2)
            edgeCnt = vertexCnt*(vertexCnt-1)/2;
            edges = new Edge[edgeCnt];
            for(int start=0; start<vertexCnt; start++) {
                for(int end=start+1; end<vertexCnt; end++) {
                    // 2-1. 두 정점 사이의 거리를 구하고 환경 부담금을 구해 간선의 비용으로 넣는다.
                    double dist = vertices[start].getDistance(vertices[end]);
                    edges[--edgeCnt] = new Edge(start, end, taxRate*dist*dist);
                }
            }

            // 3. 크루스칼 알고리즘을 위해 간선들을 비용 기준 오름차순으로 정렬한다.
            Arrays.sort(edges);
            // 4. 각 정점을 최소 단위 서로소 집합으로 만든다.
            makeSet();

            int selectEdgeCnt = 0;
            double minimumCost = 0;
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
            sb.append(Math.round(minimumCost)).append('\n');
        }
        System.out.print(sb);
    }

    static void makeSet() {
        parents = new int[vertexCnt];
        Arrays.fill(parents, -1);
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

    static class Vertex {
        int x, y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }

        double getDistance(Vertex v) {
            return Math.sqrt(Math.pow(this.x-v.x, 2) + Math.pow(this.y-v.y, 2));
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Double.compare(this.weight, e.weight);
        }
    }
}