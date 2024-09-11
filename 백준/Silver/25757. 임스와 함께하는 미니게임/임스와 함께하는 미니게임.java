import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int type = st.nextToken().charAt(0);

        int div = type == 'Y' ? 1 : ((type == 'F') ? 2 : 3);
        Set<String> set = new HashSet<>();
        while(n-- > 0) {
            set.add(br.readLine());
        }

        System.out.print(set.size() / div);
    }
}