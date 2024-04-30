import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            if(s[1].equals("enter")) {
                set.add(s[0]);
            } else {
                set.remove(s[0]);
            }
        }
        set.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}
