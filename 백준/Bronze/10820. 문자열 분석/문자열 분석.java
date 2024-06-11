import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            int a, b, c, d;
            a = b = c = d = 0;
            for (char ch : s.toCharArray()){
                if(Character.isLowerCase(ch)) a++;
                else if(Character.isUpperCase(ch)) b++;
                else if(Character.isDigit(ch)) c++;
                else d++;
            }
            System.out.println(a + " " + b + " " + c + " " + d);
        }
    }
}
