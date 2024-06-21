import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int result = 0;
        for(int i=0; i<=m-(2*n+1); i++) {
            boolean check = true;
            for(int j=0; j<2*n+1; j++) {
                char c = s.charAt(i + j);
                if((j % 2 == 0 && c == 'O') || (j % 2 == 1 && c == 'I')) {
                    check = false;
                    break;
                }
            }
            if(check) result++;
        }
        System.out.println(result);
    }
}
