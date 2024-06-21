import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int result = 0;
            for(int i=x; i<=m*n; i+=m) {
                if(i%n == y) {
                    result = i + 1;
                    break;
                }
            }
            sb.append(result == 0 ? -1 : result).append('\n');
        }
        System.out.print(sb);
    }
}
