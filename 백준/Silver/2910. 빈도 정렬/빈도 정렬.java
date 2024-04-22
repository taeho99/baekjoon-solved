import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int seq = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Map<Integer, Value> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)) {
                map.get(num).count++;
            } else {
                map.put(num, new Value(++seq, 1));
            }
            list.add(num);
        }
        list.sort((o1, o2) -> {
            if(map.get(o1).count == map.get(o2).count)
                return Integer.compare(map.get(o1).order, map.get(o2).order);
            return Integer.compare(map.get(o2).count, map.get(o1).count);
        });

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
    static class Value {
        int order;
        int count;

        public Value(int order, int count) {
            this.order = order;
            this.count = count;
        }
    }
}
