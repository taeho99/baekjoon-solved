import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String input;
        while(!(input = br.readLine()).equals("# 0 0")) {
            st = new StringTokenizer(input);
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (age > 17 || weight >= 80) {
                sb.append(name).append(' ').append("Senior").append('\n');
            } else {
                sb.append(name).append(' ').append("Junior").append('\n');
            }
        }
        System.out.print(sb);
    }
}