import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int vertexSize, edgeSize, start;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        vertexSize = Integer.parseInt(st.nextToken());
        edgeSize = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new int[vertexSize + 1];
        graph = new ArrayList[vertexSize + 1];
        for(int idx=1; idx<=vertexSize; idx++) {
            graph[idx] = new ArrayList<>();
        }

        while(edgeSize-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int idx=1; idx<=vertexSize; idx++) {
            Collections.sort(graph[idx], Collections.reverseOrder());
        }

        Queue<Integer> queue = new LinkedList<>();
        int seq = 0;
        visited[start] = ++seq;
        queue.add(start);

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            for (int adj : graph[poll]) {
                if(visited[adj] != 0) continue;
                visited[adj] = ++seq;
                queue.add(adj);
            }
        }

        for(int idx=1; idx<=vertexSize; idx++) {
            sb.append(visited[idx]).append('\n');
        }
        System.out.print(sb);
    }
}