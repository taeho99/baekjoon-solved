import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int bound = (int) Math.round(n*0.15);
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        AtomicInteger idx = new AtomicInteger();
        System.out.println(Math.round(
                list.stream()
                    .filter(i -> bound < idx.incrementAndGet() && idx.get() <= n - bound)
                    .mapToInt(Integer::intValue).average().getAsDouble()));
    }
}
