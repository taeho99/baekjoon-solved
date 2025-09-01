import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            float gpa = 0.0f;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                sum += score;
                gpa += Float.parseFloat(st.nextToken()) * score;
            }
            sb.append(sum).append(' ').append(String.format("%.1f", (gpa/sum))).append('\n');
        }
        System.out.print(sb);
    }
}
