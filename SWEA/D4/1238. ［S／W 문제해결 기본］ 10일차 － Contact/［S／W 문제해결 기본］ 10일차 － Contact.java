import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  SWEA.1238 Contact
 *
 *  1. 데이터 쌍의 개수(from, to)와 시작 지점을 입력받고 인접리스트를 초기화한다.
 *  2. 데이터 쌍의 개수만큼 인접 리스트로 그래프를 만든다. (가중치 없는 유향 그래프)
 *  3. 시작 지점부터 BFS 탐색을 하며 연락을 돌린다.
 *      3-1. 만약 현재 연락을 받은 사람이 직전 연락을 받은 사람과 연락을 받은 시각(depth)가 다르다면
 *          3-1-1. prevDepth를 갱신하고 가장 높은 번호를 초기화한다.
 *      3-2. 현재 연락한 번호가 동시간에서 가장 높은 번호면 result를 갱신한다.
 *      3-3. 인접한 번호를 큐에 추가하고 방문처리 한다.
 *  4. 마지막 타임에 연락을 받은 사람 중 가장 높은 번호를 출력한다.
 */
public class Solution {
    static int dataCnt, start;
    static Node[] adjList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 10;
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 데이터 쌍의 개수(from, to)와 시작 지점을 입력받고 인접리스트를 초기화한다.
            st = new StringTokenizer(br.readLine());
            dataCnt = Integer.parseInt(st.nextToken()) / 2;
            start = Integer.parseInt(st.nextToken());
            adjList = new Node[101];

            // 2. 데이터 쌍의 개수만큼 인접 리스트로 그래프를 만든다. (가중치 없는 유향 그래프)
            st = new StringTokenizer(br.readLine());
            while(dataCnt-- > 0) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, adjList[from]);
            }

            int result = 0;
            int prevDepth = 0;

            // 3. 시작 지점부터 BFS 탐색을 하며 연락을 돌린다.
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[101];
            queue.add(new int[] {start, 0});
            visited[start] = true;

            while(!queue.isEmpty()) {
                int[] poll = queue.poll();

                // 3-1. 만약 현재 연락을 받은 사람이 직전 연락을 받은 사람과 연락을 받은 시각(depth)가 다르다면
                if(prevDepth != poll[1]) {
                    // 3-1-1. prevDepth를 갱신하고 가장 높은 번호를 초기화한다.
                    prevDepth = poll[1];
                    result = 0;
                }

                // 3-2. 현재 연락한 번호가 동시간에서 가장 높은 번호면 result를 갱신한다.
                result = Math.max(result, poll[0]);

                // 3-3. 인접한 번호를 큐에 추가하고 방문처리 한다.
                for(Node temp = adjList[poll[0]]; temp != null; temp = temp.next) {
                    if(visited[temp.to]) continue;
                    queue.add(new int[] {temp.to, prevDepth + 1});
                    visited[temp.to] = true;

                }
            }

            // 4. 마지막 타임에 연락을 받은 사람 중 가장 높은 번호를 출력한다.
            sb.append(result).append('\n');
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