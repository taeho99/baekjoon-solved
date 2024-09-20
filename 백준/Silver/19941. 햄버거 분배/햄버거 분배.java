import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] position = br.readLine().toCharArray();
        boolean[] visited = new boolean[length];

        int result = 0;
        for(int idx=0; idx<length; idx++) {
            if(position[idx] == 'H') continue;
            for(int rIdx=idx-k; rIdx<=idx+k; rIdx++) {
                if(rIdx < 0 || rIdx >= length) continue;
                if(position[rIdx] == 'H' && !visited[rIdx]) {
                    result++;
                    visited[rIdx] = true;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}