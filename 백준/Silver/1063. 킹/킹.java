import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static String[] rowNames = {"8", "7", "6", "5", "4", "3", "2", "1"};
    static String[] colNames = {"A", "B", "C", "D", "E", "F", "G", "H"};
    static int[] dRow = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dCol = {1, -1, 0, 0, 1, -1, 1, -1};
    static HashMap<String, Integer> dirMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] kingPos = getPos(st.nextToken());
        int[] stonePos = getPos(st.nextToken());
        int totalMoveCnt = Integer.parseInt(st.nextToken());

        while(totalMoveCnt-- > 0) {
            int dir = dirMap.get(br.readLine());
            int nRow = kingPos[0] + dRow[dir];
            int nCol = kingPos[1] + dCol[dir];

            if (nRow < 0 || nRow >= 8 || nCol < 0 || nCol >= 8) continue;

            if (nRow == stonePos[0] && nCol == stonePos[1]) {
                int stoneNRow = stonePos[0] + dRow[dir];
                int stoneNCol = stonePos[1] + dCol[dir];

                if (stoneNRow < 0 || stoneNRow >= 8 || stoneNCol < 0 || stoneNCol >= 8) continue;

                stonePos[0] = stoneNRow;
                stonePos[1] = stoneNCol;
            }
            kingPos[0] = nRow;
            kingPos[1] = nCol;
        }

        System.out.println(colNames[kingPos[1]] + rowNames[kingPos[0]]);
        System.out.println(colNames[stonePos[1]] + rowNames[stonePos[0]]);
    }

    static void init() {
        dirMap.put("R", 0);
        dirMap.put("L", 1);
        dirMap.put("B", 2);
        dirMap.put("T", 3);
        dirMap.put("RT", 4);
        dirMap.put("LT", 5);
        dirMap.put("RB", 6);
        dirMap.put("LB", 7);
    }

    static int toIntRow(char charRow) {
        return (charRow - '0' - 8) * -1;
    }

    static int toIntCol(char charCol) {
        return charCol - 'A';
    }

    static int[] getPos(String strPos) {
        return new int[] {toIntRow(strPos.charAt(1)), toIntCol(strPos.charAt(0))};
    }
}