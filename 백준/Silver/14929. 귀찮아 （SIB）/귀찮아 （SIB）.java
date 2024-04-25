import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        int[] arr = new int[n];
        int[] s = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 0)
                s[i] = arr[i];
            else
                s[i] = s[i-1] + arr[i];
        }
        for(int i=0; i<n-1; i++) {
            sum += arr[i] * (s[n-1]-s[i]);
        }
        System.out.println(sum);
    }
}
