import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  BOJ.2252 줄세우기
 *
 *  1. 정점과 간선의 크기, 간선의 정보를 입력받아 노드로 이루어진 그래프를 만든다.
 *      1-1. 위상정렬을 위해 각 정점의 진입 차수를 기록한다.
 *  2. 진입 차수가 0인 정점을 먼저 큐에 모두 추가한다.
 *  3. 큐에서 진입 차수가 0인 정점을 꺼내어 인접한 노드의 간선을 제거(진입 차수 1 감소)한다.
 *      3-1. 간선 제거 후 진입 차수가 0이 된 정점은 다시 큐에 넣는다.
 *  4. 작업 순서를 출력한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 1. 정점과 간선의 크기, 간선의 정보를 입력받아 노드로 이루어진 그래프를 만든다.
        st = new StringTokenizer(br.readLine());
        int vertexCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());

        Node[] graph = new Node[vertexCnt + 1];
        int[] inDegree = new int[vertexCnt + 1]; //진입 차수
        for(int idx=1; idx<=edgeCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1] = new Node(v2, graph[v1]);
            // 1-1. 위상정렬을 위해 각 정점의 진입 차수를 기록한다.
            inDegree[v2]++;
        }

        // 2. 진입 차수가 0인 정점을 먼저 큐에 모두 추가한다.
        Queue<Integer> queue = new LinkedList<>();
        for(int idx=1; idx<=vertexCnt; idx++) {
            if(inDegree[idx] == 0) queue.add(idx);
        }

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            // 4. 작업 순서를 출력한다.
            sb.append(poll).append(' ');

            // 3. 큐에서 진입 차수가 0인 정점을 꺼내어 인접한 노드의 간선을 제거(진입 차수 1 감소)한다.
            for (Node node = graph[poll]; node != null; node = node.next) {
                if (--inDegree[node.to] == 0)
                    // 3-1. 간선 제거 후 진입 차수가 0이 된 정점은 다시 큐에 넣는다.
                    queue.add(node.to);
            }
        }
        System.out.print(sb);
    }

    static class Node {
        int to;
        Node next;

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }
}