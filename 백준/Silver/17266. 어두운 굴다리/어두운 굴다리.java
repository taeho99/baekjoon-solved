import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int lampCnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int prevLamp = Integer.parseInt(st.nextToken());

        int maxHeight = prevLamp;
        for(int idx=1; idx<lampCnt; idx++) {
            int nowLamp = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, (nowLamp-prevLamp+1)/2);
            prevLamp = nowLamp;
        }
        maxHeight = Math.max(maxHeight, length - prevLamp);

        System.out.print(maxHeight);
    }
}