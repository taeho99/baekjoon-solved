import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        if(s.length() % 3 == 2) {
            s = "0" + s;
        } else if (s.length() % 3 == 1) {
            s = "00" + s;
        }
        for(int i=0; i<s.length(); i+=3) {
            sb.append(Integer.parseInt(s.substring(i, i+3), 2));
        }
        System.out.println(sb);
    }
}
