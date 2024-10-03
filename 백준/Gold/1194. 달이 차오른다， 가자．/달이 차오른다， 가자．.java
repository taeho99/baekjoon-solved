import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  BOJ.1194 달이차오른다가자
 *
 *  1. 가로 세로 미로 크기와 미로 정보를 입력받는다.
 *      1-1. 시작 지점을 저장한다.
 *  2. 시작 위치부터 최단 경로로 미로를 탐색하기 위해 BFS 탐색 후 결과값 출력
 *  3. 시작 위치를 큐에 넣고 방문 체크
 *  4. 큐가 빌 때까지 BFS 탐색 시작
 *      4-1. 만약 도착지점('1')에 도착했으면 탐색을 중단하고 이동 횟수(cnt) 반환
 *      4-2. 현재 위치에서 4방으로 이동 가능한지 확인
 *          4-2-1. 다음 위치가 맵의 범위를 벗어나면 제외
 *          4-2-2. 다음 위치가 벽('#')이면 제외
 *          4-2-3. 다음 위치를 현재 열쇠를 갖고 이미 방문했으면 제외
 *          4-2-4. 다음 위치가 문('A'~'F')이면서 현재 열쇠로 이동할 수 없으면 제외
 *          4-2-5. 다음 위치가 열쇠('a'~'f')이면
 *              4-2-5-1. 열쇠를 획득. 열쇠(비트마스킹) 업데이트 해주기 (현재키 | 새로 획득한열쇠)
 *          4-2-6. 다음 위치로 이동 가능!! 큐에 추가하고 방문체크 해주기
 *  5. 도착지점을 가지 못하고 BFS 탐색 종료됐으므로 -1 반환
 */
public class Main {

    static int rowSize, colSize, startRow, startCol;
    static char[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 가로 세로 미로 크기와 미로 정보를 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        map = new char[rowSize][colSize];
        for(int row=0; row<rowSize; row++) {
            String tmp = br.readLine();
            for(int col=0; col<colSize; col++) {
                map[row][col] = tmp.charAt(col);
                // 1-1. 시작 지점을 저장한다.
                if(map[row][col] == '0') {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        // 2. 시작 위치부터 최단 경로로 미로를 탐색하기 위해 BFS 탐색 후 결과값 출력
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[rowSize][colSize][64]; // 열쇠 모두 갖고있는 경우 2진수로 111111 -> 63이 최댓값

        // 3. 시작 위치를 큐에 넣고 방문 체크
        queue.add(new Point(startRow, startCol, 0, 0));
        visited[startRow][startCol][0] = true;

        // 4. 큐가 빌 때까지 BFS 탐색 시작
        while(!queue.isEmpty()) {
            Point poll = queue.poll();

            // 4-1. 만약 도착지점('1')에 도착했으면 탐색을 중단하고 이동 횟수(cnt) 반환
            if(map[poll.row][poll.col]== '1') {
                return poll.cnt;
            }

            //  4-2. 현재 위치에서 4방으로 이동 가능한지 확인
            for(int dir=0; dir<4; dir++) {
                int nRow = poll.row + dRow[dir];
                int nCol = poll.col + dCol[dir];
                int nKey = poll.isKey;

                // 4-2-1. 다음 위치가 맵의 범위를 벗어나면 제외
                if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
                // 4-2-2. 다음 위치가 벽('#')이면 제외
                if(map[nRow][nCol] == '#') continue;
                // 4-2-3. 다음 위치를 현재 열쇠를 갖고 이미 방문했으면 제외
                if(visited[nRow][nCol][poll.isKey]) continue;
                // 4-2-4. 다음 위치가 문('A'~'F')이면서 현재 열쇠로 이동할 수 없으면 제외
                if('A' <= map[nRow][nCol] && map[nRow][nCol] <= 'F'
                        && (poll.isKey & (1 << (map[nRow][nCol] - 'A'))) != (1 << map[nRow][nCol] - 'A')) continue;

                // 4-2-5. 다음 위치가 열쇠('a'~'f')이면
                if('a' <= map[nRow][nCol] && map[nRow][nCol] <= 'f') {
                    // 4-2-5-1. 열쇠를 획득. 열쇠(비트마스킹) 업데이트 해주기 (현재키 | 새로 획득한열쇠)
                    nKey = poll.isKey | (1 << (map[nRow][nCol] - 'a'));
                }

                // 4-2-6. 다음 위치로 이동 가능!! 큐에 추가하고 방문체크 해주기
                queue.add(new Point(nRow, nCol, nKey, poll.cnt+1));
                visited[nRow][nCol][nKey] = true;
            }
        }

        // 5. 도착지점을 가지 못하고 BFS 탐색 종료됐으므로 -1 반환
        return -1;
    }

    static class Point {
        int row, col, cnt;
        // 현재 열쇠획득 여부를 비트마스킹으로 저장
        // ex) 2진수: 000011 -> e,f 열쇠 있음 -> 10진수: 3 저장
        int isKey;

        public Point(int row, int col, int isKey, int cnt) {
            this.row = row;
            this.col = col;
            this.isKey = isKey;
            this.cnt = cnt;
        }
    }
}