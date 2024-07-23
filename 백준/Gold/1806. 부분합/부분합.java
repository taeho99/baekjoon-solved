import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 연속된 수의 부분합 중 S 이상 되는 것
 * 2. 그 중 가장 짧은 것
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, total = 0, result = Integer.MAX_VALUE;

        while(left <= n && right <= n) {
            if(total >= s) {
            }
            if(total >= s) {
                result = Math.min(result, right - left);
                total -= arr[left++];
            } else {
                total += arr[right++];
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}
