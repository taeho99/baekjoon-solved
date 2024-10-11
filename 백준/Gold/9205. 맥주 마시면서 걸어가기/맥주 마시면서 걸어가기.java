import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  BOJ.9205 맥주마시면서걸어가기
 *
 *  1. 편의점 개수를 입력받고 +2 하여 전체 좌표 개수를 구한다.
 *  2. 좌표값을 입력받아 배열에 저장하기
 *  3. 두 좌표(start, end)가 연결되었는지 구하기
 *      3-1. 최대 1000m 마다 맥주 리필해야 됨 -> 두 좌표 거리가 1000m 이하인 경우
 *          3-1-1. start <-> end 연결 표시
 *  4. 플로이드-와샬 알고리즘
 *      4-1. start -> mid 연결되어 있으면서 mid -> end 연결되어 있으면
 *          4-1-1. start -> end 연결 표시
 *  5. 시작 좌표(0)와 도착 좌표(pointCnt-1)이 연결된 경우 "happy" 아닌 경우 "sad" 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            // 1. 편의점 개수를 입력받고 +2 하여 전체 좌표 개수를 구한다.
            int pointCnt = Integer.parseInt(br.readLine()) + 2;

            // 2. 좌표값을 입력받아 배열에 저장하기
            int[][] points = new int[pointCnt][2];
            for(int idx=0; idx<pointCnt; idx++) {
                st = new StringTokenizer(br.readLine());
                points[idx][0] = Integer.parseInt(st.nextToken());
                points[idx][1] = Integer.parseInt(st.nextToken());
            }

            // 3. 두 좌표(start, end)가 연결되었는지 구하기
            boolean[][] isConnect = new boolean[pointCnt][pointCnt];
            for(int start=0; start<pointCnt; start++) {
                for(int end=start+1; end<pointCnt; end++) {
                    // 3-1. 최대 1000m 마다 맥주 리필해야 됨 -> 두 좌표 거리가 1000m 이하인 경우
                    if(getDist(points[start], points[end]) <= 1000) {
                        // 3-1-1. start <-> end 연결 표시
                        isConnect[start][end] = isConnect[end][start] = true;
                    }
                }
            }

            // 4. 플로이드-와샬 알고리즘
            for(int mid=0; mid<pointCnt; mid++) {
                for(int start=0; start<pointCnt; start++) {
                    for(int end=0; end<pointCnt; end++) {
                        //  4-1. start -> mid 연결되어 있으면서 mid -> end 연결되어 있으면
                        if(isConnect[start][mid] && isConnect[mid][end])
                            // 4-1-1. start -> end 연결 표시
                            isConnect[start][end] = true;
                    }
                }
            }

            // 5. 시작 좌표(0)와 도착 좌표(pointCnt-1)이 연결된 경우 "happy" 아닌 경우 "sad" 출력
            sb.append(isConnect[0][pointCnt-1] ? "happy" : "sad").append('\n');
        }
        System.out.print(sb);
    }

    private static int getDist(int[] start, int[] end) {
        return Math.abs(end[0] - start[0]) + Math.abs(end[1] - start[1]);
    }
}