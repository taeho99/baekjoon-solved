import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxStudent = Integer.parseInt(st.nextToken());
        int cmdCnt = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();

        while(cmdCnt-- > 0) {
            String student = br.readLine();
            set.remove(student);
            set.add(student);
        }


        for (String s : set) {
            if(maxStudent-- > 0) {
                sb.append(s).append('\n');
            } else break;
        }
        System.out.print(sb);
    }

}