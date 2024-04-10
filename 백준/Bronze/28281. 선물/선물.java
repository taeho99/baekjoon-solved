import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] price = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++) {
            int num = price[i] * x + price[i + 1] * x;
            if(min > num) min = num;
        }

        System.out.println(min);
    }
}
