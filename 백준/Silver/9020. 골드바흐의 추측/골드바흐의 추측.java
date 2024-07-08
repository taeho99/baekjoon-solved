import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int[] diff = new int[10001];
        Arrays.fill(diff, Integer.MAX_VALUE);
        int[] a = new int[10001];
        int[] b = new int[10001];
        isPrime(10001);
        for(int i=0; i<10001; i++) {
            if(!isPrime[i]) continue;
            for(int j=i; j<10001; j++) {
                if(!isPrime[j] || i+j > 10000) continue;
                if(diff[i+j] > j-i) {
                    diff[i + j] = j - i;
                    a[i + j] = i;
                    b[i + j] = j;
                }
            }
        }

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(a[n]).append(' ').append(b[n]).append('\n');
        }
        System.out.print(sb);
    }

    static void isPrime(int n){
        isPrime = new boolean[n];
        // boolean배열의 default값은 false이므로 true로 바꿔주기
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아니니깐 false

        for(int i = 2; i <= Math.sqrt(n); i++) { // 2부터 n의 제곱근까지의 모든 수를 확인
            if(isPrime[i]){ // 해당수가 소수라면, 해당수를 제외한 배수들을 모두 false 처리하기
                for(int j = i*i; j< n; j += i) {//그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    isPrime[j] = false;
                }
            }
        }
    }
}
