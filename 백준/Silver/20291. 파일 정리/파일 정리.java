import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        while(n-- > 0) {
            String s = sc.next().split("\\.")[1];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        map.keySet().stream().sorted().forEach(s -> sb.append(s).append(' ').append(map.get(s)).append('\n'));
        System.out.print(sb);
    }
}
