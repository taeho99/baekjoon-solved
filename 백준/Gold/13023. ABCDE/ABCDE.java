import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  BOJ.13023 ABCDE
 *
 *  0. 각 사람을 정점, 관계를 간선이라 하면, 연속된 5개의 정점이 간선으로 연결되어 있어야 함
 *  1. 정점과 간선의 개수를 입력받는다.
 *      1-1. 인접 리스트를 만든다.
 *  2. 모든 정점에서 DFS 탐색을 해본다.
 *      2-0. 정답 찾은 경우 더이상 진행X
 *      2-1. [기저조건] 연속된 5개 정점 찾았으므로 더이상 진행 X. result 변수 -> 1로 변경
 *      2-2. 현재 정점 방문 표시
 *      2-3. 인접 정점들을 확인
 *          2-3-1. 방문하지 않은 정점이면 탐색하기
 *      2-4. 탐색 끝났으므로 방문 표시 삭제
 *  3. 결과값 출력
 */
public class Main {
    static int vertexCnt, edgeCnt, result = 0;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 정점과 간선의 개수를 입력받는다.
        vertexCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[vertexCnt];
        visited = new boolean[vertexCnt];
        for(int idx=0; idx<vertexCnt; idx++) {
            adjList[idx] = new ArrayList<>();
        }

        // 1-1. 인접 리스트를 만든다.
        for(int idx=0; idx<edgeCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        // 2. 모든 정점에서 DFS 탐색을 해본다.
        for(int vertexIdx=0; vertexIdx<vertexCnt; vertexIdx++) {
            // 2-0. 정답 찾은 경우 더이상 진행X
            if(result == 1) break;
            dfs(vertexIdx, 1);
        }

        // 3. 결과값 출력
        System.out.print(result);
    }

    private static void dfs(int curVertex, int depth) {
        // 2-1. [기저조건] 연속된 5개 정점 찾았으므로 더이상 진행 X. result 변수 -> 1로 변경
        if(depth == 5) {
            result = 1;
            return;
        }

        // 2-2. 현재 정점 방문 표시
        visited[curVertex] = true;
        // 2-3. 인접 정점들을 확인
        for (int to : adjList[curVertex]) {
            // 2-3-1. 방문하지 않은 정점이면 탐색하기
            if(visited[to]) continue;
            dfs(to, depth+1);
        }
        // 2-4. 탐색 끝났으므로 방문 표시 삭제
        visited[curVertex] = false;
    }
}