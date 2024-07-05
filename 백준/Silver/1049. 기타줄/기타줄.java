import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] pack = new int[m];
        int[] piece = new int[m];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            piece[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pack);
        Arrays.sort(piece);
        int a = pack[0] * (((n - 1) / 6) + 1);
        int b = pack[0] * (n / 6) + piece[0] * (n % 6);
        int c = piece[0] * n;
        int result = Math.min(a, Math.min(b, c));
        System.out.println(result);
    }
}
