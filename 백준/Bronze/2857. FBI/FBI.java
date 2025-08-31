import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int idx=1; idx<=5; idx++) {
            sb.append(br.readLine().contains("FBI") ? idx + " " : "");
        }
        System.out.println(sb.length() == 0 ? "HE GOT AWAY!" : sb);
    }
}
