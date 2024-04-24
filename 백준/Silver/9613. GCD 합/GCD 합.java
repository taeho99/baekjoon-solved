import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for(int i=0; i<n; i++) {
                for(int j=i+1; j<n; j++) {
                    sum += gcd(arr[i], arr[j]);
                }
            }
            System.out.println(sum);
        }
    }

    private static long gcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while(b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
