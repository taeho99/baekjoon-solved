import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int vertexCnt, edgeCnt, result = 0;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertexCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[vertexCnt];
        for(int idx=0; idx<vertexCnt; idx++) {
            adjList[idx] = new ArrayList<>();
        }

        for(int idx=0; idx<edgeCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        // 모든 정점에서 dfs 탐색 시도해보기
        for(int vertexIdx=0; vertexIdx<vertexCnt; vertexIdx++) {
            if(result == 1) break;
            visited = new boolean[vertexCnt];
            dfs(vertexIdx, 1);
        }
        System.out.print(result);
    }

    private static void dfs(int curVertex, int depth) {
        if(result == 1) return;
        if(depth == 5) {
            result = 1;
            return;
        }

        visited[curVertex] = true;
        for (int to : adjList[curVertex]) {
            if(visited[to]) continue;
            dfs(to, depth+1);
        }
        visited[curVertex] = false;
    }
}