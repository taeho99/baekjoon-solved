import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int result;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int vertexCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());
        graph = new ArrayList[vertexCnt+1];
        visited = new boolean[vertexCnt+1];

        for(int vertex=1; vertex<=vertexCnt; vertex++) {
            graph[vertex] = new ArrayList<>();
        }

        while(edgeCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited[1] = true;
        dfs(1, 0);

        for(int idx=2; idx<=vertexCnt; idx++) {
            if(visited[idx]) result++;
        }
        System.out.println(result);
    }

    private static void dfs(int vertex, int depth) {
        if (depth == 2) {
            return;
        }

        for (int next : graph[vertex]) {
            visited[next] = true;
            dfs(next, depth+1);
        }
    }
}