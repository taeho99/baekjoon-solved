import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int m = Integer.parseInt(br.readLine());
            sb.append((m/2)+1).append('\n');
            PriorityQueue<Integer> mnq = new PriorityQueue<>();
            PriorityQueue<Integer> mxq = new PriorityQueue<>(Collections.reverseOrder());
            StringTokenizer st = null;
            for(int i=0; i<m; i++) {
                if(i%10 == 0)
                    st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                if(mnq.size() == mxq.size()) {
                    mxq.add(x);
                } else {
                    mnq.add(x);
                }

                if(!mnq.isEmpty() && mnq.peek() < mxq.peek()) {
                    int mn = mnq.poll();
                    int mx = mxq.poll();
                    mnq.add(mx);
                    mxq.add(mn);
                }

                if(i%2 == 0) {
                    sb.append(mxq.peek()).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
