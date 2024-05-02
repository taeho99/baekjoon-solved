import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        long low = 0, high = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }

        long mid;

        while(low + 1 < high) {
            mid = (low + high) / 2;
            if(check(mid)) low = mid;
            else high = mid;
        }
        System.out.println(low);
    }

    static boolean check(long height) {
        long sum = 0;
        for(int i=0; i<n; i++) {
            long tmp = arr[i] - height;
            if(tmp > 0) sum += tmp;
        }
        return sum >= m;
    }
}
