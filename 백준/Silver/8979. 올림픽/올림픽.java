import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        for(int idx=0; idx<n; idx++) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[5];
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            tmp[2] = Integer.parseInt(st.nextToken());
            tmp[3] = Integer.parseInt(st.nextToken());
            list.add(tmp);
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    return Integer.compare(o2[3], o1[3]);
                } return Integer.compare(o2[2], o1[2]);
            } return Integer.compare(o2[1], o1[1]);
        });

        list.get(0)[4] = 1;
        for(int idx=1; idx<n; idx++) {
            int[] prev = list.get(idx-1);
            int[] now = list.get(idx);

            if(prev[1] == now[1] && prev[2] == now[2] && prev[3] == now[3]) {
                now[4] = prev[4];
            } else {
                now[4] = idx + 1;
            }

            if(now[0] == k) {
                System.out.println(now[4]);
                return;
            }
        }
    }
}