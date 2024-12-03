import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        for(int idx=0; idx<size; idx++) {
            arr[idx] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int gcd = 0;
        for(int idx=0; idx<size-1; idx++) {
            int dist = arr[idx+1] - arr[idx];
            gcd = gcd(dist, gcd);
        }

        System.out.println(((arr[size - 1] - arr[0]) / gcd) + 1 - size);
    }

    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}