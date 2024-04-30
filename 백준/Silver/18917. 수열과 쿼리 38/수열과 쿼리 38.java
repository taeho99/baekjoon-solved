import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0; i<q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                sum1 += x;
                sum2 ^= x;
            } else if (cmd == 2) {
                int x = Integer.parseInt(st.nextToken());
                sum1 -= x;
                sum2 ^= x;
            } else if (cmd == 3) {
                sb.append(sum1).append('\n');
            } else {
                sb.append(sum2).append('\n');
            }
        }
        System.out.print(sb);
    }
}
