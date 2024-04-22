import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String s1 = s.substring(0, s.length() / 2);
        StringBuilder s2 = new StringBuilder(s.substring((s.length() + 1) / 2));
        System.out.println(s1.contentEquals(s2.reverse()) ? 1 : 0);
    }
}
