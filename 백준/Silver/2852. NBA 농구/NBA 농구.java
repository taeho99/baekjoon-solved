import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] team = new int[n];
        int[] time = new int[n];
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            team[i] = s.charAt(0) - '0';
            time[i] = Integer.parseInt(s.substring(2, 4))*60 + Integer.parseInt(s.substring(5, 7));
        }
        int t = -1, idx = 0;
        int score = 0;
        int a = 0, b = 0;
        while(t++ < 2879) {
            if(idx < n && time[idx] == t) {
                if(team[idx] == 1)
                    score++;
                else
                    score--;
                idx++;
            }
            if(score > 0) {
                a++;
            } else if (score < 0) {
                b++;
            }
        }
        System.out.printf("%02d:%02d\n", a/60, a%60);
        System.out.printf("%02d:%02d", b/60, b%60);
    }
}
