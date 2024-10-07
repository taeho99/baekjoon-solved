import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] xPos = new long[N+1];
        long[] yPos = new long[N+1];

        for(int idx=0; idx<N; idx++) {
            st = new StringTokenizer(br.readLine());

            xPos[idx] = Long.parseLong(st.nextToken());
            yPos[idx] = Long.parseLong(st.nextToken());
        }

        xPos[N] = xPos[0];
        yPos[N] = yPos[0];

        long sumA = 0, sumB = 0;
        for(int idx=0; idx<N; idx++) {
            sumA += xPos[idx] * yPos[idx+1];
            sumB += yPos[idx] * xPos[idx+1];
        }

        System.out.printf("%.1f", Math.abs(sumA - sumB) / 2.0);
    }
}