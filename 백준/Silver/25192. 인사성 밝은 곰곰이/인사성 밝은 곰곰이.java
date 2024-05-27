import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = null;
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        while(n-- > 0) {
            String s = br.readLine();
            if(s.equals("ENTER")) {
                set = new HashSet<>();
                continue;
            }

            if(!set.contains(s)) {
                set.add(s);
                result++;
            }
        }
        System.out.println(result);
    }
}
