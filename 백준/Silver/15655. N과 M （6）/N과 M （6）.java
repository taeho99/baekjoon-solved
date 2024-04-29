import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, num;
    static boolean[] visited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        num = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        dfs(0, 0);
        System.out.print(sb);
    }

    private static void dfs(int depth, int at) {
        if(depth == m) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=at; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = num[i];
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
