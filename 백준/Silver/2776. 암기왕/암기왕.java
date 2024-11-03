import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            Set<String> set = new HashSet<>();

            int originalSize = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(originalSize-- > 0) {
                set.add(st.nextToken());
            }

            int targetSize = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(targetSize-- > 0) {
                sb.append(set.contains(st.nextToken()) ? 1 : 0).append('\n');
            }
        }

        System.out.print(sb);
    }
}