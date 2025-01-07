import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int aCnt = 1;
        int bCnt = 0;
        while(k-- > 0) {
            int tmp = aCnt;
            aCnt = bCnt;
            bCnt += tmp;
        }
        System.out.print(aCnt + " " + bCnt);
    }
}