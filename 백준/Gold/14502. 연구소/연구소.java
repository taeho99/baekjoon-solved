import java.io.*;
import java.util.*;

public class Main {
    static int rowSize, colSize, maxSafeArea = 0;
    static int[][] map;
    static final int[] dRow = {-1, 1, 0, 0};
    static final int[] dCol = {0, 0, -1, 1};

    static List<int[]> virusList = new ArrayList<>();
    static List<int[]> emptyList = new ArrayList<>();
    static int emptyCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        map = new int[rowSize][colSize];

        for (int r = 0; r < rowSize; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < colSize; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 0) emptyList.add(new int[]{r, c});
                else if (map[r][c] == 2) virusList.add(new int[]{r, c});
            }
        }

        emptyCount = emptyList.size(); // 전체 빈 칸 수
        combineWalls(0, 0);            // (depth, startIndex)
        System.out.println(maxSafeArea);
    }

    // 빈 칸 리스트에서 조합 C(emptyCount, 3)만 생성
    static void combineWalls(int depth, int start) {
        if (depth == 3) {
            int spread = bfsSpreadCount();                 // 새로 감염된 칸 수
            int safe = emptyCount - 3 - spread;            // 안전 구역: 전체 빈칸 - 벽3 - 감염
            if (safe > maxSafeArea) maxSafeArea = safe;
            return;
        }

        for (int i = start; i < emptyList.size(); i++) {
            int r = emptyList.get(i)[0];
            int c = emptyList.get(i)[1];
            if (map[r][c] != 0) continue;                  // 혹시 중복 보호
            map[r][c] = 1;                                 // 벽 세우기
            combineWalls(depth + 1, i + 1);                // 조합: 다음 시작은 i+1
            map[r][c] = 0;                                 // 복구
        }
    }

    // 다중 시작 BFS 한 번으로 전체 전파, 맵은 수정하지 않고 visited만 사용
    static int bfsSpreadCount() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[rowSize][colSize];

        for (int[] v : virusList) {
            q.addLast(v);
            visited[v[0]][v[1]] = true;
        }

        int spread = 0; // 새로 감염된 빈 칸 수
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dRow[d], nc = c + dCol[d];
                if (nr < 0 || nr >= rowSize || nc < 0 || nc >= colSize) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] != 0) continue;            // 벽(1) 또는 바이러스(2)는 전파 불가

                visited[nr][nc] = true;
                q.addLast(new int[]{nr, nc});
                spread++;                                  // 빈 칸이 새로 감염됨
            }
        }
        return spread;
    }
}
