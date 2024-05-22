import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] card;
    static int result = 0, n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        card = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int start, int depth) {
        if(depth == 3) {
            int sum = 0;
            for(int i=0; i<n; i++) {
                if(visited[i]) sum += card[i];
            }
            if(sum > result && sum <= m) {
                result = sum;
            }
            return;
        }
        for(int i=start; i<n; i++) {
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }
}
