import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int n, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<n; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(getUpperIdx(key) - getLowerIdx(key)).append(' ');
        }
        System.out.print(sb);
    }

    private static int getLowerIdx(int key) {
        int lo = 0, hi = n;
        while(lo < hi) {
            int mid = (lo+hi)/2;
            if(arr[mid] >= key) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }

    private static int getUpperIdx(int key) {
        int lo = 0, hi = n;
        while(lo < hi) {
            int mid = (lo+hi)/2;
            if(arr[mid] > key) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }
}