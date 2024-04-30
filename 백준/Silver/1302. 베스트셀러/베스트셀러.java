import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        map.keySet().stream().min((o1, o2) -> {
            if (Objects.equals(map.get(o1), map.get(o2))) {
                return o1.compareTo(o2);
            }
            return Integer.compare(map.get(o2), map.get(o1));
        }).ifPresent(System.out::print);
    }
}
