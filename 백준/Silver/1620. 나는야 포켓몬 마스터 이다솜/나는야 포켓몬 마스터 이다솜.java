import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] list = new String[n+1];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++) {
            list[i] = br.readLine();
            map.put(list[i], i);
        }
        for(int i=0; i<m; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                sb.append(list[Integer.parseInt(str)]).append('\n');
            } else {
                sb.append(map.get(str)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
