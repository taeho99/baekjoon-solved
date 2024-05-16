import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f, s, g, u, d;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new int[f+1];
        System.out.println(bfs());
    }

    private static String bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = 1;

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            if(poll == g)
                return String.valueOf(visited[poll]-1);
            if(poll+u <= f && visited[poll+u] == 0) {
                queue.add(poll+u);
                visited[poll+u] = visited[poll]+1;
            }
            if(poll-d >= 1 && visited[poll-d] == 0) {
                queue.add(poll-d);
                visited[poll-d] = visited[poll]+1;
            }
        }
        return "use the stairs";
    }
}
