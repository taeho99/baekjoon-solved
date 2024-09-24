import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int titleCnt = Integer.parseInt(st.nextToken());
        int characterCnt = Integer.parseInt(st.nextToken());

        String[] title = new String[titleCnt];
        int[] titlePower = new int[titleCnt];
        for(int idx=0; idx<titleCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            title[idx] = st.nextToken();
            titlePower[idx] = Integer.parseInt(st.nextToken());
        }

        for(int idx=0; idx<characterCnt; idx++) {
            int characterPower = Integer.parseInt(br.readLine());

            int start = 0;
            int end = titleCnt-1;
            while(start <= end) {
                int mid = (start+end)/2;

                if(titlePower[mid] >= characterPower) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
            sb.append(title[start]).append('\n');
        }
        System.out.print(sb);
    }
}