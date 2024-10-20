import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int vertexCnt, root, queryCnt;
    static int[] size;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexCnt = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        queryCnt = Integer.parseInt(st.nextToken());

        graph = new ArrayList[vertexCnt+1];
        size = new int[vertexCnt+1];
        visited = new boolean[vertexCnt+1];

        for(int idx=1; idx<=vertexCnt; idx++) {
            graph[idx] = new ArrayList<>();
        }

        for(int idx=0; idx<vertexCnt-1; idx++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        countSubtreeNodes(root, -1);

        while(queryCnt-- > 0) {
            sb.append(size[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.print(sb);
    }

    private static int countSubtreeNodes(int currentNode, int parent) {
        size[currentNode] = 1;
        for (int node : graph[currentNode]) {
            if(node != parent) {
                size[currentNode] += countSubtreeNodes(node, currentNode);
            }
        }
        return size[currentNode];
    }
}