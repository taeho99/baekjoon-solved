import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    static ArrayList<int[]> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        result = new ArrayList<>();
        BigInteger count = new BigInteger("2");
        System.out.println(count.pow(n).subtract(new BigInteger("1")));

        if(n <= 20) {
            hanoi(n, 1, 2, 3);
            for (int[] a : result) {
                System.out.println(a[0] + " " + a[1]);
            }
        }
    }

    static void hanoi(int n, int a, int b, int c) {
        if(n == 1) {
            result.add(new int[] {a, c});
        } else {
            hanoi(n-1, a, c, b);
            result.add(new int[] {a, c});
            hanoi(n-1, b, a, c);
        }
    }
}
