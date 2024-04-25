import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        int count = 0;
        int max = -1;
        int p1 = 0, p2 = x;
        while(p2 < n) {
            max = Math.max(max, sum[p2] - sum[p1]);
            p1++;
            p2++;
        }
        if(max == 0) {
            System.out.println("SAD");
            return;
        }
        p1 = 0; p2 = x;
        while(p2 <= n) {
            if(max == sum[p2] - sum[p1]) {
                count++;
            }
            p1++;
            p2++;
        }
        System.out.println(max);
        System.out.println(count);
    }
}
