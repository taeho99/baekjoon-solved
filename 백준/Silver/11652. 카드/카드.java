import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Long, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        while(n-- > 0) {
            long k = sc.nextLong();
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        map.keySet().stream().max((o1, o2) -> {
            if (Objects.equals(map.get(o1), map.get(o2)))
                return Long.compare(o2, o1);
            return Integer.compare(map.get(o1), map.get(o2));
        }).ifPresent(System.out::print);
    }
}
