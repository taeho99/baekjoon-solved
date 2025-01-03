import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int MAX = 1000001;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int[] dp = new int[MAX+1];
        int[] trace = new int[MAX+1];

        for(int idx = 2; idx<= MAX; idx++) {
            dp[idx] = dp[idx-1] + 1;
            trace[idx] = idx-1;

            if(idx % 2 == 0 && dp[idx/2]+1 < dp[idx]) {
                dp[idx] = dp[idx/2] + 1;
                trace[idx] = idx/2;
            }

            if(idx % 3 == 0 && dp[idx/3]+1 < dp[idx]) {
                dp[idx] = dp[idx/3] + 1;
                trace[idx] = idx/3;
            }
        }

        sb.append(dp[num]).append('\n');
        while(num > 0) {
            sb.append(num).append(' ');
            num = trace[num];
        }
        System.out.print(sb);

    }
}