import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[vertexSize+1];
        for(int idx=1; idx<=vertexSize; idx++) {
            graph[idx] = new ArrayList<>();
        }

        while(edgeSize-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int max = 0;
        int[] result = new int[vertexSize+1];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited;
        for(int start=1; start<=vertexSize; start++) {
            visited = new boolean[vertexSize+1];
            queue.add(start);
            visited[start] = true;

            while(!queue.isEmpty()) {
                result[start]++;
                int poll = queue.poll();
                for (int next : graph[poll]) {
                    if(visited[next]) continue;
                    queue.add(next);
                    visited[next] = true;
                }
            }

            max = Math.max(max, result[start]);
        }

        for(int idx=1; idx<=vertexSize; idx++) {
            if(result[idx] == max) {
                sb.append(idx).append(' ');
            }
        }
        System.out.print(sb);
    }
}
