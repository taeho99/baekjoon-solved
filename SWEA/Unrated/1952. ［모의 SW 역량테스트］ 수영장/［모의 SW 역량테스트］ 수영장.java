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
 *      2-1. [기저조건] selectMonth가 12가 될 때까 기저조건 같지만,
 *           10, 11월달에 3달 이용권을 쓰는 경우가 있으므로 기저조건은 selectMonth >= 12
 *      2-2. 1달 이용권을 선택한 경우 바로 다음달을 선택하고 sumPrice에 (1달 or 1일) 이용권 가격을 더해서 넘겨준다.
 *      2-3. 3달 이용권을 선택한 경우 바로 다음달~다다다음달 선택하고 sumPrice에 3달 이용권 가격을 더해서 넘겨준다.
 * 3. 이제 1일, 1달, 3달 이용권 중 가장 저렴한 이용권 조합의 가격은 구했다. 1년 이용권 가격과 비교해 더 저렴한걸 출력한다.
 */
public class Solution {
    static int[] price, monthPrice;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            price = new int[4];
            monthPrice = new int[12];

            // 1. 이용권 별 이용 가격과 이용 계획을 입력받는다.
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<4; idx++) {
                price[idx] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<12; idx++) {
                // 1-1. 이용 계획을 입력받을 때 1일 이용권과 1달 이용권을 비교했을 때 더 저렴한 가격을 monthPrice에 저장한다.
                int tmp = Integer.parseInt(st.nextToken()) * price[0];
                monthPrice[idx] = Math.min(tmp, price[1]);
            }

            result = Integer.MAX_VALUE;
            // 2. selectMonth달에 (1달 or 1일) 이용권을 썼을 때와 3달 이용권을 썼을 때를 비교하는 부분집합을 구한다.
            powerSet(0, 0);

            // 3. 이제 1일, 1달, 3달 이용권 중 가장 저렴한 이용권 조합의 가격은 구했다. 1년 이용권 가격과 비교해 더 저렴한걸 출력한다.
            sb.append(Math.min(result, price[3])).append('\n');
        }
        System.out.print(sb);
    }

    private static void powerSet(int selectMonth, int sumPrice) {
        // 2-1. [기저조건] selectMonth가 12가 될 때까 기저조건 같지만,
        //      10, 11월달에 3달 이용권을 쓰는 경우가 있으므로 기저조건은 selectMonth >= 12
        if(selectMonth >= 12) {
            result = Math.min(result, sumPrice);
            return;
        }

        // 2-2. 1달 이용권을 선택한 경우 바로 다음달을 선택하고 sumPrice에 (1달 or 1일) 이용권 가격을 더해서 넘겨준다.
        powerSet(selectMonth+1, sumPrice + monthPrice[selectMonth]);
        // 2-3. 3달 이용권을 선택한 경우 바로 다음달~다다다음달 선택하고 sumPrice에 3달 이용권 가격을 더해서 넘겨준다.
        powerSet(selectMonth+3, sumPrice + price[2]);
    }
}
