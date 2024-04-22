import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            sum++;
            if(!map.containsKey(s)) list.add(s);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        Collections.sort(list);
        for (String key : list) {
            System.out.printf("%s %.4f\n", key, (double)map.get(key) / sum * 100);
        }
    }
}
