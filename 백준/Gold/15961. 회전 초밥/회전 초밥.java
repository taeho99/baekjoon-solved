import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 	BOJ.15961 회전초밥
 * 
 * 	1. 접시의 수, 초밥 종류의 수, 연속해서 먹어야하는 접시의 수, 쿠폰 초밥 종류를 입력받는다.
 * 	2. 초밥 종류를 입력받는다.
 * 	3. 쿠폰 초밥은 무조건 먹어야 이득이다.
 * 		3-1. 쿠폰 초밥을 먹었다고 표시하기
 * 		3-2. 쿠폰 초밥을 먹었으므로 총 먹은 초밥 가짓수를 1로 초기화
 * 	4. 맨 앞부터 연속으로 초밥 먹기
 * 		4-1. 만약 아직 먹지 못한 초밥 종류면, 먹은 초밥 가짓수 1 증가
 * 		4-2. 해당 초밥 먹었다고 표시
 * 	5. 오른쪽으로 한칸씩 이동하며 초밥 먹기
 * 		5-1. 가장 왼쪽에 있는 초밥 먹은거 취소
 * 		5-2. 만약 그 종류의 초밥을 하나도 안먹었으면, 먹은 초밥 가짓수 1 감소
 * 		5-3. 가장 오른쪽에 있는 초밥 먹기
 * 		5-4. 만약 아직 먹지 못한 초밥 종류면, 먹은 초밥 가짓수 1 증가
 * 		5-5. 최대 먹은 초밥 가짓수 갱신
 * 	6. 최대 먹은 초밥 가짓수 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. 접시의 수, 초밥 종류의 수, 연속해서 먹어야하는 접시의 수, 쿠폰 초밥 종류를 입력받는다.
        int plateCnt = Integer.parseInt(st.nextToken());
        int typeCnt = Integer.parseInt(st.nextToken());
        int continuousCnt = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());
        
        // 2. 초밥 종류를 입력받는다.
        int[] plates = new int[plateCnt];
        for(int i=0; i<plateCnt; i++) {
            plates[i] = Integer.parseInt(br.readLine());
        }


        // 3. 쿠폰 초밥은 무조건 먹어야 이득이다.
        int[] visited = new int[typeCnt+1]; // 해당 종류의 초밥을 먹었는지 표시
        // 3-1. 쿠폰 초밥을 먹었다고 표시하기
        visited[coupon]++;
        // 3-2. 쿠폰 초밥을 먹었으므로 총 먹은 초밥 가짓수를 1로 초기화
        int eatCnt = 1;
        
        // 4. 맨 앞부터 연속으로 초밥 먹기
        for(int i=0; i<continuousCnt; i++) {
        	// 4-1. 만약 아직 먹지 못한 초밥 종류면, 먹은 초밥 가짓수 1 증가
            if(visited[plates[i]] == 0) eatCnt++;
            // 4-2. 해당 초밥 먹었다고 표시
            visited[plates[i]]++;
        }
        
        int max = eatCnt;
        
        // 5. 오른쪽으로 한칸씩 이동하며 초밥 먹기
        for(int i=1; i<plateCnt; i++) {
        	// 5-1. 가장 왼쪽에 있는 초밥 먹은거 취소
            visited[plates[i - 1]]--;
            // 5-2. 만약 그 종류의 초밥을 하나도 안먹었으면, 먹은 초밥 가짓수 1 감소
            if(visited[plates[i-1]] == 0) eatCnt--;
            // 5-3. 가장 오른쪽에 있는 초밥 먹기
            if(visited[plates[(i+continuousCnt-1)%plateCnt]] == 0) eatCnt++;
            // 5-4. 만약 아직 먹지 못한 초밥 종류면, 먹은 초밥 가짓수 1 증가
            visited[plates[(i+continuousCnt-1)%plateCnt]]++;
            // 5-5. 최대 먹은 초밥 가짓수 갱신
            max = Math.max(max, eatCnt);
        }
        
        // 6. 최대 먹은 초밥 가짓수 출력
        System.out.print(max);
    }
}