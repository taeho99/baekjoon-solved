import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                String key = br.readLine().split(" ")[1];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int reduce = map.values().stream().mapToInt(i -> i+1).reduce(1, (a, b) -> a*b);
            sb.append(reduce-1).append('\n');
        }
        System.out.print(sb);
    }
}
