import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        set.add("ChongChong");
        for(int i=0; i<n; i++) {
            String[] split = br.readLine().split(" ");
            if(set.contains(split[0]) || set.contains(split[1])) {
                set.add(split[0]);
                set.add(split[1]);
            }
        }
        System.out.println(set.size());
    }
}
