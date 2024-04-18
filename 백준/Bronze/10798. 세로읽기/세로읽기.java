import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[5];
        for(int i=0; i<5; i++) {
            arr[i] = br.readLine();
        }
        for(int i=0; i<15; i++) {
            for(int j=0; j<5; j++) {
                String s = arr[j];
                if(i < s.length())
                    sb.append(s.charAt(i));
            }
        }
        System.out.print(sb);
    }
}
