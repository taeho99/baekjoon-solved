import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum1 = 0;
        int sum2 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int t = Integer.parseInt(st.nextToken());
            sum1 += (t / 30 + 1) * 10;
            sum2 += (t / 60 + 1) * 15;
        }
        if(sum1 == sum2) {
            System.out.print("Y M " + sum1);
        } else if (sum1 > sum2) {
            System.out.print("M " + sum2);
        } else {
            System.out.print("Y " + sum1);
        }
    }
}
