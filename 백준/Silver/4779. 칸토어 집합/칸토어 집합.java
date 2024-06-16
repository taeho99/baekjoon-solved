import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] arr;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            n = Integer.parseInt(s);
            arr = new boolean[(int)Math.pow(3, n)];
            Arrays.fill(arr, true);
            dfs(0, (int)Math.pow(3, n), n);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int start, int end, int depth) {
        if(depth == 0) {
            sb.append('-');
            return;
        }
        dfs(0, (int)Math.pow(3, depth-1), depth-1);
        for(int i=start/3; i<end/3; i++) {
            sb.append(' ');
        }
        dfs(((int)Math.pow(3, depth-1))*2, (int)Math.pow(3, depth), depth-1);
    }
}
