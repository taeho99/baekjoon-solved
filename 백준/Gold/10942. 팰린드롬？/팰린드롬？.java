import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx=1; idx<=size; idx++) {
            nums[idx] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[size+1][size+1];
        // 길이 == 1 일때
        for(int start=1; start<=size; start++) {
            int end = start;
            dp[start][end] = true;
        }
        // 길이 == 2 일 때
        for(int start=1; start<=size-1; start++) {
            int end = start+1;
            if(nums[start] == nums[end]) dp[start][end] = true;
        }
        // 길이 == 3 이상
        for(int len=2; len<size; len++) {
            for(int start=1; start<=size-len; start++) {
                int end = start+len;
                if(nums[start] == nums[end] && dp[start+1][end-1]) dp[start][end] = true;
            }
        }


        int cmdCnt = Integer.parseInt(br.readLine());
        while(cmdCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[start][end] ? 1 : 0).append('\n');
        }

        System.out.print(sb);
    }
}