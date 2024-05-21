import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dist = new long[n-1];
        long[] price = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long min = price[0];
        long sum = min*dist[0];
        for(int i=1; i<n-1; i++) {
            if(price[i] > min) {
                price[i] = min;
            } else {
                min = price[i];
            }
            sum += price[i]*dist[i];
        }
        System.out.println(sum);
    }
}
