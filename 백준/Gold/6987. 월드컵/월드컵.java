import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 대진표
    static char[][] table = {
            {'A','O','B'},{'A','O','C'},{'A','O','D'},
            {'A','O','E'},{'A','O','F'},{'B','O','C'},
            {'B','O','D'},{'B','O','E'},{'B','O','F'},
            {'C','O','D'},{'C','O','E'},{'C','O','F'},
            {'D','O','E'},{'D','O','F'},{'E','O','F'}
    };

    static int[] inputData;

    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = 4;

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            result = new int[6][3];
            inputData = new int[18];
            for(int idx=0; idx<18; idx++) {
                inputData[idx] = Integer.parseInt(st.nextToken());
            }

            sb.append(powerSet(0) ? 1 : 0).append(' ');
        }
        System.out.print(sb);
    }

    static boolean powerSet(int selectIdx) {
        if(selectIdx == 15) {
            boolean success = true;
            for(int row=0; row<6; row++) {
                for(int col=0; col<3; col++) {
                    if(result[row][col] != inputData[row*3+col])
                        success = false;
                }
            }
            return success;
        }

        result[table[selectIdx][0] - 'A'][0]++;
        result[table[selectIdx][2] - 'A'][2]++;
        if(powerSet(selectIdx+1)) return true;
        result[table[selectIdx][0] - 'A'][0]--;
        result[table[selectIdx][2] - 'A'][2]--;


        result[table[selectIdx][0] - 'A'][1]++;
        result[table[selectIdx][2] - 'A'][1]++;
        if(powerSet(selectIdx+1)) return true;
        result[table[selectIdx][0] - 'A'][1]--;
        result[table[selectIdx][2] - 'A'][1]--;

        result[table[selectIdx][0] - 'A'][2]++;
        result[table[selectIdx][2] - 'A'][0]++;
        if(powerSet(selectIdx+1)) return true;
        result[table[selectIdx][0] - 'A'][2]--;
        result[table[selectIdx][2] - 'A'][0]--;
        return false;
    }

    private static void print() {
        for(int row=0; row<6; row++) {
            for(int col=0; col<3; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
    }
}