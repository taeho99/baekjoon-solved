import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  SWEA.3124 최소스패닝트리_크루스칼
 *
 *  1. 정점의 개수와 간선의 개수를 입력받는다.
 *  2. 인접행렬 정보를 입력받는다.
 *  3. 프림 알고리즘을 위해 minEdge[] 배열을 MAX_VALUE로 초기화한다.
 *  4. 0번 정점을 트리의 시작 정점으로 지정한다.
 *  5. 방문하지 않은 정점 중 간선의 비용이 최소인 정점을 구한다.
 *  6. 그 정점을 선택하여 트리에 넣고 비용의 합에 더한다.
 *  7. 선택된 정점과 다른 정점들을 비교해서 minEdge[] 값을 갱신한다.
 *  8. 최소 비용을 출력한다.
 */
public class Solution {
    static int vertexCnt, edgeCnt, selectCnt;
    static Node[] adjList;
    static int[] minEdge;
    static boolean[] visited;
    static long minimumCost;
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

            // 2. 인접행렬 정보를 입력받는다.
            adjList = new Node[vertexCnt];
            while(edgeCnt-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int weight = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, weight, adjList[from]);
                adjList[to] = new Node(from, weight, adjList[to]);
            }

            // 3. 프림 알고리즘을 위해 minEdge[] 배열을 MAX_VALUE로 초기화한다.
            minEdge = new int[vertexCnt];
            visited = new boolean[vertexCnt];
            Arrays.fill(minEdge, Integer.MAX_VALUE);
            // 4. 0번 정점을 트리의 시작 정점으로 지정한다.
            minEdge[0] = 0;

            minimumCost = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
            pq.add(new Node(0, 0, null));
            while(!pq.isEmpty()) {
                // 5. 방문하지 않은 정점 중 간선의 비용이 최소인 정점을 구한다.
                Node minVertex = pq.poll();
                if(visited[minVertex.to]) continue;

                // 6. 그 정점을 선택하여 트리에 넣고 비용의 합에 더한다.
                visited[minVertex.to] = true;
                minimumCost += minVertex.weight;

                // 7. 선택된 정점과 다른 정점들을 비교해서 minEdge[] 값을 갱신한다.
                for(Node temp = adjList[minVertex.to]; temp != null; temp = temp.next) {
                    pq.add(temp);
                }
            }

            // 6. 최소 비용을 출력한다.
            sb.append(minimumCost).append('\n');
        }
        System.out.print(sb);
    }

    static class Node {
        int to, weight;
        Node next;

        public Node(int to, int weight, Node next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }
}