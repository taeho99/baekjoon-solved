import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        arr = new int[m];

        recur(n, m, 0);
        System.out.println(sb);
    }

    static void recur(int n, int m, int depth) {
        if(depth == m) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                recur(n, m, depth + 1);

                visit[i] = false;
            }
        }
    }
}
