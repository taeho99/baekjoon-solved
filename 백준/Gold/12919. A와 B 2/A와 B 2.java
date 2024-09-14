import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String original, target;
    static boolean success = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        original = br.readLine();
        target = br.readLine();

        recur(original);
        System.out.println(success ? 1 : 0);
    }

    private static void recur(String s) {
        if(!target.contains(s) && !(new StringBuffer(target).reverse()).toString().contains(s)) return;
//        System.out.println(s);

        if(s.length() > target.length()) {
            return;
        }

        if(s.equals(target)) {
            success = true;
            return;
        }

        recur(s + "A");
        recur(new StringBuffer(s + "B").reverse().toString());
    }
}