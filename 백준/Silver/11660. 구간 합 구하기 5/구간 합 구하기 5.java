import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] s = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                if(j == 0)
                    s[i][j] = Integer.parseInt(st.nextToken());
                else
                    s[i][j] = s[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            long sum = 0;
            for(int j=y1-1; j<=y2-1; j++) {
                sum += s[j][x2-1];
                if(x1-2 >= 0)
                    sum -= s[j][x1-2];
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
