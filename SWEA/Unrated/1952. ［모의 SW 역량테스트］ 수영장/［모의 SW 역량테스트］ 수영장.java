import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/**
 *  SWEA.1952 수영장
 *
 *  1. 이용권 별 이용 가격과 이용 계획을 입력받는다.
 *      1-1. 이용 계획을 입력받을 때 1일 이용권과 1달 이용권을 비교했을 때 더 저렴한 가격을 monthPrice에 저장한다.
 *  2. selectMonth달에 (1달 or 1일) 이용권을 썼을 때와 3달 이용권을 썼을 때를 비교하는 부분집합을 구한다.
 *      2-1. [가지치기] 현재까지 조합의 가격이 최소 조합의 가격보다 높거나 같으면 종료.
 *      2-2. [기저조건] selectMonth가 12가 될 때까 기저조건 같지만,
 *           10, 11월달에 3달 이용권을 쓰는 경우가 있으므로 기저조건은 selectMonth >= 12
 *      2-3. 현재 달에 1일 이용권으로만 쓴 경우
 *      2-4. 현재 달을 1달 이용권으로 쓴 경우
 *      2-5. 현재 달에서 3달 이용권을 쓴 경우
 *      2-6. 1년 이용권을 쓴 경우
 * 3. 이제 1일, 1달, 3달 이용권 중 가장 저렴한 이용권 조합의 가격은 구했다. 1년 이용권 가격과 비교해 더 저렴한걸 출력한다.
 */
public class Solution {
    static int[] price, plan;
    static int minPrice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            price = new int[4];
            plan = new int[12];
 
            // 1. 이용권 별 이용 가격과 이용 계획을 입력받는다.
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<4; idx++) {
                price[idx] = Integer.parseInt(st.nextToken());
            }
 
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<12; idx++) {
                plan[idx] = Integer.parseInt(st.nextToken());
            }
 
            minPrice = Integer.MAX_VALUE;
            // 2. selectMonth달에 어떤 이용권을 쓸 지 모두 완전탐색 하되 가지치기 한다.(백트래킹)
            backtrack(0, 0);
 
            // 3. 최소 조합의 가격을 출력한다.
            sb.append(minPrice).append('\n');
        }
        System.out.print(sb);
    }
 
    private static void backtrack(int selectMonth, int sumPrice) {
    	// 2-1. [가지치기] 현재까지 조합의 가격이 최소 조합의 가격보다 높거나 같으면 종료.
    	if(sumPrice >= minPrice) {
    		return;
    	}
        // 2-2. [기저조건] selectMonth가 12가 될 때까 기저조건 같지만,
        //      10, 11월달에 3달 이용권을 쓰는 경우가 있으므로 기저조건은 selectMonth >= 12
        if(selectMonth >= 12) {
        	minPrice = sumPrice;
            return;
        }
 
        // 2-3. 현재 달에 1일 이용권으로만 쓴 경우
        backtrack(selectMonth+1, sumPrice + plan[selectMonth]*price[0]);
        // 2-4. 현재 달을 1달 이용권으로 쓴 경우
        backtrack(selectMonth+1, sumPrice + price[1]);
        // 2-5. 현재 달에서 3달 이용권을 쓴 경우
        backtrack(selectMonth+3, sumPrice + price[2]);
        // 2-6. 1년 이용권을 쓴 경우
        backtrack(selectMonth+12, sumPrice + price[3]);
    }
}