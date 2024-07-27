import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n, m, k, x;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        dist = new int[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            if(dist[poll] == k) {
                result.add(poll);
            }
            if(dist[poll] > k) break;

            for(int now : graph.get(poll)) {
                if (!visited[now]) {
                    visited[now] = true;
                    queue.add(now);
                    dist[now] = dist[poll] + 1;
                }
            }
        }

        Collections.sort(result);
        for (int i : result) {
            sb.append(i).append('\n');
        }
        System.out.print(result.isEmpty() ? "-1" : sb);
    }
}
