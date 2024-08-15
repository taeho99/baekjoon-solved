import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ.2023 신기한 소수
 *
 * 1. 자릿수 digit을 입력받는다.
 * 2-1. digit 자릿수의 소수 중 왼쪽부터 1자리, 2자리, ... , digit자리 모두 소수인 것을 구한다.
 * 2-2. 1자리는 무조건 소수여야 하므로 2, 3, 5, 7로 시작하는 숫자만 탐색한다.
 * 2-3. 1자리는 선택된 상태이므로 selectCnt를 1로 넘긴다.
 * 3. [기저조건] digit 자릿수까지 선택이 되었다면 그 수가 소수인지 확인한다. 소수면 출력
 * 4. 현재 수에 다음 자릿수(홀수)를 더하고 소수인지 확인한다. 소수면 탐색을 이어나간다.
 */
public class Main {
    static int digit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 자릿수 digit을 입력받는다.
        digit = Integer.parseInt(br.readLine());

        // 2-1. digit 자릿수의 소수 중 왼쪽부터 1자리, 2자리, ... , digit자리 모두 소수인 것을 구한다.
        // 2-2. 1자리는 무조건 소수여야 하므로 2, 3, 5, 7로 시작하는 숫자만 탐색한다.
        // 2-3. 1자리는 선택된 상태이므로 selectCnt를 1로 넘긴다.
        search(2, 1);
        search(3, 1);
        search(5, 1);
        search(7, 1);

        System.out.print(sb);
    }

    static void search(int number, int selectCnt) {
        // 3. [기저조건] digit 자릿수까지 선택이 되었다면 그 수가 소수인지 확인한다. 소수면 출력
        if(selectCnt == digit) {
            sb.append(number).append('\n');
            return;
        }

        // 4. 현재 수에 다음 자릿수(홀수)를 더하고 소수인지 확인한다. 소수면 탐색을 이어나간다.
        for(int nextNumber=1; nextNumber<=9; nextNumber+=2) {
            if(isPrime(number*10 + nextNumber)) {
                search(number*10 + nextNumber, selectCnt + 1);
            }
        }
    }

    static boolean isPrime(int n) {
        for(int i=2; i<=Math.sqrt(n); i++)
            if(n%i == 0)
                return false;
        return true;
    }
}
