import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<int[]> lectures = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new int[] {start, end});
        }

        Collections.sort(lectures, (o1, o2) -> {
            if(o1[0] == o2[0])
                return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures.get(0)[1]);

        for(int i=1; i<n; i++) {
            int[] get = lectures.get(i);
            int start = get[0];
            if(start >= pq.peek()) {
                pq.poll();
            }
            pq.add(get[1]);
        }
        System.out.println(pq.size());
    }
}
