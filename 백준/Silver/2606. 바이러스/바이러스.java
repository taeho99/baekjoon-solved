import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        LinkedList<Integer> adj[] = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }

        for(int i=0; i<e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer u = Integer.parseInt(st.nextToken());
            Integer w = Integer.parseInt(st.nextToken());
            adj[u-1].add(w-1);
            adj[w-1].add(u-1);
        }

        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        int result = 0;

        visited[0] = true;
        queue.add(0);

        while(queue.size() != 0) {
            Integer s = queue.poll();

            for (Integer n : adj[s]) {
                if (!visited[n]) {
                    result++;
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        System.out.println(result);

    }
}
