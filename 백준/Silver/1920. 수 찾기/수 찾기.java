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
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> a = new ArrayList<>();
        StringTokenizer a_input = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a.add(Integer.parseInt(a_input.nextToken()));
        }

        Collections.sort(a);

        int m = Integer.parseInt(br.readLine());
        a_input = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            boolean flag = false;
            int findNum = Integer.parseInt(a_input.nextToken());
            int low = 0;
            int high = a.size() - 1;
            while(low <= high) {
                int mid = (low + high) / 2;
                if (a.get(mid) == findNum) {
                    sb.append("1").append("\n");
                    flag = true;
                    break;
                } else if (findNum < a.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (!flag) {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }
}
