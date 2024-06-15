import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] parent = new int[n+1];
        for(int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i : adj[poll]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    parent[i] = poll;
                }
            }
        }
        for(int i=2; i<=n; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);
    }
}
