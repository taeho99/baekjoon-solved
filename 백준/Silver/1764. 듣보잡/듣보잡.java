import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(br.readLine());
        }
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<m; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                count++;
                list.add(s);
            }
        }
        list.stream().sorted().forEach(s -> sb.append(s).append('\n'));
        System.out.println(count);
        System.out.print(sb);
    }
}
