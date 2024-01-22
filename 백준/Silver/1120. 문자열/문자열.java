import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String a = input.next();
        String b = input.next();

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<b.length() - a.length() + 1; i++) {
            int cnt = 0;
            for(int j=0; j<a.length(); j++) {
                if (a.charAt(j) != b.charAt(j + i)) cnt++;
            }
            result.add(cnt);
        }

        System.out.println(Collections.min(result));
    }
}
