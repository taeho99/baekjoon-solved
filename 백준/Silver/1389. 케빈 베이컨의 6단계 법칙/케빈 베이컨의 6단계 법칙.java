import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<Integer>[] adjSet = new HashSet[n+1];
        for(int i=1; i<=n; i++) {
            adjSet[i] = new HashSet<>();
        }
        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjSet[a].add(b);
            adjSet[b].add(a);
        }
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>(adjSet[i]);
        }

        int minCount = Integer.MAX_VALUE;
        int result = 0;
        for(int i=1; i<=n; i++) {
            boolean[] visited = new boolean[n+1];
            Queue<User> queue = new LinkedList<>();
            queue.add(new User(i, 1));
            visited[i] = true;
            int count = 0;

            while(!queue.isEmpty()) {
                User poll = queue.poll();
                for (int ad : adj[poll.num]) {
                    if(!visited[ad]) {
                        queue.add(new User(ad, poll.depth+1));
                        visited[ad] = true;
                        count += poll.depth;
                    }
                }
            }
            if(count < minCount) {
                minCount = count;
                result = i;
            }
        }
        System.out.println(result);
    }

    static class User {
        int num, depth;

        public User(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
}
