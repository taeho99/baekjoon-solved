import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        for (char c : s.toCharArray()) {
            if(Character.isUpperCase(c)) {
                sb.append((c+13) > 'Z' ? (char)(c+13-26) : (char)(c+13));
            } else if (Character.isLowerCase(c)) {
                sb.append((c+13) > 'z' ? (char)(c+13-26) : (char)(c+13));
            } else {
                sb.append(c);
            }
        }
        System.out.print(sb);
    }
}
