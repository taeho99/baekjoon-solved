import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] kind = new int[10];
        int count = 0, lo = 0, result = 0;
        for(int hi = 0; hi<n; hi++) {
            kind[arr[hi]]++;
            if(kind[arr[hi]] == 1) count++;
            while(count > 2) {
                kind[arr[lo]]--;
                if(kind[arr[lo]] == 0) count--;
                lo++;
            }
            result = Math.max(result, hi - lo + 1);
        }
        System.out.println(result);
    }
}
