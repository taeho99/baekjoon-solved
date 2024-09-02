import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  BOJ.15683 감시
 *
 *  1. 맵의 크기와 정보를 입력받는다.
 *  2. CCTV 정보를 리스트에 저장한다.
 *  3. 각 CCTV 방향을 선택(ex. 1번이면 상,하,좌,우 방향만 선택하고 다음 CCTV 방향 선택하러 가기)
 *      3-1. 모든 CCTV 방향 선택됐으면, 감시 영역 체크하기
 */
public class Main {
    static int rowSize, colSize, result = Integer.MAX_VALUE;
    static int[][] map;
    static List<CCTV> cctvList;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        map = new int[rowSize][colSize];

        cctvList = new ArrayList<>();
        for(int row=0; row<rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<colSize; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                if(1 <= map[row][col] && map[row][col] <= 5) {
                    cctvList.add(new CCTV(map[row][col], row, col));
                }
            }
        }

        selectCCTV(0);
        System.out.println(result);
    }

    private static void selectCCTV(int selectIdx) {
        if(selectIdx == cctvList.size()) {
            result = Math.min(result, setWatchArea());
            return;
        }

        CCTV cctv = cctvList.get(selectIdx);
        switch(cctv.type) {
            case 1:
                for(int dir=0; dir<4; dir++) {
                    cctv.direction[dir] = true;
                    selectCCTV(selectIdx + 1);
                    cctv.direction[dir] = false;
                }
                break;
            case 2:
                for(int dir=0; dir<2; dir++) {
                    cctv.direction[dir] = true;
                    cctv.direction[dir+2] = true;
                    selectCCTV(selectIdx + 1);
                    cctv.direction[dir] = false;
                    cctv.direction[dir+2] = false;
                }
                break;
            case 3:
                for(int dir=0; dir<4; dir++) {
                    cctv.direction[dir] = true;
                    cctv.direction[(dir+1)%4] = true;
                    selectCCTV(selectIdx + 1);
                    cctv.direction[dir] = false;
                    cctv.direction[(dir+1)%4] = false;
                }
                break;
            case 4:
                Arrays.fill(cctv.direction, true);
                for(int dir=0; dir<4; dir++) {
                    cctv.direction[dir] = false;
                    selectCCTV(selectIdx + 1);
                    cctv.direction[dir] = true;
                }
                break;
            case 5:
                Arrays.fill(cctv.direction, true);
                selectCCTV(selectIdx + 1);
                break;
        }
    }

    private static int setWatchArea() {
        int[][] tmp = new int[rowSize][];
        for(int row=0; row<rowSize; row++) {
            tmp[row] = map[row].clone();
        }

        for (CCTV cctv : cctvList) {
            for(int dir=0; dir<4; dir++) {
                if(!cctv.direction[dir]) continue;
                int row = cctv.row;
                int col = cctv.col;
                while(true) {
                    int nRow = row + dRow[dir];
                    int nCol = col + dCol[dir];
                    if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize || tmp[nRow][nCol] == 6) break;

                    if(tmp[nRow][nCol] == 0)
                        tmp[nRow][nCol] = -1;
                    row = nRow;
                    col = nCol;
                }
            }
        }

        return calcBlindArea(tmp);
    }

    private static int calcBlindArea(int[][] tmp) {
        int zeroCnt = 0;
        for(int row=0; row<rowSize; row++) {
            for(int col=0; col<colSize; col++) {
                if(tmp[row][col] == 0) zeroCnt++;
            }
        }
        return zeroCnt;
    }

    static class CCTV {
        int type, row, col;
        boolean[] direction; // [상,우,하,좌] 순서로 해당 방향을 감시할지 여부를 담고있음

        public CCTV(int type, int row, int col) {
            this.type = type;
            this.row = row;
            this.col = col;
            direction = new boolean[4];
        }
    }
}