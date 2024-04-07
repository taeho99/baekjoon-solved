import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for(int i=0; i<s.length(); i++) {
            String str = Integer.toBinaryString(s.charAt(i) - '0');
            if(i != 0 && str.length() == 1)
                str = "00" + str;
            else if (i != 0 && str.length() == 2)
                str = "0" + str;
            sb.append(str);
        }
        System.out.println(sb);
    }
}
