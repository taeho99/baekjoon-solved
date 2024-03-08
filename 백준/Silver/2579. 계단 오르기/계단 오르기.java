import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] step = new int[n+1];
        int[] max = new int[n+1];
        for(int i=1; i<=n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }
        max[1] = step[1];
        if(n >= 2) {
            max[2] = step[1] + step[2];
        }
        for(int i=3; i<=n; i++) {
            max[i] = step[i] + Math.max(max[i-3] + step[i-1], max[i-2]);
        }
        System.out.print(max[n]);
    }
}
