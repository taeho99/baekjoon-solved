import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] arr = new char[5][15];
        for(int i=0; i<5; i++) {
            String s = br.readLine();
            for(int j=0; j<15; j++) {
                if(j < s.length())
                    arr[i][j] = s.charAt(j);
            }
        }
        for(int i=0; i<15; i++) {
            for(int j=0; j<5; j++) {
                char c = arr[j][i];
                if(c != 0) sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
