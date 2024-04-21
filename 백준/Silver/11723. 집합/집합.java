import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        while(n-- > 0) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("add")) {
                set.add(Integer.parseInt(s[1]));
            } else if (s[0].equals("remove")) {
                set.remove(Integer.parseInt(s[1]));
            } else if (s[0].equals("check")) {
                sb.append(set.contains(Integer.parseInt(s[1])) ? '1' : '0').append('\n');
            } else if (s[0].equals("toggle")) {
                if(set.contains(Integer.parseInt(s[1])))
                    set.remove(Integer.parseInt(s[1]));
                else
                    set.add(Integer.parseInt(s[1]));
            } else if (s[0].equals("all")) {
                for(int i=1; i<=20; i++) set.add(i);
            } else {
                set.clear();
            }
        }
        System.out.print(sb);
    }
}
