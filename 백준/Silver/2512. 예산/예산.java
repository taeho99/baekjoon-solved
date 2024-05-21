import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int lo = 1;
        int hi = 0;
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > hi) hi = arr[i];
            sum += arr[i];
        }

        m = Integer.parseInt(br.readLine());

        if(sum <= m) {
            System.out.println(hi);
            return;
        }

        while(lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if(check(mid)) lo = mid;
            else hi = mid;
        }
        System.out.println(lo);
    }

    static boolean check(int mid) {
        int sum = 0;
        for (int i : arr) {
            if(i > mid) sum += mid;
            else sum += i;
        }
        return sum <= m;
    }
}
