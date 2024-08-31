import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  SWEA.3124 최소스패닝트리_프림
 *
 *  1. 정점의 개수와 간선의 개수를 입력받는다.
 *  2. 인접리스트 정보를 입력받는다.
 *  3. 정점이 트리에 속해있는지 여부를 체크하는 배열 초기화
 *  4. PQ 초기화 -> 비용 기준 오름차순 정렬 (비용이 작은 정점부터 poll 됨)
 *      4-1. 0번 정점부터 트리에 넣어 인접 정점들을 확인한다.
 *  5. PQ에서 꺼내면, 비용이 가장 작은 정점이 꺼내짐
 *      5-1. 만약, 이미 트리에 속한 정점이면 continue
 *  6. 트리에 속하지 않은 정점이면, 트리에 넣고 비용의 합을 갱신
 *  7. 현재 정점의 인접 정점들을 모두 PQ에 삽입한다.
 *  8. 최소 비용을 출력한다.
 */
public class Solution {
    static int vertexCnt, edgeCnt;
    static Node[] adjList;
    static boolean[] visited;
    static long minimumCost;
    static PriorityQueue<Node> pq;
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

            // 2. 인접리스트 정보를 입력받는다.
            adjList = new Node[vertexCnt];
            while(edgeCnt-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int weight = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, weight, adjList[from]);
                adjList[to] = new Node(from, weight, adjList[to]);
            }

            // 3. 정점이 트리에 속해있는지 여부를 체크하는 배열 초기화
            visited = new boolean[vertexCnt];
            minimumCost = 0;

            // 4. PQ 초기화 -> 비용 기준 오름차순 정렬 (비용이 작은 정점부터 poll 됨)
            pq = new PriorityQueue<>();
            // 4-1. 0번 정점부터 트리에 넣어 인접 정점들을 확인한다.
            pq.add(new Node(0, 0, null));
            while(!pq.isEmpty()) {
                // 5. PQ에서 꺼내면, 비용이 가장 작은 정점이 꺼내짐
                Node minVertex = pq.poll();
                // 5-1. 만약, 이미 트리에 속한 정점이면 continue
                if(visited[minVertex.to]) continue;

                // 6. 트리에 속하지 않은 정점이면, 트리에 넣고 비용의 합을 갱신
                visited[minVertex.to] = true;
                minimumCost += minVertex.weight;

                // 7. 현재 정점의 인접 정점들을 모두 PQ에 삽입한다.
                for(Node temp = adjList[minVertex.to]; temp != null; temp = temp.next) {
                    pq.add(temp);
                }
            }

            // 8. 최소 비용을 출력한다.
            sb.append(minimumCost).append('\n');
        }
        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int to, weight;
        Node next;

        public Node(int to, int weight, Node next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }

        // 간선의 비용을 기준으로 오름차순 정렬한다.
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}