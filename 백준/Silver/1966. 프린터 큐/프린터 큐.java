import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int[] priorities = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                int add = Integer.parseInt(st.nextToken());
                priorities[i] = add;
                pq.add(add);
            }

            int count = 0;

            while(!pq.isEmpty()) {
                boolean is = false;
                for(int i=0; i<n; i++) {
                    if(!pq.isEmpty() && pq.peek() == priorities[i]) {
                        pq.poll();
                        count++;

                        if(i == m) {
                            sb.append(count).append('\n');
                            is = true;
                            break;
                        }
                    }
                }
                if(is) break;
            }
        }
        System.out.print(sb);
    }
}
