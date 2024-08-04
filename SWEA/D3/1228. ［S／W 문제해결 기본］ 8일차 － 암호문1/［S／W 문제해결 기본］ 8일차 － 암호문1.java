import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t=1; t<=10; t++) {
            sb.append('#').append(t).append(' ');
            int size = Integer.parseInt(br.readLine());
            List<String> list = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<size; idx++) {
                list.add(st.nextToken());
            }

            int cmd = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<cmd; idx++) {
                st.nextToken(); // I 입력
                int insertIdx = Integer.parseInt(st.nextToken());
                int insertSize = Integer.parseInt(st.nextToken());
                while(insertSize-- > 0) {
                    list.add(insertIdx++, st.nextToken());
                }
            }

            for(int idx=0; idx<10; idx++) {
                sb.append(list.get(idx)).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
