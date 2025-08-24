import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String op = br.readLine();
        String b = br.readLine();

        if(a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        if(op.equals("*")) {
            System.out.println(a + b.substring(1));
        } else {
            if(a.equals(b)) {
                System.out.println("2" + a.substring(1));
            } else {
                System.out.println(a.substring(0, a.length() - b.length()) + b);
            }
        }
    }
}
