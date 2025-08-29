import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        HashSet<Character> set = new HashSet<>(Arrays.asList('C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E'));
        StringBuilder sb = new StringBuilder();
        for (char c : input) {
            if(!set.contains(c)) {
                sb.append(c);
            }
        }
        System.out.print(sb);
    }
}
