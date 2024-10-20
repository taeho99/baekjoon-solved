import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph, tree;
    static int vertexCnt, root, queryCnt;
    static int[] parents, size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexCnt = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        queryCnt = Integer.parseInt(st.nextToken());

        graph = new ArrayList[vertexCnt+1];
        tree = new ArrayList[vertexCnt+1];
        parents = new int[vertexCnt+1];
        size = new int[vertexCnt+1];

        for(int idx=1; idx<=vertexCnt; idx++) {
            graph[idx] = new ArrayList<>();
            tree[idx] = new ArrayList<>();
        }

        for(int idx=0; idx<vertexCnt-1; idx++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        makeTree(root, -1);
        countSubtreeNodes(root);

        while(queryCnt-- > 0) {
            sb.append(size[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.print(sb);
    }

    private static void countSubtreeNodes(int currentNode) {
        size[currentNode] = 1;
        for (int node : tree[currentNode]) {
            if(size[node] == 0)
                countSubtreeNodes(node);
            size[currentNode] += size[node];
        }
    }

    private static void makeTree(int currentNode, int parent) {
        for (int node : graph[currentNode]) {
            if(node != parent) {
                tree[currentNode].add(node);
                parents[node] = currentNode;
                makeTree(node, currentNode);
            }
        }
    }
}