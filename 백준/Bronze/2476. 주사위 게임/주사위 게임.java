import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int max = 0;
        for(int idx=0; idx<size; idx++) {
            int[] dice = new int[3];
            st = new StringTokenizer(br.readLine());
            for(int diceIdx=0; diceIdx<3; diceIdx++) {
                dice[diceIdx] = Integer.parseInt(st.nextToken());
            }

            if(dice[0] == dice[1] && dice[1] == dice[2]) {
                max = Math.max(max, 10000+dice[0]*1000);
            } else if (dice[0] == dice[1]) {
                max = Math.max(max, 1000+dice[0]*100);
            } else if (dice[0] == dice[2]) {
                max = Math.max(max, 1000+dice[0]*100);
            } else if (dice[1] == dice[2]) {
                max = Math.max(max, 1000+dice[1]*100);
            } else {
                Arrays.sort(dice);
                max = Math.max(max, dice[2]*100);
            }
        }

        System.out.print(max);
    }
}