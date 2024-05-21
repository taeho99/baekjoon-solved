import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, c;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int lo = 1;
        int hi = arr[n-1] - arr[0] + 1;

        while(lo+1 < hi) {
            int mid = (lo+hi)/2;

            if(check(mid)) hi = mid;
            else lo = mid;
        }
        System.out.println(lo);
    }

    private static boolean check(int mid) {
        int count = 1;
        int last = arr[0];

        for(int i=1; i<n; i++) {
            if(arr[i] - last >= mid) {
                count++;
                last = arr[i];
            }
        }
        return count < c;
    }
}
