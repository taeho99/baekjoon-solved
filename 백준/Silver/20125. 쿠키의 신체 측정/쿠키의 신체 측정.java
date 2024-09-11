import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        char[][] map = new char[size][size];
        int[] result = new int[5];

        for(int row=0; row<size; row++) {
            map[row] = br.readLine().toCharArray();
        }

        int heartRow=0, heartCol=0;

        out:
        for(heartRow=0; heartRow<size; heartRow++) {
            for(heartCol=0; heartCol<size; heartCol++) {
                if(map[heartRow][heartCol] == '*') break out;
            }
        }
        heartRow++;

        int leftArmCol;
        for(leftArmCol=heartCol-1; leftArmCol>=0; leftArmCol--) {
            if(map[heartRow][leftArmCol] == '_') break;
        }
        result[0] = heartCol - (leftArmCol + 1);

        int rightArmCol;
        for(rightArmCol=heartCol+1; rightArmCol<size; rightArmCol++) {
            if(map[heartRow][rightArmCol] == '_') break;
        }
        result[1] = (rightArmCol-1) - heartCol;

        int waistRow;
        for(waistRow=heartRow+1; waistRow<size; waistRow++) {
            if(map[waistRow][heartCol] == '_') break;
        }
        result[2] = (waistRow-1) - heartRow;

        int leftLegRow;
        for(leftLegRow=waistRow; leftLegRow<size; leftLegRow++) {
            if(map[leftLegRow][heartCol-1] == '_') break;
        }
        result[3] = leftLegRow - waistRow;

        int rightLegRow;
        for(rightLegRow=waistRow; rightLegRow<size; rightLegRow++) {
            if(map[rightLegRow][heartCol+1] == '_') break;
        }
        result[4] = rightLegRow - waistRow;

        sb.append(heartRow+1).append(' ').append(heartCol+1).append('\n');
        for (int r : result) {
            sb.append(r).append(' ');
        }

        System.out.print(sb);
    }
}