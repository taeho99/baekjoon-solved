import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long x, y, z;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        z = y*100/x;
        if(z >= 99) {
            System.out.println(-1);
            return;
        }

        long lo = 0;
        long hi = (int)1e9;
        while(lo + 1 < hi) {
            long mid = (lo+hi) / 2;
            if ((y+mid)*100/(x+mid)>z) hi = mid;
            else lo = mid;
        }
        System.out.println(hi);
    }

}
