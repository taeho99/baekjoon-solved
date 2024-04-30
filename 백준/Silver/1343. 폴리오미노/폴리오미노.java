import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.replaceAll("XXXX", "AAAA");
        s = s.replaceAll("XX", "BB");
        for (char c : s.toCharArray()) {
            if(c == 'X') {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(s);
    }
}
