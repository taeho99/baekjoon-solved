import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int maxBlue = 1;
        int startBlue = s.indexOf('B');
        int endBlue = s.lastIndexOf('B');
        if(startBlue != 0) maxBlue++;
        if(endBlue != n-1) maxBlue++;

        boolean flag = false;
        for(int i=startBlue+1; i<=endBlue; i++) {
            char c = s.charAt(i);
            if(c == 'R') {
                flag = true;
            }
            if(flag && c == 'B') {
                flag = false;
                maxBlue++;
            }
        }

        int maxRed = 1;
        int startRed = s.indexOf('R');
        int endRed = s.lastIndexOf('R');
        if(startRed != 0) maxRed++;
        if(endRed != n-1) maxRed++;

        flag = false;
        for(int i=startRed+1; i<=endRed; i++) {
            char c = s.charAt(i);
            if(c == 'B') {
                flag = true;
            }
            if(flag && c == 'R') {
                flag = false;
                maxRed++;
            }
        }

        System.out.println(Math.min(maxRed, maxBlue));
    }
}
