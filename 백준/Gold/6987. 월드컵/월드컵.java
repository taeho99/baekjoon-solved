import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 대진표
    static char[][] table = {
            {'A','B'},{'A','C'},{'A','D'},
            {'A','E'},{'A','F'},{'B','C'},
            {'B','D'},{'B','E'},{'B','F'},
            {'C','D'},{'C','E'},{'C','F'},
            {'D','E'},{'D','F'},{'E','F'}
    };

    static int[][] inputData;

    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = 4;

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            result = new int[6][3];
            inputData = new int[6][3];
            for(int row=0; row<6; row++) {
                for(int col=0; col<3; col++) {
                    inputData[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(powerSet(0) ? 1 : 0).append(' ');
        }
        System.out.print(sb);
    }

    static boolean powerSet(int selectIdx) {
        if(selectIdx == 15) {
            for(int row=0; row<6; row++) {
                for(int col=0; col<3; col++) {
                    if(result[row][col] != inputData[row][col])
                        return false;
                }
            }
            return true;
        }

        if(result[table[selectIdx][0] - 'A'][0] < inputData[table[selectIdx][0] - 'A'][0] &&
                result[table[selectIdx][1] - 'A'][2] < inputData[table[selectIdx][1] - 'A'][2]) {
            result[table[selectIdx][0] - 'A'][0]++;
            result[table[selectIdx][1] - 'A'][2]++;
            if (powerSet(selectIdx + 1)) return true;
            result[table[selectIdx][0] - 'A'][0]--;
            result[table[selectIdx][1] - 'A'][2]--;
        }


        if(result[table[selectIdx][0] - 'A'][1] < inputData[table[selectIdx][0] - 'A'][1] &&
                result[table[selectIdx][1] - 'A'][1] < inputData[table[selectIdx][1] - 'A'][1]) {
            result[table[selectIdx][0] - 'A'][1]++;
            result[table[selectIdx][1] - 'A'][1]++;
            if (powerSet(selectIdx + 1)) return true;
            result[table[selectIdx][0] - 'A'][1]--;
            result[table[selectIdx][1] - 'A'][1]--;
        }

        if(result[table[selectIdx][0] - 'A'][2] < inputData[table[selectIdx][0] - 'A'][2] &&
                result[table[selectIdx][1] - 'A'][0] < inputData[table[selectIdx][1] - 'A'][0]) {
            result[table[selectIdx][0] - 'A'][2]++;
            result[table[selectIdx][1] - 'A'][0]++;
            if (powerSet(selectIdx + 1)) return true;
            result[table[selectIdx][0] - 'A'][2]--;
            result[table[selectIdx][1] - 'A'][0]--;
        }
        return false;
    }
}