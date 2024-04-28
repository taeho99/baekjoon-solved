import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] music = new int[n+1];
        int[] mis = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            music[i] = Integer.parseInt(st.nextToken());
            if(music[i-1] > music[i]) {
                mis[i-1]++;
            }
            mis[i] = mis[i-1];
        }

        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(mis[y-1] - mis[x-1]).append('\n');
        }
        System.out.print(sb);
    }
}
