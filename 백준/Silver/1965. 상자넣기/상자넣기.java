import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] box = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<size; idx++) {
            box[idx] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[size];
        dp[0] = 1;
        for(int idx=1; idx<size; idx++) {
            int max = 0;
            for(int j=0; j<idx; j++) {
                if(box[idx] <= box[j]) continue;
                max = Math.max(dp[j], max);
            }
            dp[idx] = max + 1;
        }

        int result = 0;
        for(int idx=0; idx<size; idx++) {
            result = Math.max(dp[idx], result);
        }
        System.out.print(result);
    }
}